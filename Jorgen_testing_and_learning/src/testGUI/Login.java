/*
 * System:
 * To change between scenes I will use the setScene() method of Scene
 * Lambda expressions for Action Handlers
 * BorderPane with LEFT, CENTER and BOTTOM active
 * Make methods for everything and call them instead of writing all in start()
 *      See handleButtonAction() further down
 * --- insert pattern theories here
 * 
 * Links:
 * http://blog.netopyr.com/2012/01/24/advantages-of-javafx-builders/ 
 * 
 * Do we use one or multiple windows? (except login). We could use borderpane 
 * and e.g. only change center for every new feature.
 */
package testGUI;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//test if works


/**
 *
 * @author Jorgen
 */
public class Login extends Application {
    
    private GridPane grid = new GridPane();
    private Button loginBtn = new Button("Sign in");
    private HBox hbBtn = new HBox(10);
    private Text actiontarget = new Text();
    private Text scenetitle = new Text("Welcome");
    private Label userName = new Label("User Name:");
    private TextField userTextField = new TextField();
    private Label pw = new Label("Password:");
    private PasswordField pwBox = new PasswordField();
    private ComboBox choiceBox = new ComboBox();
    private Scene scene = new Scene(grid, 300, 275);
    private Stage stage;
    private StudentView studentView; //Used to decide between subclasses in loginButtonAction()
    //private CurrentUser currentUser; Added later
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        primaryStage.setTitle("Learning Enhancement System");      
        createGrid();
                
        loginButtonAction();
        addLoginBars();
        addHBox();
        addText();
        addChoiceBox();

        primaryStage.setScene(scene);             
        primaryStage.show();
    }
        
    /**
     * Create the grid for the login layout by using the GridPane from field
     */
    public void createGrid(){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
    }

    /**
     * What happends when loginButton is pressed
     * if role == student, go to studentview
     * if role == teacher, go to teacherview
     */
    public void loginButtonAction(){
        //ActionEvent for what happens when btn is clicked
        loginBtn.setOnAction((ActionEvent e) -> {
            if (isStudent()){ 
            studentView = new StudentView();                       
//            Scene studentScene = new Scene(mainView.getMainOverviewPane(), 1200, 900); //Move this to field, askSimen
            stage.setScene(studentView.makeStudentBorderPane());
            stage.centerOnScreen();
            stage.show();
            } else if (isTeacher()){
                //mainView = new TeacherView();
            }    
            
            
        });
    }

    private static boolean isStudent() {
        //currentUser.getRole() == "Student") {
        return true;
    }
    
    private static boolean isTeacher() {
        //currentUser.getRole() == "Student") {
        return false;
    }
    
    public void openMainMenu(Button button) {
        button.setOnMousePressed(e -> {
            //input code to open main menu
        });
    }
    
    public void addLoginBars(){    
        grid.add(scenetitle, 0, 0, 2, 1);           
        grid.add(userName, 0, 1);                   
        grid.add(pw, 0, 2);
        grid.add(pwBox, 1, 2);   
    }
    
    public void addHBox(){
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginBtn);       
        grid.add(hbBtn, 1, 4);
    }
    
    public void addText(){
        grid.add(actiontarget, 1, 6);       
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        grid.add(userTextField, 1, 1); 
    }
    
    public void addChoiceBox(){
        grid.add(choiceBox, 0, 4);
        choiceBox.getItems().addAll(
            "Lecturer", 
            "Student",
            "Test Scroll",
            "Still testing",
            "Hawaii"
        );
        choiceBox.setPromptText("Alias");
    }


    
}
