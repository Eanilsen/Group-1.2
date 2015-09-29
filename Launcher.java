import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            MainMenu mainMenu = new MainMenu();
            Scene scene = mainMenu.makeScene();
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e) {
        }
    }
}
