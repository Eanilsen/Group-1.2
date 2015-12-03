package slit.GUI;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.geometry.Pos;
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

        uploadBtn = new Button("Upload File");
        try {
            FileHandler.uploadAction(uploadBtn, getCurrentActiveModule());
        } catch (IOException e) {
        }

        confirmBtn = new Button("Confirm");
        try {
            FileHandler.confirmAction(confirmBtn);
        } catch (IOException e) {
        }
        
        buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(uploadBtn, confirmBtn);
    }
    
        
    public int getCurrentActiveModule(){
        int currentModule = 2;
        for (ModuleCircle module : moduleCircles){
            if (module.isSelected()){
                currentModule = module.getModuleID();
            }
        } 
        System.out.println("Current module " + currentModule);
        return currentModule;
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
        HBox topBox = new HBox(MENU_WIDTH / 3.2);
        topBox.getChildren().addAll(progressIndicator);
        pane.setTop(topBox);
        pane.setBottom(backButton);
        topBox.setAlignment(Pos.CENTER);
//        pane.setTop(progressIndicator);
//        pane.setBottom(backButton);
        super.toLogin(backButton);
//        FileHandler.uploadAction(uploadBtn);
        return super.drawMenu();
    }

//    /**
//     * Adds function to the circles. When they're clicked, something should
//     * happend. This is further implemented in both subclasses.
//     * @param circles
//     */
//    @Override
//    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
//        for (ModuleCircle circle : circles) {
//            if (circle instanceof Circle) {
//                circle.setOnMouseClicked(e -> {
//                    RotateTransition rotation = new RotateTransition(Duration.seconds(0.5), circle);
//                    rotation.setCycleCount(1);
//                    rotation.setByAngle(180);
//                    rotation.play();
//                    if (circle.isSelected() == false) {
//                        for (ModuleCircle c : circles) {
//                            if (c != circle) {
//                                c.setSelected(false);
//                            }
//                        }
//                        circle.setSelected(true);
//                        modulePane = new ModulePane(
//                                new TextArea(circle.getText()), buttonsBox);
//                        modulePane.setMaxSize(MENU_WIDTH * 0.75, MENU_HEIGHT/1.5);
//                        modulePane.setPadding(new Insets(150, 0, 0, 0));
//                        pane.setCenter(modulePane);
//                        FadeTransition ft = new FadeTransition(
//                                Duration.seconds(0.5), modulePane);
//                        ft.setFromValue(0);
//                        ft.setToValue(1);
//                        ft.setCycleCount(1);
//                        ft.setAutoReverse(true);
//                        ft.play();
//
//                    } else if (circle.isSelected() == true) {
//                        FadeTransition ft = new FadeTransition(
//                                Duration.seconds(0.5), modulePane);
//                        ft.setFromValue(1);
//                        ft.setToValue(0);
//                        ft.setCycleCount(1);
//                        ft.setAutoReverse(true);
//                        ft.play();
//                        circle.setSelected(false);
//                    }
//                });
//            }
//        }
//    }
}
