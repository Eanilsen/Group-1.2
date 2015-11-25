package slit.GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import javafx.scene.paint.Color;

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

    /**
     * Constructor for SuperView that initializes items and give them values.
     * This constructor is called in both subclasses.
     */
    SuperView() {
    	pane = new BorderPane();
        
        line = new Line();
        line.setStroke(Color.RED);
        circle1 = new ModuleCircle(35, "Module 1 text");
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
        
        pane.getStylesheets().add("LES.css");
        StyleManager.setStyleClass("Circle", circle1, circle2, circle3, circle4, circle5);
        StyleManager.setStyleClass("Line", line);
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
    
     * This method alignes all the module circles to a line by using an algorithm
     * created by Simen. This is implemented in both subclasses.
     */
    protected void bindShapes(
            Line line, 
            Circle circle1, 
            Circle circle2, 
            Circle circle3,
            Circle circle4,
            Circle circle5) {
    }

    /**
     * Adds function to the circles. When they're clicked, something should
     * happend. This is further implemented in both subclasses.
     * @param circles 
     */
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
    }
}