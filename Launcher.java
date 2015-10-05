import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Login login = new Login();
            Scene scene = login.makeScene();
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e) {
        }
    }
}
