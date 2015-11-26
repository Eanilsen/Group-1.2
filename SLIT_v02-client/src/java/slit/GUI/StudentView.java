package slit.GUI;

import beans.ProgressManagerBeanRemote;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressIndicator;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Line;
import javax.ejb.EJB;

/**
 * 
 * @author
 * @Date 24.11.2015
 * Desc:
 * The StudentView is opposed to the TeacherView which both extends SuperView.
 * When a user logs into the system, the users role will be checked in the 
 * database and if 'Student' is returned, StudentView is displayed.
 */
public class StudentView extends SuperView {
    protected static final double MENU_WIDTH = 1200.0;
    protected static final double MENU_HEIGHT = 900.0;
    
    protected ProgressIndicator progressIndicator;
    
    @EJB
    private ProgressManagerBeanRemote pbm;
        
    /**
     * Constructor for StudetnView that initializes items and give them values.
     */
    StudentView(){
        super();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0.33);
        progressIndicator.setMinSize(100, 100);
    }
    
    /**
     * drawMenu() adds items to the scene from StudentView and superclass 
     * SuperView. In MenuManager this method is called after the constructor.
     * Set teacher box to the left in the borderpane of studentview. 
     * @return Scene scene that implements the teachers view.
     */
    @Override
    protected Scene drawMenu() {
        pane.setTop(progressIndicator);
        return super.drawMenu();
    }

    /*
    * @method displayModuleTextOnClick
    * @param ArrayList<Shape> shapes: the shapes that recevies an actionevent
    * listener
    * This method adds actionevent listeners to all shapes of type circle in 
    * the ArrayList shapes. The event itself brings up a textbox or closes the
    * the textbox if it already exists.
    */
    @Override
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                    if (moduleText == null || circle.isSelected() == false) {
                        circle.setSelected(true);
                        moduleText = new TextArea(circle.getText());
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.75, MENU_HEIGHT / 4);
                        pane.setCenter(moduleText);
                        
                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
                        pane.setCenter(null);
                        moduleText = null;
                    }
                });
            }
        }
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
    @Override
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
                line.setStartX(0); //200 in TeacherView
                line.setEndX(x);
                circle1.setCenterX(1.5 * (line.getEndX()) / 7 + 100);
                circle2.setCenterX(2.5 * (line.getEndX()) / 7 + 100);
                circle3.setCenterX(3.5 * (line.getEndX()) / 7 + 100);
                circle4.setCenterX(4.5 * (line.getEndX()) / 7 + 100);
                circle5.setCenterX(5.5 * (line.getEndX()) / 7 + 100);
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
