/**
 * @author Sifu
 * This class serves as the main GUI window. Use this as a basis for creating
 * student and teacher views.
 */

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
import javafx.scene.control.ProgressIndicator;
import java.util.ArrayList;
import javafx.animation.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.animation.ParallelTransition;


public class StudentView extends SuperView {
    protected static final double MENU_WIDTH = 800.0;
    protected static final double MENU_HEIGHT = 600.0;
    private ProgressIndicator progressIndicator;
        
    StudentView(){
   	    super();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(0.13);
        progressIndicator.setMinSize(100, 100);

        
        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("ProgInd", progressIndicator);

    }

    @Override
    protected Scene drawMenu() {
        pane.setTop(progressIndicator);
        return super.drawMenu();
    }

    //Enables TextField upon click.
    @Override
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                       RotateTransition rotation = new RotateTransition(Duration.seconds(0.5), circle);
                        rotation.setCycleCount(1);
                        rotation.setByAngle(180);
                        rotation.play();
                    if (moduleText == null || circle.isSelected() == false) {
                        circle.setSelected(true);
                        moduleText = new TextArea(circle.getText());
                        moduleText.getStyleClass().add("txtArea");
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.9, MENU_HEIGHT / 2.3);
                        pane.setCenter(moduleText);

                        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), moduleText);
                        ft.setFromValue(0);
                        ft.setToValue(1);
                        ft.setCycleCount(1);
                        ft.setAutoReverse(true);
                        ft.play();
                        
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
