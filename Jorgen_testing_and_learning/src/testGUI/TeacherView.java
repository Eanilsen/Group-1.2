/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Jorgen
 */
public class TeacherView extends MainView{
    
    private BorderPane bPane = new BorderPane(); 
    private Scene teacherScene = new Scene(bPane, 1200, 900);

    
    public ProgressIndicator somethingUpTop(){       
        //Add code to implement the teachers view 
        return null;
    }
    
    public HBox somethingInTheMiddle(){
        //Add code to implement the teachers view
        return null;
    }
    
    @Override
    public void makeBorderPane(){
        super.bPane.setTop(somethingUpTop());
        super.bPane.setCenter(somethingInTheMiddle());
    }
    
}
