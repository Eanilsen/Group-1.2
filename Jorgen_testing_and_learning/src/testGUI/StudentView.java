/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Jorgen
 */
public class StudentView {
    
    private BorderPane bPane = new BorderPane(); 
    private Scene studentScene = new Scene(bPane, 1200, 900);
    private ProgressIndicator pi = new ProgressIndicator();
    private HBox hbox = new HBox();
    
    Circle m1 = new Circle();
    Circle m2 = new Circle();
    Circle m3 = new Circle();
    Circle m4 = new Circle();
    Circle m5 = new Circle();

    public ProgressIndicator makePI(){
        pi.setPadding(new Insets(50, 0, 0, 0));
        pi.setProgress(0.33); //how much progress, replace with method later
        pi.setPrefSize(300, 300); //progress indicator size
        return pi;
    }
    public HBox makeHBox(){
        hbox.setPrefSize(400, 200);
        hbox.getChildren().addAll(m1, m2, m3, m4, m5); //Add nodes to HBox
        hbox.setMaxWidth(Double.MAX_VALUE);
        hbox.setStyle(
                "-fx-stroke-width:2px; -fx-stroke:red;");

        return hbox;      
    } 
    public BorderPane makeBorderPane(){
        bPane.setTop(makePI());
        bPane.setCenter(makeHBox());
        return bPane;
    }
    public Scene makeStudentBorderPane(){
        makeBorderPane();        
        return studentScene;
    }
    
}
