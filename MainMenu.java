/**
 * @author Sifu
 * This class serves as the main GUI window. Use this as a basis for creating
 * student and teacher views.
 */

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.util.ArrayList;

public class MainMenu {
    protected static final double MENU_WIDTH = 800.0;
    protected static final double MENU_HEIGHT = 700.0;
    private Scene scene;
    private BorderPane pane;
    private HBox hBox;
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;
    private Circle circle5;    
    private Line line;
    private TextArea moduleText;
    private ArrayList<Shape> shapes;
    
    MainMenu(){
   	    pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        //Note that is is irrelevant to give line any parameteres since it
        //will be given coordinates when bound to the width and height of the 
        //scene
        line = new Line();
        circle1 = new Circle(35);
        circle2 = new Circle(35);
        circle3 = new Circle(35);
        circle4 = new Circle(35);
        circle5 = new Circle(35);
        shapes = new ArrayList<>();
        shapes.add(line);
        shapes.add(circle1);
        shapes.add(circle2); 
        shapes.add(circle3);
        shapes.add(circle4);
        shapes.add(circle5);
    }
    
    protected Scene getScene() {
        //Adding these colors are, temporarily, just to distingiush the
        //the distance between the circles 
        
        circle2.setFill(Color.RED);
        circle4.setFill(Color.BLUE);
        
        /*
        *Simplify adding new elements to the stage by keeping them all in an
        *arraylist. Note that this requires custom positioning and/or binding.
        */
        
        for (Shape shape : shapes) {
            pane.getChildren().add(shape);
        }
        
        /*
        *Calling this method 
        */
        
        displayModuleTextOnClick(shapes);
        
        bindShapes(line, circle1, circle2, circle3, circle4, circle5);
        
        return scene;
    }
    /*
    * @method displayModuleTextOnClick
    * @param ArrayList<Shape> shapes: the shapes that recevies an actionevent
    * listener
    * This method adds actionevent listeners to all shapes of type circle in 
    * the ArrayList shapes. The event itself brings up a textbox or closes the
    * the textbox if it already exists.
    */
    protected void displayModuleTextOnClick(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                shape.setOnMouseClicked(e -> {
                    if (moduleText == null) {
                        //insert path to the text as the param for moduleText
                        moduleText = new TextArea("Insert path to text here!");
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.75, MENU_HEIGHT / 4);
                        pane.setCenter(moduleText);
            
                    } else {
                        pane.setCenter(null);
                        moduleText = null;
                    }
                });
            }
        }
    }

    /*
    * @method alignNodes()
    * @param Line line: line to be bound
    * @param Circle circle1: circle to be bound
    * @param Circle circl2: same as above, etc
    * This method uses the functional interface "ChangeListener" to listen for
    * changes in scene's WidthProperty and HeightProperty. Whenever a change
    * occurs in either, the position of the nodes is adjusted to fit the scene.
    * Note that we create a ChangeListener with Number generic type since we
    * are listening for Number values to change, namely the scene's width and
    * height. This also removes errors about unsafe compilation.
    */
    protected void bindShapes(
            Line line, 
            Circle circle1, 
            Circle circle2, 
            Circle circle3,
            Circle circle4,
            Circle circle5) {
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double x = (double)newVal;
                line.setStartX(0);
                line.setEndX(x);
                circle1.setCenterX(line.getStartX() + circle1.getRadius() + 20);
                circle2.setCenterX(line.getEndX() * 0.25 + 20);
                circle3.setCenterX(line.getEndX() / 2);
                circle4.setCenterX(line.getEndX() * 0.75 - 20);
                circle5.setCenterX(line.getEndX() - circle5.getRadius() - 20);
            }
        });
        
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double)newVal;
                line.setStartY(y / 4);
                line.setEndY(y / 4);
                circle1.setCenterY(y / 4);
                circle2.setCenterY(y / 4);
                circle3.setCenterY(y / 4);
                circle4.setCenterY(y / 4);
                circle5.setCenterY(y / 4);
            }
        });
    }
}
