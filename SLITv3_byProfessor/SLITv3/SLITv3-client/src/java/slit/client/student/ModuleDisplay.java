package slit.client.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import slit.client.Main;
import slit.ejb.filetransfer.FileTransfer;
import slit.ejb.filetransfer.FileTransferRemote;
import slit.ejb.filetransfer.Resource;

/**
 *
 * @author evenal
 */
public class ModuleDisplay extends JPanel
{

    // JFileChooser is a file selection dialog
    private JFileChooser fileChooser;

    // this is a multiline textfield, and will be used to
    // display the module description
    private JTextArea description;
    // list of downloadable resources
    JList resourceList;
    // resource info
    List<Resource> resList;

    public ModuleDisplay() {
        super(new BorderLayout(3, 3));

        // set up the module desc. field
        description = new JTextArea(30, 60);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        add(new JScrollPane(description), BorderLayout.CENTER);

        // add a panel for up- and download buttons
        JPanel buttons = new JPanel();
        add(buttons, BorderLayout.SOUTH);
        JButton uploadButton = new JButton(new UploadAction());
        buttons.add(uploadButton);
        JButton downlButton = new JButton(new DownloadAction());
        buttons.add(downlButton);

        // create a scrollable list of resources
        resourceList = new JList();
        resourceList.setLayoutOrientation(JList.VERTICAL);
        resourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resourceList.setMinimumSize(new Dimension(20, 60));
        // the next two lines (commented out) will trigger a downlad
        // immediately whenever the user selected a resource
//        ListSelectionModel selMod = resourceList.getSelectionModel();
//        selMod.addListSelectionListener(new DownloadSelected());
        add(new JScrollPane(resourceList), BorderLayout.EAST);
        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
    }

    /**
     * The intention was that this method should be called just after login, so
     * the student would see the module (s)he is working on when the program has
     * started
     *
     * @param moduleId mudule to show
     */
    public void setModule(long moduleId) {
        System.out.println("Selected module " + moduleId);
        description.setText(Main.getModuleBean().getDescription(moduleId));
        resList = Main.getModuleBean().getResourceInfo((int) moduleId);
        resourceList.setModel(new ResourceListModel(resList));
    }

    /**
     * Select the file to upload, and do the upload
     *
     * @param file
     * @throws IOException
     */
    private void uploadFile(File file) throws IOException {
        String filename = file.getName();
        System.out.println("");
        System.out.println("Uploading file" + filename);
        byte[] content = readFile(file);
        System.out.println("Create file transfer object");
        FileTransfer ft = new FileTransfer(0, "Assignment", filename, content);
        System.out.println("calling file transfer ejb");
        Main.getFileTransferBean().upload(ft);
    }

    /**
     * Read the file into a byte array before upload
     *
     * @param file
     * @return
     * @throws IOException
     */
    private byte[] readFile(File file) throws IOException {
        long longSize = (int) file.length();
        if (longSize > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("File is too large to upload");
        }
        int size = (int) longSize;
        byte[] content = new byte[size];
        InputStream in = new FileInputStream(file);

        int bytesRead = 0;
        while (bytesRead < size) {
            int n = in.read(content, bytesRead, size - bytesRead);
            System.out.format("Read %d (total %d) bytes of %d\n",
                              n, n + bytesRead, size);
            if (n == -1) {
                System.out.println("EOF");
                break;
            }
            bytesRead += n;
        }
        in.close();
        return content;
    }

    /**
     * Save downloaded file. This method is simpler than the readFile(), and not
     * so bomb-proof
     *
     * @param file
     * @param content
     * @throws IOException
     */
    private void saveFile(File file, byte[] content) throws IOException {
        OutputStream out = new FileOutputStream(file);
        out.write(content);
        out.close();
    }

    /**
     * This listener can be used to download a file when the user selects a
     * resource in the list, without waiting for a button to be pressed
     */
    public class DownloadSelected implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = e.getFirstIndex();
            ResourceListModel model = (ResourceListModel) resourceList.getModel();
            long id = model.getFileId(index);
            try {
                FileTransfer ft = Main.getFileTransferBean().download(id);
                fileChooser.setSelectedFile(new File(ft.getFilename()));
                int retVal = fileChooser.showSaveDialog(ModuleDisplay.this);
                if (retVal == JFileChooser.APPROVE_OPTION)
                    saveFile(fileChooser.getSelectedFile(), ft.getFileContent());
            }
            catch (IOException ioe) {
                JOptionPane.showMessageDialog(ModuleDisplay.this,
                                              ioe.getLocalizedMessage(),
                                              "Download failed!",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void downloadResource(Resource res) throws IOException {
        FileTransferRemote bean = Main.getFileTransferBean();
        FileTransfer ft = bean.download(res.getFileId());
        fileChooser.setSelectedFile(new File(ft.getFilename()));
        int retval = fileChooser.showSaveDialog(ModuleDisplay.this);
        if (retval == JFileChooser.APPROVE_OPTION)
            saveFile(fileChooser.getSelectedFile(), ft.getFileContent());
    }

    /**
     * This class is used in the download button, to starat downloading the
     * resource that is selected in the list
     */
    private class DownloadAction extends AbstractAction
    {

        public DownloadAction() {
            super("Download resource");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = resourceList.getSelectedIndex();
            Resource res = resList.get(index);
            try {
                downloadResource(res);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Upload an assignment
     */
    private class UploadAction extends AbstractAction
    {

        public UploadAction() {
            super("Upload assignment");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int status = fileChooser.showOpenDialog(ModuleDisplay.this);
            if (JFileChooser.APPROVE_OPTION == status) {
                File file = fileChooser.getSelectedFile();
                try {
                    uploadFile(file);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(ModuleDisplay.this,
                                                  ex.getLocalizedMessage(),
                                                  "Problem uploading file:",
                                                  JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }
    }
}
