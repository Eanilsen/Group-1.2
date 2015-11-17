/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_14_javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class ShowCircle extends Application{
    @Override
    public void start(Stage primaryStage){
        
        //We create a circle
        Circle circle = new Circle();
        circle.setCenterX(100); //X spawn is set
        circle.setCenterY(100); //Y spawn is set
        circle.setRadius(50); //size is set
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.YELLOW);
        
        //We create a pane to place the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle); //Placing the circle
        
        //We create a scene and place it in the stage
        //Stage primaryStage is the outer window
        //Scene scene is the GUI space where you can put things
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /** Process:
         * Create circle
         * Create pane
         * Circle in pane 
         * Create scene 
         * Pane in scene 
         */
    }
    
    public static void main(String[] args){
        Application.launch(args);        
    }
    
    
}
