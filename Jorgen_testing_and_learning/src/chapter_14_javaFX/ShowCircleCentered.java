/*
 * 14.5 Property Binding
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
public class ShowCircleCentered extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        //Create a circle and set properties
        Circle c = new Circle();
        //we use target.bind(source) on a target to property bind them
        //The source will be divided by 2 based on the target
        c.centerXProperty().bind(pane.widthProperty().divide(2));
        c.centerYProperty().bind(pane.heightProperty().divide(2));
        //The circles Y and X are half of panes height and width making it 
        //always centered. This is dynamic in runtime.
        c.setRadius(50);
        c.setStroke(Color.BLACK);
        c.setFill(Color.AQUA);
        pane.getChildren().add(c);
        
        Scene s = new Scene(pane, 400, 200);
        primaryStage.setTitle("ShowCircleCentered");
        primaryStage.setScene(s);
        primaryStage.show();
        
    }
    
    public static void main(String args[]){
        Application.launch(args);
    }
}