/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;
/**
 * @author Sifu
 * This class serves as the main GUI window. Use this as a basis for creating
 * student and teacher views.
 */

import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressIndicator;
import java.util.ArrayList;

public class StudentView extends SuperView {
    protected static final double MENU_WIDTH = 1200.0;
    protected static final double MENU_HEIGHT = 900.0;
    
    protected ProgressIndicator progressIndicator;
        
    StudentView(){
   	    super();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(0.1);
        progressIndicator.setMinSize(100, 100);
    }

    @Override
    protected Scene drawMenu() {
        pane.setTop(progressIndicator);
        return super.drawMenu();
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