/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DatabaseSetup.SampleDataCreator;
import beans.InitializeDatabaseBeanRemote;
import beans.ProgressManagerBeanRemote;
import beans.UserManagerBeanRemote;
import javax.ejb.EJB;
import slit.GUI.Launcher;
import tryOut.TreeSearch;


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
    private static InitializeDatabaseBeanRemote dataCreator;

    public static InitializeDatabaseBeanRemote getDataCreator() {
        return dataCreator;
    }

    public static ProgressManagerBeanRemote getPmb() {
        return pmb;
    }
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
//        SampleDataCreator.main(args);
        new TreeSearch();
        Launcher.main(args);
    }

}
