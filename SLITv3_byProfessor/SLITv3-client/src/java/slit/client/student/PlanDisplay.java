package slit.client.student;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import slit.ejb.plan.PlanBeanRemote;
import slit.ejb.plan.PlanItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import slit.client.Main;

/**
 * This class is used to display the user's plan. It is intended to show you how
 * you can create customized user interface components. You can use this just
 * like any other Swing component, so if you need to show the plan in several
 * different places, you would just create an instance of this class for each
 * place.
 *
 * @author evenal
 */
public class PlanDisplay extends Box
{

    /**
     * This is a custom swing component for displaying a student's plan. It is
     * constructed by combining ordinary swing components. The text field
     * comment is used to display a comment on the status. Model is used to
     * display the actual plan in a table
     */
    private JTextArea comment;
    private PlanModel model;

    /**
     * Set up an instance of our custom component
     */
    public PlanDisplay() {
        // Box and BoxLayout are tightly connected, see the Swing tutorial!
        // The comment will be displayed above the tabular display of the plan
        super(BoxLayout.Y_AXIS);
        comment = new JTextArea(20, 3);
        comment.setLineWrap(true);
        comment.setWrapStyleWord(true);
        add(comment);

        model = new PlanModel();
        JTable plan = new JTable(model);
        plan.setDefaultRenderer(Date.class, new DateRenderer());
        JScrollPane scrollPane = new JScrollPane(plan);
        add(scrollPane);
        setPreferredSize(new Dimension(150, 200));
    }

    public void getPlan(String student) {
        PlanBeanRemote planBean = Main.getPlanBean();
        // We get the data from the ejb
        System.out.println("Getting plan");
        List<PlanItem> plan = planBean.getPlan(student);
        // and update the  comment, and model fields with the
        // new data
        System.out.println(plan);
        System.out.flush();
        comment.setText(planBean.getComment(student));
        model.setData(plan);
    }

    /**
     * This is a table cell renderer. It is used in the JTable that displays the
     * plan, to show dates in a more compact format than the default renderer.
     * Note that the table must be told to use this renderer - see the
     * plandisplay constructor above
     */
    private class DateRenderer extends DefaultTableCellRenderer
    {

        SimpleDateFormat formatter;

        public DateRenderer() {
            formatter = new SimpleDateFormat("d MMM");
        }

        public void setValue(Object value) {
            String formatted = "";
            if (null == value)
                return;
            if (value instanceof String)
                formatted = (String) value;
            else
                formatted = formatter.format(value);
            setText(formatted);
        }
    }

    /**
     * This class is a tablemodel. A table model handles the data that is
     * displayed in a JTable. This table model handles the table of module,
     * planned and actual date for approval of modules
     */
    private class PlanModel implements TableModel
    {

        // this is the data that the table will display
        List<PlanItem> data;

        // Set the data
        public void setData(List<PlanItem> plan) {
            this.data = plan;
            fireTableChanged();
        }

        // tell all the listeners that the table data has changed
        private void fireTableChanged() {
            TableModelEvent e = new TableModelEvent(this);
            for (TableModelListener l : listeners) {
                l.tableChanged(e);
            }
        }

        // The following methods implement the methods specifiend
        // in the TableModel interface.
        // There is a good explanation in the swing tutorial.
        @Override
        public int getRowCount() {
            if (null == data)
                return 0;
            else
                return data.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return "Module";
            case 1:
                return "Planned";
            case 2:
                return "Approved";
            default:
                throw new IllegalArgumentException("Illegal column index");
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Date.class;
            case 2:
                return Date.class;
            default:
                throw new IllegalArgumentException("Illegal column index");
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (rowIndex >= 0 && rowIndex < data.size()) {
                PlanItem item = data.get(rowIndex);
                switch (columnIndex) {
                case 0:
                    return new Integer(item.module);
                case 1:
                    return item.plannedDate;
                case 2:
                    if (item.approvedDate == null)
                        return "";
                    else
                        return item.approvedDate;
                }
            }
            throw new IllegalArgumentException("Illegal column index");
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // do nothing
        }

        private ArrayList<TableModelListener> listeners = new ArrayList<>();

        @Override
        public void addTableModelListener(TableModelListener l) {
            listeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            listeners.remove(l);
        }

    }
}
