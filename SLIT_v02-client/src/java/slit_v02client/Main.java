/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit_v02client;

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
    
//    @EJB 
//    private static ProgressManagerBeanRemote pmbr;

    public static void main(String[] args) {
        dataCreator.createDatabase();
//        System.out.println(pmbr.theProgress());
    }
    
    
    public void initializeDatabase(){
        
    }
}
