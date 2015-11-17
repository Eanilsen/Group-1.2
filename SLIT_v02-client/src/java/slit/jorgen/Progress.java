/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.geometry.Insets;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author Jorgen
 */
public class Progress {
    private ProgressIndicator pi;
    
    public ProgressIndicator makePI(){
        pi = new ProgressIndicator();
        pi.setPadding(new Insets(50, 0, 0, 0));
        pi.setProgress(getStudentProgress()); //how much progress, replace with method later
        pi.setPrefSize(200, 200); //progress indicator size
        System.out.println("Progress: going to return pi now");
        return pi;
    }

    public static double getStudentProgress() {
        return 0.33;
        //ProgressBeanRemote.java - getStudentProgress()
                                    
        //Entity: Progress.java
    }
    
    public static void getStudentProgressFromProgressBean(){
        
    }
}
