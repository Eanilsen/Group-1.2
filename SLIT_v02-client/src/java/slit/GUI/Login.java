/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import DTOs.RolesEnum;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import slit.main.Main;

public class Login {

    protected static final double MENU_WIDTH = 600.0;
    protected static final double MENU_HEIGHT = 400.0;
    private Scene scene;
    private BorderPane pane;
    private VBox vBox;
    private Circle circleTop;
    private Circle circleBottom;
    private TextField username;
    private PasswordField password;
    private Button loginBtnS;
    private Button loginBtnT;
    private Button loginBtnWithId;
    private Circle circle;
    private HBox hBox;
    private Image logo;
    private ImageView logoView;

    Login() {
        username = new TextField("Username");
        password = new PasswordField();

        loginBtnS = new Button("Login Student");
        loginBtnT = new Button("Login Teacher");
        loginBtnWithId = new Button("Login");
        vBox = new VBox(5);
        pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        hBox = new HBox();
        logo = new Image(Login.class.getResource(
                "LogoZag.png").toExternalForm(), false);
        logoView = new ImageView(logo);
        logoView.setFitHeight(200);
        logoView.setFitWidth(200);
        scene.getStylesheets().clear();
        scene.getStylesheets().addAll(Login.class.getResource("LES.css").toExternalForm());

        StyleManager.setStyleClass("Pane1", pane);
        StyleManager.setStyleClass("Textfields", username, password);
        StyleManager.setStyleClass("Button", loginBtnS, loginBtnT, loginBtnWithId);

    }
    public int getID(){
        return (int) Integer.parseInt(username.getText());
    }

    protected Scene drawMenu() {
        username.setMaxWidth(150);
        password.setMaxWidth(150);
        loginBtnWithId.setMaxWidth(150);
        
        loginBtnS.setPrefWidth(150);
        loginBtnT.setPrefWidth(150);
        loginBtnWithId.setPrefWidth(150);
        clickToOpenStudent(loginBtnS);
        clickToOpenTeacher(loginBtnT);
        clickToOpenWithId(loginBtnWithId);

        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(logoView, username, password, loginBtnWithId);


        pane.setCenter(vBox);

        return scene;
    }

    private void clickToOpenStudent(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeStudent();
        });
    }

    private void clickToOpenTeacher(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeTeacher();
        });
    }
            

    private void clickToOpenWithId(Button btn) {
        btn.setOnMousePressed(e -> {
            Main.getMyUserManager().Login(Integer.parseInt(username.getText()));
            RolesEnum currentRole = Main.getMyUserManager().getCurrentUserRole();
            
            if(currentRole!=null && (currentRole == RolesEnum.Teacher || currentRole == RolesEnum.HelpTeacher)){
                MenuManager.makeTeacher();
            }
            else if (currentRole!= null && currentRole == RolesEnum.Student){
                MenuManager.makeStudent();
            }
            else{
                username.setText("ID not found for Teacher or Student");
            }
        });
    }
}
