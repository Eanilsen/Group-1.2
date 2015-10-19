package is202.swingutils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * This class can be used to create forms, consisting of
 * label/inputcontrol pairs. It can handle multicolumn forms.
 * The labels and input controls will be lined up vertically.
 *
 * The label/inputcontrol pairs are added from left to right.
 * The labels are right-adjusted, and the input controls
 * left-adjusted.
 *
 * @author even
 */
public class GridForm extends JPanel
{

    int columns;
    GridBagConstraints labelConstraints;
    GridBagConstraints inputConstraints;

    /**
     * Create a form with the specificed number of columns.
     * Note: Each column contains label/input control pairs, so
     * in a two-columh form each row will be: label input label input
     *
     * @param columns the number of columns
     */
    public GridForm(int columns) {
        this.columns = 2 * columns; // labels and inputs
        setLayout(new GridBagLayout());
        Insets insets = new Insets(1, 1, 1, 1);
        labelConstraints = new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST,
                GridBagConstraints.BOTH,
                insets, 0, 0);
        inputConstraints = new GridBagConstraints(1, 0, 1, 1, 1, 0,
                GridBagConstraints.WEST,
                GridBagConstraints.BOTH,
                insets, 0, 0);
    }

    /**
     * Create a form with the specified number of columns. Note that
     * the inputs and labels lists must have the same size()
     *
     * @param columns the number of columns
     * @param inputs  the input controls
     * @param labels  the labels for the input controls
     */
    public GridForm(int columns,
                    List<JComponent> inputs,
                    List<String> labels) {
        this(columns);
        addInputs(inputs, labels);
    }

    /**
     * Add inputs to the form. Both lists must have the same size.
     *
     * @param inputs
     * @param labels
     */
    public void addInputs(List<JComponent> inputs,
                          List<String> labels) {
        if (inputs.size() != labels.size())
            throw new IllegalArgumentException("Gridform.addInputs():"
                    + " inputs and labels must have the same size");
        for (int i = 0; i < inputs.size(); i++) {
            addInput(inputs.get(i), labels.get(i));

        }
    }

    /**
     * Add a single input control
     *
     * @param input  the input control
     * @param prompt the label
     */
    public void addInput(JComponent input, String prompt) {
        JLabel label = new JLabel(prompt);
        label.setHorizontalAlignment(JLabel.TRAILING);
        add(label, labelConstraints);
        labelConstraints.gridx += 2;
        add(input, inputConstraints);
        inputConstraints.gridx += 2;
        if (inputConstraints.gridx > columns) {
            labelConstraints.gridx = 0;
            inputConstraints.gridx = 1;
            labelConstraints.gridy++;
            inputConstraints.gridy++;
        }
        System.out.println("Added " + prompt + " " + input);
    }

    // test code
    static GridForm getTestInstance() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("En");
        labels.add("To");
        labels.add("Tre");
        labels.add("Fire");
        labels.add("Fem");
        labels.add("Seks");
        labels.add("Syv");
        ArrayList<JComponent> fields = new ArrayList<>();
        fields.add(new JTextField("En"));
        fields.add(new JTextField("To"));
        fields.add(new JTextField("Tre"));
        fields.add(new JTextField("Fire"));
        fields.add(new JTextField("Fem"));
        fields.add(new JTextField("Seks"));
        fields.add(new JTextField("Syv"));
        GridForm grid = new GridForm(3, fields, labels);
        return grid;
    }

    public static void main(String[] args) {
        MainWindow frame = new MainWindow("LabeledInputGrid Test");
        frame.setContentPane(getTestInstance());
        frame.pack();
        frame.setVisible(true);
    }
}
