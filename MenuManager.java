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
    private static StudentView studentView;
    private static TeacherView teacherView;
    private static Stage stage = Launcher.getStage();
    
    protected static void makeStudentView() {
        studentView = new StudentView();
        Scene scene = studentView.drawMenu();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Student View");
        stage.setScene(scene);
    }
    
    protected static void makeLogin() {
        login = new Login();
        Scene scene = login.drawMenu();
        stage.setMinWidth(Login.MENU_WIDTH);
        stage.setMinHeight(Login.MENU_HEIGHT);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
	}

    protected static void makeTeacherView() {
        teacherView = new TeacherView();
        Scene scene = teacherView.drawMenu();
        stage.setMinWidth(TeacherView.MENU_WIDTH);
        stage.setMinHeight(TeacherView.MENU_HEIGHT);
        stage.setTitle("Teacher View");
        stage.setScene(scene);
    }
}
