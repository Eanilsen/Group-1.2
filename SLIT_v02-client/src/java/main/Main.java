/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.InitializeDatabaseBeanRemote;
import beans.ProgressManagerBeanRemote;
import beans.UserManagerBeanRemote;
import javax.ejb.EJB;
import slit.GUI.Launcher;


/**
 * Creates some sample Data in the Database
 * only run this file once when you dont have your database populated.
 * @author Jons
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    @EJB
    private static UserManagerBeanRemote myUserManager;
    
    @EJB
    private static ProgressManagerBeanRemote pmb;
    
    public static ProgressManagerBeanRemote getProgressBean(){
        return pmb;
    }

    public static UserManagerBeanRemote getMyUserManager() {
        return myUserManager;
    }

    public static void main(String[] args) {
        System.out.println("System Start....");

        Launcher.main(args);

    }

}
