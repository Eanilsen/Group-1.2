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
import javafx.scene.control.TextArea;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

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
    
    MainMenu(){
    }
    
    protected Scene getScene() {
        pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        
        //line = new Line(50, MENU_HEIGHT/2, MENU_WIDTH-50, MENU_HEIGHT/2);
        line = new Line();
        pane.getChildren().add(line);
        

        //hBox = new HBox(100);
        //hBox.setAlignment(Pos.CENTER);
        //pane.setCenter(hBox);
        
        circle1 = new Circle(35);
        circle2 = new Circle(35);
        circle3 = new Circle(35);
        circle4 = new Circle(35);
        circle5 = new Circle(35);

        circle2.setFill(Color.RED);
        circle4.setFill(Color.BLUE);
        displayModuleTextOnClick(circle1);
        displayModuleTextOnClick(circle2);
        displayModuleTextOnClick(circle3);
        displayModuleTextOnClick(circle4);
        displayModuleTextOnClick(circle5);
        pane.getChildren().addAll(circle1, circle2, circle3, circle4, circle5);

        alignNodes(line, circle1, circle2, circle3, circle4, circle5);

        //hBox.getChildren().addAll(circle1, circle2, circle3, circle4, circle5);
        
        moduleText = new TextArea();
        moduleText.setEditable(false);
        pane.setBottom(moduleText);

        return scene;
    }

    private void displayModuleTextOnClick(Circle circle) {
        circle.setOnMouseClicked(e -> {
            if (moduleText == null) {
                //insert path to the text as the param for new TextArea
                moduleText = new TextArea("Insert path to text here!");
                moduleText.setEditable(false);
                //moduleText.setPrefRowCount(20);
                //moduleText.setPrefColumnCount(20);
                //moduleText.setPadding(new Insets(50, 50, 50, 50));
                pane.setBottom(moduleText);
            
            } else {
                pane.setBottom(null);
                moduleText = null;
            }
        });
    }

    /*
    * @method alignNodes()
    * @param Line line: line to be centered
    * This method uses the functional interface "ChangeListener" to listen for
    * changes in scene's WidthProperty and HeightProperty. Whenever a change
    * occurs in either, the position of the nodes is adjusted to fit the scene.
    */
    private void alignNodes(
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
                //NOTE: These positions needs to be adjusted, circle 4 is
                //inaccurate.
                circle1.setCenterX(line.getStartX() + circle1.getRadius() + 20);
                circle2.setCenterX(line.getEndX() / 3.5);
                
                circle3.setCenterX(line.getEndX() / 2);
                
                circle4.setCenterX(line.getEndX() / 2 + (line.getEndX() / 5));
                circle5.setCenterX(line.getEndX() - circle5.getRadius() - 20);
            }
        });
        
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double)newVal;
                line.setStartY(y / 2);
                line.setEndY(y / 2);
                circle1.setCenterY(y / 2);
                circle2.setCenterY(y / 2);
                circle3.setCenterY(y / 2);
                circle4.setCenterY(y / 2);
                circle5.setCenterY(y / 2);
            }
        });
    }
}
