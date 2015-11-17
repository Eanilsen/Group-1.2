/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_14_javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class SwitchingScenes extends Application{
    //Fields
    private Button btn1, btn2;
    private Label lb1, lb2;
    private FlowPane pane1, pane2;
    private Scene scene1, scene2;
    private Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        //can now use the stage in other methods: buttonClicked(), line 66
        stage = primaryStage;
        
        //make things to put on panes
        btn1 = new Button("Move to other scene");
        btn2 = new Button("Return to first scene");
        btn1.setStyle("-fx-border-color:red; -fx-background-color:purple;");
        btn1.setRotate(45);
        
        btn1.setOnAction(e-> buttonClicked(e));
        btn2.setOnAction(e-> buttonClicked(e));
                
        lb1 = new Label("Scene1");
        lb2 = new Label("Scene2");
        
        pane1 = new FlowPane();
        pane2 = new FlowPane();
        //set vertical gap for panes
        pane1.setVgap(10);
        pane2.setVgap(10);
        //set background color for panes
        pane1.setStyle("-fx-background-color: cornflowerblue;-fx-padding: 10px;");
        pane2.setStyle("-fx-background-color: purple;-fx-padding: 10px;");
        
        //add every node to panes
        pane1.getChildren().addAll(lb1, btn1);
        pane2.getChildren().addAll(lb2, btn2);
        
        //create scenes
        scene1 = new Scene(pane1, 400, 200);
        scene2 = new Scene(pane2, 900, 400);
        
        primaryStage.setTitle("Switch Scenes");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    //Create event handler for buttons
        public void buttonClicked(ActionEvent e){
            //we're using setScene() to change between scene1 and 2 for each click
            if (e.getSource()==btn1){
                stage.setScene(scene2);
            } else{
                stage.setScene(scene1);
            }
            
        }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

