/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TeacherView extends SuperView {
    protected static final double MENU_WIDTH = 1400.0;
    protected static final double MENU_HEIGHT = 900.0;
    
    protected VBox teacherHub;
    protected Button moduleSettings;
    protected Button studentList;
    protected Button moduleList;
    protected Button pending;
    
    TeacherView() {
    	super();
    	scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
    }
    
    @Override
    protected Scene drawMenu() {
        pane.setLeft(makeTeacherHub());
        return super.drawMenu();
    }
    
    protected VBox makeTeacherHub(){
        teacherHub = new VBox();
        teacherHub.setSpacing(30);
        teacherHub.setPrefWidth(200);
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

    
    @Override
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                    if (moduleText == null || circle.isSelected() == false) {
                        circle.setSelected(true);
                        moduleText = new TextArea(circle.getText());
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.75, MENU_HEIGHT / 4);
                        pane.setCenter(moduleText);
                        
                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
                        pane.setCenter(null);
                        moduleText = null;
                    }
                });
            }
        }
    }
}