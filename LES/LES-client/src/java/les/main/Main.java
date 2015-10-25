/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.main;

import javax.ejb.EJB;
import les.ejb.plan.PlanBeanRemote;
import les.client.Login;



/**
 *
 * @author Jorgen
 */
public class Main {
    
    
    @EJB
    static PlanBeanRemote planBean;
    
    //static variable thats called in main() further down
    public static final Main instance = new Main();
    //Make a connection to les.client.Login class
    private Login loginWindow;
    
    public Login getLoginWindow() {
        return loginWindow;
    }
    
    /**
     * This method is called from main to do the real work of starting the
     * application
     */
    public void run() {
        // the first few linex just test the connection to the server
        if (null == planBean) {
            throw new IllegalStateException("EJB connection failed");
        }
        System.out.println("Will be using planBean=" + planBean);
        
        //This will make Login the first window to launch when running main.java
        Login.launch(Login.class);
    }
    
    //main method further down call this togheter with static variable instance
    public static PlanBeanRemote getPlanBean() {
        System.out.println("Getting planBean=" + planBean);
        return planBean;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("Starting client");
        System.out.flush();
        instance.run();
    }
    
}

    

