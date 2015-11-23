/*
* @Author Simen Fuglestad
* @Date 30.09.2015
* Desc:
* MenuManager is the class repsonsible for getting menu-panes from the various
* menu classes and setting them to the window. Fields and methods are entirely
* static so that the menu classes can use the methods without unecessarily
* creating an instance of MenuManager.
*/

import javafx.stage.Stage;
import javafx.scene.Scene;

public class MenuManager {
    private static Login login;
    private static MainMenu main;
    private static Stage stage = Launcher.getStage();
    
    protected static void makeMain() {
        main = new MainMenu();
        Scene scene = main.getScene();
        stage.setMinWidth(MainMenu.MENU_WIDTH);
        stage.setMinHeight(MainMenu.MENU_HEIGHT);
        stage.setTitle("Main Window");
        stage.setScene(scene);
        stage.show();
    }
    
    protected static void makeLogin() {
        login = new Login();
        Scene scene = login.getScene();
        stage.setMinWidth(Login.MENU_WIDTH);
        stage.setMinHeight(Login.MENU_HEIGHT);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
	}
}
