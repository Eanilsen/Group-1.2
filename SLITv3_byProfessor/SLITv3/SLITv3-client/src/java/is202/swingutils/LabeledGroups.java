package is202.swingutils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;



/**
 * This convenience class arranges a number of forms vertically,
 * with a heading (a JLabel) for each form
 *
 * @author even
 */
public class LabeledGroups extends JPanel
{

    GridBagConstraints groupConstraints;
    GridBagConstraints labelConstraints;

    public LabeledGroups() {
        setLayout(new GridBagLayout());

        labelConstraints = new GridBagConstraints();
        labelConstraints.fill = GridBagConstraints.VERTICAL;
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.insets = new Insets(10, 5, 5, 5);

        groupConstraints = new GridBagConstraints();
        groupConstraints.gridx = 0;
        groupConstraints.fill = GridBagConstraints.BOTH;
        groupConstraints.gridy = 1;
        groupConstraints.insets = new Insets(5, 5, 5, 5);
    }

    public LabeledGroups(ArrayList<JPanel> groups) {
        this();

        for (int i = 0; i < groups.size(); i++) {
            JPanel group = groups.get(i);
            addGroup(group);
        }
    }

    public void addGroup(JPanel group) {
        add(new JLabel(group.getName()), labelConstraints);
        labelConstraints.gridy += 2;
        add(group, groupConstraints);
        group.setBorder(new EtchedBorder());
        groupConstraints.gridy += 2;
    }

    public static void main(String[] args) {
        ArrayList<String> labels = new ArrayList<>();
        ArrayList<JComponent> fields = new ArrayList<>();
        MainWindow win = new MainWindow("LabeledGroups Test");

        labels.add("En");
        labels.add("To");
        labels.add("Tre");
        labels.add("Fire");
        labels.add("Fem");
        labels.add("Seks");
        labels.add("Syv");
        fields.add(new JTextField("En"));
        fields.add(new JTextField("To"));
        fields.add(new JTextField("Tre"));
        fields.add(new JTextField("Fire"));
        fields.add(new JTextField("Fem"));
        fields.add(new JTextField("Seks"));
        fields.add(new JTextField("Syv"));

        JPanel gr1 = new GridForm(3, fields, labels);
        gr1.setName("Group one");

        labels.clear();
        fields.clear();
        labels.add("En");
        labels.add("To");
        labels.add("Tre");
        labels.add("Fire");
        labels.add("Fem");
        labels.add("Seks");
        labels.add("Syv");
        fields.add(new JTextField("En"));
        fields.add(new JTextField("To"));
        fields.add(new JTextField("Tre"));
        fields.add(new JTextField("Fire"));
        fields.add(new JTextField("Fem"));
        fields.add(new JTextField("Seks"));
        fields.add(new JTextField("Syv"));
        JPanel gr2 = new GridForm(3, fields, labels);
        gr2.setName("Group two");

        labels.clear();
        fields.clear();
        labels.add("En");
        labels.add("To");
        labels.add("Tre");
        labels.add("Fire");
        labels.add("Fem");
        labels.add("Seks");
        labels.add("Syv");
        fields.add(new JTextField("En"));
        fields.add(new JTextField("To"));
        fields.add(new JTextField("Tre"));
        fields.add(new JTextField("Fire"));
        fields.add(new JTextField("Fem"));
        fields.add(new JTextField("Seks"));
        fields.add(new JTextField("Syv"));
        JPanel gr3 = new GridForm(3, fields, labels);
        gr3.setName("Group three");

        LabeledGroups labGr = new LabeledGroups();
        labGr.addGroup(gr1);
        labGr.addGroup(gr2);
        labGr.addGroup(gr3);

        win.setContentPane(labGr);
        win.pack();
        win.setVisible(true);
    }
}
