/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.client;

import javax.ejb.EJB;
import slit.client.student.StudentMainWindow;
import slit.ejb.TestBeanRemote;
import slit.ejb.filetransfer.FileTransferRemote;
import slit.ejb.module.ModuleBeanRemote;
import slit.ejb.plan.PlanBeanRemote;

/**
 * This is the main class for the client. The main class is the entry point,
 * i.e. where the program starts - with a call to the method main()
 *
 * @author even
 */
public class Main
{

    // The ejb references do not work if you put them where you need them.
    // you have to put them in the main class, and write get methods
    // that can be used when you need an ejb.
    @EJB
    static TestBeanRemote testBean;
    // we will call the ejb to get data
    @EJB
    static PlanBeanRemote planBean;

    @EJB
    private static ModuleBeanRemote moduleBean;

    @EJB
    private static FileTransferRemote fileTransferBean;

    public static final Main instance = new Main();
    private StudentMainWindow mainWindow;

    private Main() {
    }

    public StudentMainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * This method is called from main to do the real work of starting the
     * application
     */
    public void run() {
        // the first few linex just test the connection to the server
        if (null == testBean)
            throw new IllegalStateException("EJB connection failed");
        System.out.println("Got EJB connection, calling business metho...");
        System.out.println(testBean.echo("Client here..."));
        System.out.println("Connections tested, starting real client...");
        System.out.println("Will be using planBean=" + planBean);

        // if the server is available, create and display the gui
        mainWindow = new StudentMainWindow();
        mainWindow.setVisible(true);
    }

    public static PlanBeanRemote getPlanBean() {
        System.out.println("Getting planBean=" + planBean);
        return planBean;
    }

    public static ModuleBeanRemote getModuleBean() {
        System.out.println("Getting moduleBean=" + moduleBean);
        return moduleBean;
    }

    public static FileTransferRemote getFileTransferBean() {
        return fileTransferBean;
    }

    /**
     * This is the starting point of the application. main() will be called by
     * the runtime system when the program starts.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("Starting client");
        System.out.flush();
        instance.run();
    }

}
