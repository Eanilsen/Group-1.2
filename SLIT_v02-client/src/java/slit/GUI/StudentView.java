package slit.GUI;

import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressIndicator;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import main.Main;

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
    

        
    /**
     * Constructor for StudetnView that initializes items and give them values.
     */
    StudentView(){
        super();
//        pane.setStyle("-fx-background-color: red;");
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(Main.getProgressBean().getCurrentUserProgress());
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
        Button settings = new Button("settings");
        HBox topBox = new HBox(MENU_WIDTH / 3.2);
        topBox.getChildren().addAll(backButton, progressIndicator, settings);
        pane.setTop(topBox);
        topBox.setAlignment(Pos.CENTER);
//        pane.setTop(progressIndicator);
//        pane.setBottom(backButton);
        super.toLogin(backButton);
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
}
