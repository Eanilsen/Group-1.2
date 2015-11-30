/**
 * @author Sifu
 * This class serves as the main GUI window. Use this as a basis for creating
 * student and teacher views.
 */
import java.util.ArrayList;
import javafx.animation.*;
import javafx.animation.ParallelTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;


public class StudentView extends SuperView {
    protected static final double MENU_WIDTH = 800.0;
    protected static final double MENU_HEIGHT = 600.0;
    private ProgressIndicator progressIndicator;
    private Stage stage;
    private Button btn;
    private VBox vBox;

        
    StudentView(){
   	    super();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(0.13);
        progressIndicator.setMinSize(100, 100);
        btn = new Button("Browse");


        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("ProgInd", progressIndicator);


    }

    @Override
    protected Scene drawMenu() {
        pane.setTop(progressIndicator);
        pane.setBottom(btn);
        uploadButton(btn);
        return super.drawMenu();
    }



    protected void uploadButton(Button btn) {
            btn.setOnMouseClicked(b -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.showOpenDialog(stage);
                            });
    }
    //Enables TextArea upon click.
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
                        moduleText.setWrapText(true);
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
