
package slit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    static final double MENU_WIDTH = 800.0;
    static final double MENU_HEIGHT = 700.0;
    private static Login login;
    private static MainMenu main;
    private static Stage stage;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        try {
            makeLogin(stage);
        } catch (Exception e) {
            
        }
    }
    
    static void makeLogin(Stage stage) {
        
        login = new Login();
        Scene scene = new Scene(login.getPane(), MENU_WIDTH, MENU_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
    static void makeMain(Stage stage) {
        main = new MainMenu();
        //Scene scene;
        Scene scene = new Scene(main.getPane(), MENU_WIDTH, MENU_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
    
    protected static Stage getStage() {
        return stage;
    }
}