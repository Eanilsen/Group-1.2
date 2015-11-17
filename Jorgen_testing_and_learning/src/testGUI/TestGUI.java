/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jorgen
 */
public class TestGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        TextArea ta = new TextArea();
        
        HBox hbox = new HBox();
        BorderPane bp = new BorderPane();
        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        /**
        b2.setOnMouseClicked(e -> {
            if (ta == null) {
                //insert path to the text as the param for new TextArea
                ta.setEditable(false);
                ta = new TextArea("BLABLABLABLABLALBALBLABL");
                //moduleText.setPrefRowCount(20);
                //moduleText.setPrefColumnCount(20);
                //moduleText.setPadding(new Insets(50, 50, 50, 50));
                bp.setBottom(ta);
            
            } else {
                bp.setBottom(null);
                ta = null;
            }   
        });
        
        */
        
        
        
        hbox.getChildren().addAll(b1, b2, b3);
        Scene scene = new Scene(bp, 300, 250);   
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
