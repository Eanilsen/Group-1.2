/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextField;

/**
 * 
 * @author Jorgen
 */
public class Login {
    protected static final double MENU_WIDTH = 300.0;
    protected static final double MENU_HEIGHT = 250.0;
    private Scene scene;
    private BorderPane pane;
    private VBox vBox;
    private TextField username;
    private TextField password;
    private Button loginBtn;
    
    public Login() {
    }
    
    
    public Scene getScene() {
        username = new TextField("username");
        username.setMaxWidth(100);
        
        password = new TextField("password");
        password.setMaxWidth(100);
        
        loginBtn = new Button("Login");
        if (isStudent()){
            clickToOpenStudent(loginBtn);
        }
//        if (isTeacher()){
//            clickToOpenTeacher(loginBtn);
//        }
        
        vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(username, password, loginBtn);
        
        pane = new BorderPane();
        pane.setCenter(vBox);
        
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        return scene;
    }
    
    private void clickToOpenStudent(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeMain();
        });
    }
    
//    private void clickToOpenTeacher(Button btn) {
//        btn.setOnMousePressed(e -> {
//            MenuManager.makeTeacher();
//        });
//    }
    
    public boolean isStudent(){
        //code to check if username == role.student
        return true;
    }
    
    public boolean isTeacher(){
        //code to check if username == role.teacher
        return true;
    }
    /**
    
    public void loginButtonAction(){
        //ActionEvent for what happens when btn is clicked
        loginBtn.isDefaultButton();
        loginBtn.setOnAction((ActionEvent e) -> {
            if (isStudent()){ 
                studentView = new StudentView();                       
//                Scene studentScene = new Scene(mainView.getMainOverviewPane(), 1200, 900); //Move this to field, askSimen
                stage.setScene(studentView.makeStudentScene());
                stage.centerOnScreen();
                stage.show();
            } else if (isTeacher()){
                //mainView = new TeacherView();
            }    
            
            
        });
    }*/
}
