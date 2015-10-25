/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import testGUI.Login;



/**
 *
 * @author Jorgen
 */
public class Main {
    

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
        
        System.out.println("Will be using planBean=" );
        
        Login.launch(Login.class);
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

    

