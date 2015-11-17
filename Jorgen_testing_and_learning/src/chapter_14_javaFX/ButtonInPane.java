/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_14_javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author jeyloh
 */
public class ButtonInPane extends Application{
    
    /** Place nodes inside panes inside scenes
    * A node is a visual component: shape, image view, ui control, pane
    * (a) Panes are used to hold nodes. 
    * (b) Nodes can be shapes, image views, UI controls, and panes.
    */
    
    @Override //Override Start() from Application
    public void start(Stage primaryStage){
        //Create a scene with a button
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 200, 50); //place the pane in the scene
        
        primaryStage.setTitle("Button in a Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    
    }
    
    
    //main is needed if you're not launching from command line 
    //this is always the same for any JavaFX source code
    public static void main(String[] args) {
        //launch is a method from Application used to launch JavaFX applications
        Application.launch(args);
    }
    
}
