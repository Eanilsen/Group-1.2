package slit.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;

/**
* @Author Simen Fuglestad
* @Date 30.09.2015
* Desc:
* MenuManager is the class repsonsible for getting menu-panes from the various
* menu classes and setting them to the window. Fields and methods are entirely
* static so that the menu classes can use the methods without unecessarily
* creating an instance of MenuManager.
*/
public class MenuManager {
    private static Login login;
    private static StudentView student;
    private static TeacherView teacher;
    private static Stage stage = Launcher.getStage();
    
    
    /**
     * Invoke StudentViews constructor and drawMenu() to add the borderpane and 
     * other necessary items to the scene. Then add stage information that is 
     * related only to StudentView.
     */
    protected static void makeStudent() {
        student = new StudentView();
        Scene scene = student.drawMenu();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Invoke TeacherViews constructor and drawMenu() to add the borderpane and 
     * other necessary items to the scene. Then add stage information that is 
     * related only to TeacherView.
     */
    protected static void makeTeacher() {
        teacher = new TeacherView(); 
        Scene scene = teacher.drawMenu();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Teacher");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Invoke Logins constructor and makeMenu() to add the borderpane and 
     * other necessary items to the scene. Then add stage information that is 
     * related only to StudentView.
     */
    protected static void makeLogin() {
        login = new Login();
        Scene scene = login.makeMenu();
        stage.setMinWidth(Login.MENU_WIDTH);
        stage.setMinHeight(Login.MENU_HEIGHT);
        stage.setTitle("Login");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
	}

}
