/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jorgen
 */
public class TeacherView {
    
    protected static final double MENU_WIDTH = 1400.0;
    protected static final double MENU_HEIGHT = 600.0;
    protected BorderPane bPane;
    private Scene scene;
    private Progress progress;
    private ModuleDisplay module;
    private VBox teacherHub;
    private Button moduleSettings;
    private Button studentList;
    private Button moduleList;
    private Button pending;
    private Button is110 = new Button("IS110");
    
    /**
     * StudentView() is called in MenuManager. 
     * It initiates the borderpane with info from Progress and ModuleDisplay,
     * then invoke displayModuleTextOnClick to put TextArea moduleText on the 
     * bottom position of bPane. After this, bPane gets added to a scene.
     */
    public TeacherView(){
        bPane = new BorderPane();
        progress = new Progress();
        module = new ModuleDisplay();
        
        bPane.setTop(module.makeModuleHBox());
        bPane.setCenter(module.makeModuleText());
        bPane.setLeft(makeTeacherHub());
        scene = new Scene(bPane, MENU_WIDTH, MENU_HEIGHT);
    }
    
    public Scene getScene(){
        return scene;
    }  
    
    public VBox makeTeacherHub(){
        teacherHub = new VBox();
        teacherHub.setSpacing(30);
        teacherHub.setPrefWidth(MENU_WIDTH / 6);
        teacherHub.setPrefHeight(MENU_HEIGHT);
        teacherHub.setStyle(
                "-fx-background-color:pink;");
        
        moduleSettings = new Button("Module Settings");
        studentList = new Button("Student List");
        moduleList = new Button("Module List");
        pending = new Button("Pending");

        moduleSettings.setMinWidth(teacherHub.getPrefWidth());
        studentList.setMinWidth(teacherHub.getPrefWidth());
        moduleList.setMinWidth(teacherHub.getPrefWidth());
        pending.setMinWidth(teacherHub.getPrefWidth());
        
        
        teacherHub.getChildren().addAll(moduleSettings, studentList, moduleList, pending);
        return teacherHub;
    }

    
}
