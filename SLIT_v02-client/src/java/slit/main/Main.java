/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.main;

import beans.InitializeDatabaseBeanRemote;
import beans.ProgressManagerBeanRemote;
import javax.ejb.EJB;


/**
 *
 * @author Jons
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @EJB
    private static InitializeDatabaseBeanRemote dataCreator;
    
    /**
     * Reference to the remote class in SLIT-lib
     * TODO Error message: Java Application Thread NullPointer
     */
    @EJB 
    private static ProgressManagerBeanRemote pmbr;

    /**
     * createDatabase() is initialized in DatabaseBean. It creates all tables
     * to our database and input data to them. This has to be run once on each 
     * computer. For the least amount of bugs, open MySQL workbench and create 
     * a schema called "slit" before this method is run. 
     * @param args 
     */
    public static void main(String[] args) {
        dataCreator.createDatabase();
//        System.out.println(pmbr.theProgress());
    }
    
}
