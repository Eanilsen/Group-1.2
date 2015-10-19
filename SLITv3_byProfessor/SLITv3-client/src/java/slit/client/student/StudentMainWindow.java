package slit.client.student;

import slit.ejb.module.ModuleBeanRemote;
import java.awt.BorderLayout;
import javax.ejb.EJB;
import javax.swing.JLabel;
import javax.swing.JPanel;
import is202.swingutils.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * This class is the main student window, i.e. what the student will see after
 * logging in.
 *
 * @author evenal
 */
public class StudentMainWindow extends MainWindow
{

    // This is the name that the server has given to the PlanBean ejb,
    // it is used to find the ejb from the clien
    public static final String EJB_JNDI_NAME = "java:global/SLIT/SLIT-ejb/PlanBean!slit.ejb.plan.PlanBeanRemote";

    PlanDisplay plan;
    ModuleDisplay module;
    JPanel toolbar;

    /**
     * The constructor sets up the window. It may change contentPane, and/or the
     * layout manager before it adds the components. It should return when the
     * window is ready.
     */
    public StudentMainWindow() {
        // call the superclass constructor to set the title on the window frame
        super("SLIT - Student view");
        // create a new contentpane with a borderlayout
        // (3,3 is the gap between components)
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(3, 3));
        setContentPane(contentPane);

        // the labels are just placeholders - to show where real
        // components will be added later
        toolbar = new JPanel();
        JButton getDataButton = new JButton(new GetDataAction());
        toolbar.add(getDataButton);
        contentPane.add(toolbar, BorderLayout.NORTH);

        module = new ModuleDisplay();
        contentPane.add(module, BorderLayout.CENTER);

        plan = new PlanDisplay();
        contentPane.add(plan, BorderLayout.WEST);

        JLabel status = new JLabel("Status");
        contentPane.add(status, BorderLayout.SOUTH);
        fetchData();
        pack();
        center();
    }

    public void fetchData() {
        plan.getPlan("En student");
        module.setModule(1);
    }

    public JPanel getToolBar() {
        return toolbar;
    }

    private class GetDataAction extends AbstractAction
    {

        public GetDataAction() {
            super("Get some data...");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fetchData();
        }

    }
}
