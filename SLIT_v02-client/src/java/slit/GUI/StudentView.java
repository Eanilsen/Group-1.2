package slit.GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
    protected Button uploadBtn;
    protected Button confirmBtn;
    protected FileHandler fileHandler;

    /**
     * Constructor for StudetnView that initializes items and give them values.
     */
    StudentView() {
        super();
//        pane.setStyle("-fx-background-color: red;");
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        progressIndicator = new ProgressIndicator(Main.getProgressBean().getCurrentUserProgress());

        progressIndicator.setMinSize(150, 150);
        progressIndicator.setPadding(new Insets(20, 0, 0, 0));

        scene.getStylesheets().addAll(
                TeacherView.class.getResource("LES.css").toExternalForm());
        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("ProgInd", progressIndicator);

        uploadBtn = new Button("Upload File");
        try {
            FileHandler.uploadAction(uploadBtn);
        } catch (IOException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }

        confirmBtn = new Button("Confirm");
        try {
            FileHandler.confirmAction(confirmBtn);
        } catch (IOException e) {
        }
        
        buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(uploadBtn, confirmBtn);
    }


    /**
     * drawMenu() adds items to the scene from StudentView and superclass
     * SuperView. In MenuManager this method is called after the constructor.
     * Set teacher box to the left in the borderpane of studentview.
     *
     * @return Scene scene that implements the teachers view.
     */
    @Override
    protected Scene drawMenu() {
        Button backButton = new Button("Logout");

        pane.setTop(progressIndicator);
        timeBox.getChildren().add(backButton);

        super.toLogin(backButton);
        return super.drawMenu();
    }


}
