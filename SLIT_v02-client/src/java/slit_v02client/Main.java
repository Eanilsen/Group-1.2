/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit_v02client;

import beans.InitializeDatabaseBeanRemote;
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

    public static void main(String[] args) {
        dataCreator.createDatabase();
    }
    
    
    public void initializeDatabase(){
        
    }
}
