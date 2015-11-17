package chapter_14_javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//Nodes share many properties; two common types are style and rotate
public class NodeStyleRotateDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        //Create a scene
        StackPane pane = new StackPane();
        
        //Style properties are similar to CSS. The prefix is -fx- and after that you 
        //can add styles as you like: ("-fx-background:black ; -fx-fill:red;");
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        
        c1.setStyle("-fx-stroke: teal; -fx-fill: red;");
        //this is equivalent to JavaFX's:
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.RED);
        
        //setRotate() will let you rotate a node from its center
        Button b1 = new Button("Crazy a$$ button");
        b1.setStyle("-fx-border-color: blue;");
        b1.setRotate(-80); //-80 degrees
        pane.getChildren().add(b1); //Since pane is rotated, all it's children will be too
        
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("NodeStyleRotateDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args){
        Application.launch(args);
    }
    
}