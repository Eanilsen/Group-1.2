package slit.GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import slit.main.Main;

/**
 * @author
 * @Date 24.11.2015
 * Desc:
 * SuperView is the superclass of TeacherView and StudentView. It handles 
 * everything which is the same for the subclasses. Information for the panes
 * and scenes of subclasses is managed here.
 */
public class SuperView {
	
    protected Scene scene;
    protected BorderPane pane;
    protected ModuleCircle circle1;
    protected ModuleCircle circle2;
    protected ModuleCircle circle3;
    protected ModuleCircle circle4;
    protected ModuleCircle circle5;    
    protected Line line;
    protected TextArea moduleText;
    protected ArrayList<ModuleCircle> moduleCircles;
    protected Button backButton;

    /**
     * Constructor for SuperView that initializes items and give them values.
     * This constructor is called in both subclasses.
     */
    SuperView() {
    	pane = new BorderPane();
        
        line = new Line();
        line.setStroke(Color.RED);
        circle1 = new ModuleCircle(35, Main.getModuleManager().getDescription(1));
        circle2 = new ModuleCircle(35, "Moudle 2 text");
        circle3 = new ModuleCircle(35, "Module 3 text");
        circle4 = new ModuleCircle(35, "Module 4 text");
        circle5 = new ModuleCircle(35, "Module 5 text");
        
        moduleCircles = new ArrayList<>();
        moduleCircles.add(circle1);
        moduleCircles.add(circle2); 
        moduleCircles.add(circle3);
        moduleCircles.add(circle4);
        moduleCircles.add(circle5);
        
        backButton = new Button("to Login");
    }
    
    /**
     * Adds items to the scene which should apply to both subclasses.
     * @return 
     */
    protected Scene drawMenu() {
        circle2.setFill(Color.RED);
        circle4.setFill(Color.BLUE);
        
        pane.getChildren().add(line);
        
        for(Circle c : moduleCircles) {
            pane.getChildren().add(c);
        }
        
        displayModuleTextOnClick(moduleCircles);
        
        bindShapes(line, circle1, circle2, circle3, circle4, circle5);

        return scene;
    }
    
    /*
     * @method bindShapes()
     * @param Line line: line to be bound
     * @param Circle circle1: circle to be bound
     * @param Circle circl2: same as above, etc
     * This method uses the functional interface "ChangeListener" to listen for
     * changes in scene's WidthProperty and HeightProperty. Whenever a change
     * occurs in either, the position of the nodes is adjusted to fit the scene.
     * Note that we create a ChangeListener with Number generic type since we
     * are listening for Number values to change, namely the scene's 
     * width(double) and (double)height. 
     * Also removes errors about unsafe compilation.
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
                circle1.setCenterX(line.getStartX() + circle1.getRadius() +20);
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

    /**
     * Adds function to the circles. When they're clicked, something should
     * happend. This is further implemented in both subclasses.
     * @param circles 
     */
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
    }
    
    /**
     * takes you back to the login screen
     * @param backButton 
     */
    public void toLogin(Button backButton){
        backButton.setOnMouseClicked(e -> {
            MenuManager.makeLogin();
        });
    }
}