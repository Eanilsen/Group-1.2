/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jorgen
 */
public class StudentView {
    protected static final double MENU_WIDTH = 1200.0;
    protected static final double MENU_HEIGHT = 600.0;
    private BorderPane bPane = new BorderPane(); 
    private Scene studentScene = new Scene(bPane, MENU_WIDTH, MENU_HEIGHT);
    private Progress progress;
    private ModuleDisplay module;
    
    public Scene getScene(){
        //Find width and height from this scene
        return studentScene;
    }
    public BorderPane makeBorderPane(){
        //Had an JavaFX application thread error for 1 hour before I noticed
        //I never created objects of progress and moduledisplay... 
        progress = new Progress();
        module = new ModuleDisplay();
        bPane.setTop(progress.makePI());
        bPane.setCenter(module.makeModuleHBox());

        return bPane; 
    }
    public Scene makeStudentScene(){
        makeBorderPane();       
        return studentScene;
    }
    
}
