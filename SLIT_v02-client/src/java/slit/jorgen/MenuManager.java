package slit.jorgen;

/**
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
    private static StudentView student;
    private static MainView main;
    private static TeacherView teacher;
    private static Stage stage = Launcher.getStage();
    
    
    //stage.setScene(studentView.makeStudentScene());   
    protected static void makeStudent() {
        student = new StudentView();
        Scene scene = student.getScene();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
    protected static void makeMain() {
        main = new MainView();
        Scene scene = main.getScene();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
//    /**
//     * Check if the username is a teacher, student or admin
//     */
//    protected static void checkRole(){
//        if (currentUser.getRole == Admin){
//            makeStudent();
//        }
//        if (currentUser.getRole == Teacher){
//            makeStudent();
//        }
//        if (currentUser.getRole == Student){
//            makeStudent();
//        }
//    }
    
    protected static void makeTeacher() {
        teacher = new TeacherView(); 
        Scene scene = teacher.getScene();
        stage.setMinWidth(StudentView.MENU_WIDTH);
        stage.setMinHeight(StudentView.MENU_HEIGHT);
        stage.setTitle("Teacher");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
 
    protected static void makeLogin() {
        login = new Login();
        Scene scene = login.getScene();
        stage.setMinWidth(Login.MENU_WIDTH);
        stage.setMinHeight(Login.MENU_HEIGHT);
        stage.setTitle("Login");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
	}
//    public void loginButtonAction(){
//        //ActionEvent for what happens when btn is clicked
//        loginBtn.isDefaultButton();
//        loginBtn.setOnAction((ActionEvent e) -> {
//            if (isStudent()){ 
//                studentView = new StudentView();                       
////                Scene studentScene = new Scene(mainView.getMainOverviewPane(), 1200, 900); //Move this to field, askSimen
//                stage.setScene(studentView.makeStudentScene());
//                stage.centerOnScreen();
//                stage.show();
//            } else if (isTeacher()){
//                //mainView = new TeacherView();
//            }    
//            
//            
//        });
//    }
}
