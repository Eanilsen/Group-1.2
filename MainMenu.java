/**
 * @author Sifu
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
    
    MainMenu(){
    }
    
    protected Scene getScene() {
        pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        
        hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        pane.setCenter(hBox);
        
        circle1 = new Circle(35);
        circle2 = new Circle(35);
        circle3 = new Circle(35);
        circle4 = new Circle(35);
        circle5 = new Circle(35);
        
        hBox.getChildren().addAll(circle1, circle2, circle3, circle4, circle5);
        
        line = new Line(50, MENU_HEIGHT/2, MENU_WIDTH-50, MENU_HEIGHT/2);
        pane.getChildren().add(line);
        alignLineCenter(line);
        
        return scene;
    }
    /*
    * @method alignLineCenter()
    * @param Line line: line to be centered
    * This method uses the functional interface "ChangeListener" to listen for
    * changes in scene's WidthProperty and HeightProperty. Whenever a change
    * occurs in either, the position of the line is adjusted to fit the scene.
    */
    private void alignLineCenter(Line line) {
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double x = (double)newVal;
                line.setStartX(0);
                line.setEndX(x);
            }
        });
        
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double)newVal;
                line.setStartY(y/2);
                line.setEndY(y/2);
            }
        });
    }
}
