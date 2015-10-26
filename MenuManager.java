import javafx.stage.Stage;
import javafx.scene.Scene;

public class MenuManager {
	protected static final double MENU_WIDTH = 800.0;
    protected static final double MENU_HEIGHT = 700.0;
    private static Login login;
    private static MainMenu main;
    private static LoginNoDrag loginNoDrag;
    
	static void makeLogin() {
	    Stage stage = Launcher.getStage();
        login = new Login();
        Scene scene = new Scene(login.getPane(), MENU_WIDTH, MENU_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
    
    static void makeMain() {
        Stage stage = Launcher.getStage();
        main = new MainMenu();
        Scene scene = new Scene(main.getPane(), MENU_WIDTH, MENU_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
    
    static void makeLoginNoDrag() {
        Stage stage = Launcher.getStage();
        loginNoDrag = new LoginNoDrag();
        Scene scene = new Scene(loginNoDrag.getPane(), MENU_WIDTH, MENU_HEIGHT);
        stage.setScene(scene);
        stage.show();
	}
}
