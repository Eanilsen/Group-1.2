/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Login {

    protected static final double MENU_WIDTH = 600.0;
    protected static final double MENU_HEIGHT = 400.0;
    private Scene scene;
    private BorderPane pane;
    private VBox vBox;
    private Circle circleTop;
    private Circle circleBottom;
    private TextField username;
    private TextField password;
    private Button loginBtnS;
    private Button loginBtnT;
    private Circle circle;
    private HBox hBox;

    Login() {
        username = new TextField("Username");
        password = new TextField("Password");
        loginBtnS = new Button("Login Student");
        loginBtnT = new Button("Login Teacher");
        vBox = new VBox(5);
        pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        hBox = new HBox();

        scene.getStylesheets().clear();
        scene.getStylesheets().addAll(Login.class.getResource("LES.css").toExternalForm());

        StyleManager.setStyleClass("Pane1", pane);
        StyleManager.setStyleClass("Textfields", username, password);
        StyleManager.setStyleClass("Button", loginBtnS, loginBtnT);

    }

    protected Scene drawMenu() {
        username.setMaxWidth(150);
        password.setMaxWidth(150);

        clickToOpenStudent(loginBtnS);
        clickToOpenTeacher(loginBtnT);

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(username, password, loginBtnS, loginBtnT);

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
}
