package slit.GUI;

import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slit.main.Main;
 
/**
 *
 * @author @Date 24.11.2015 Desc: The StudentView is opposed to the TeacherView
 * which both extends SuperView. When a user logs into the system, the users
 * role will be checked in the database and if 'Student' is returned,
 * StudentView is displayed.
 */
public class StudentView extends SuperView {
 
    protected static final double MENU_WIDTH = 1200.0;
    protected static final double MENU_HEIGHT = 900.0;
    protected Stage stage;
    protected ProgressIndicator progressIndicator;
 
    /**
     * Constructor for StudetnView that initializes items and give them values.
     */
    StudentView() {
        super();
//        pane.setStyle("-fx-background-color: red;");
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(Main.getProgressBean().getCurrentUserProgress());
        progressIndicator.setMinSize(100, 100);
        scene.getStylesheets().addAll(
                TeacherView.class.getResource("LES.css").toExternalForm());
        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("ProgInd", progressIndicator);
    }
    
    /**
     * drawMenu() adds items to the scene from StudentView and superclass 
     * SuperView. In MenuManager this method is called after the constructor.
     * Set teacher box to the left in the borderpane of studentview. 
     * @return Scene scene that implements the teachers view.
     */
    @Override
    protected Scene drawMenu() {
        Button uploadBtn = new Button("upload");
        Button backButton = new Button("back");
        HBox topBox = new HBox(MENU_WIDTH / 3.2);
        topBox.getChildren().addAll(backButton, progressIndicator, uploadBtn);
        pane.setTop(topBox);
        pane.setBottom(uploadBtn);
        topBox.setAlignment(Pos.CENTER);
//        pane.setTop(progressIndicator);
//        pane.setBottom(backButton);
        super.toLogin(backButton);
        uploadAction(uploadBtn);
        return super.drawMenu();
    }
    
    /**
     * Lybecks upload button
     */
    public void uploadAction(Button btn){
        btn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Browse Module File");
            fileChooser.showOpenDialog(stage);
        });
    }
}