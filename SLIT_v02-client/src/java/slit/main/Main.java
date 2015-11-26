/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.main;

import beans.ProgressManagerBeanRemote;
import javax.ejb.EJB;
import slit.GUI.Launcher;

/**
 *
 * @author Jorgen
 */
public class Main {
    
    @EJB
    private static ProgressManagerBeanRemote progressBean;
    
    public static ProgressManagerBeanRemote getProgressBean(){
        return progressBean;
    }
    
    public static void main(String[] args) {
        Launcher.main(args);
    }
}
