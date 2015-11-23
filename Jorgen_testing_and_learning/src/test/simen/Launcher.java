package test.simen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        try {
            MenuManager.makeLogin();
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
    }
    
    protected static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
