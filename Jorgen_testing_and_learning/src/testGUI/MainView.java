/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jorgen
 */
public abstract class MainView {
    
    protected BorderPane bPane = new BorderPane();
    /**
     * Works with bPane but if I change it to getMainOverviewPane() that modifies
     * bPane in the subclasses it does not work. 
     * I need to cut from "= new .." and paste it to the if sentence in Login.java
     * for it to run. This means that the error lays in getMainOverviewPane when
     * JVM goes inside makeBorderPane()
     */
    protected Scene mainScene = new Scene(getMainOverviewPane(), 1200, 900);
    //^ 
    
    
    /**
     * 
     * @return 
     */
    public Scene makeMainScene(){
        return mainScene;
    }
    /**
     * Called in login.java to access MainViews subclasses different
     * borderpane implementations
     * @return bPane Now has new values implemented from TeacherView and StudentView
     */
    protected BorderPane getMainOverviewPane(){
        //makeBorderPane();
        return bPane;
    }        
    /**
     * Abstract method implemented in StudentView and TeacherView. Decides how the 
     * current view is going to look. This decision is made in Login.java and 
     * implemented in the different subclasse TeacherView and StudentView.
     */
    public abstract void makeBorderPane();
    
    public void configureMainWindow(){
        //mainScene.setStyle("Background-color:gray"); setStyle() is for nodes, not scenes
    }
    
    
}

/**
 * Removed this mainview and implemented student and teacher seperate instead. 
 * This is not final, consult with simen and jons and keep looking at it.
 */