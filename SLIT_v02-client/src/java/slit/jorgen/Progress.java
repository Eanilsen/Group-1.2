/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author Jorgen
 */
public class Progress {

//    @EJB
//    private ProgressManagerBeanRemote pmbr;
    private ProgressIndicator pi;
    
    
    public ProgressIndicator makePI(){
        pi = new ProgressIndicator();
        pi.setProgress(getStudentProgress()); //how much progress, replace with method later
        pi.setPrefSize(200, 200); //progress indicator size
        return pi;
    }
    
    public ProgressBar makePB(){
        return null;
    }
    
    /**
     * Finds the current students progress from EJB and returns the double
     * value to PI
     * @return double value from EJB
     */
    public static double getStudentProgress() {
        return 0.33;
        //ProgressBeanRemote.java - getStudentProgress()
                                    
        //Entity: Progress.java
    }
}
