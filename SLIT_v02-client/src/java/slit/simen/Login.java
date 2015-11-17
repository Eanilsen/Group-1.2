package slit.simen;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextField;

public class Login {
    protected static final double MENU_WIDTH = 300.0;
    protected static final double MENU_HEIGHT = 250.0;
    private Scene scene;
    private BorderPane pane;
    private VBox vBox;
    private Circle circleTop;
    private Circle circleBottom;
    private TextField username;
    private TextField password;
    private Button loginBtn;
    private Circle circle;
    
    Login() {
    }
    
    protected Scene getScene() {
        username = new TextField("username");
        username.setMaxWidth(100);
        
        password = new TextField("password");
        password.setMaxWidth(100);
        
        loginBtn = new Button("Login");
        clickToOpenMain(loginBtn);
        
        vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(username, password, loginBtn);
        
        pane = new BorderPane();
        pane.setCenter(vBox);
        
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        return scene;
    }
    
    private void clickToOpenMain(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeMain();
        });
    }
}
