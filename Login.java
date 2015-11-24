import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    private Button loginBtnS;
    private Button loginBtnT;
    private Circle circle;
    
    Login() {
        username = new TextField("username");
        password = new TextField("password");
        loginBtnS = new Button("Login Student");
        loginBtnT = new Button("Login Teacher");
        vBox = new VBox(5);
        pane = new BorderPane();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
    }
    
    protected Scene drawMenu() {
        username.setMaxWidth(100);
        password.setMaxWidth(100);
        
        clickToOpenStudent(loginBtnS);
        clickToOpenTeacher(loginBtnT);
        
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(username, password, loginBtnS, loginBtnT);
        
        pane.setCenter(vBox);
        
        return scene;
    }
    
    private void clickToOpenStudent(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeStudentView();
        });
    }

    private void clickToOpenTeacher(Button btn) {
        btn.setOnMousePressed(e -> {
            MenuManager.makeTeacherView();
        });
    }
}
