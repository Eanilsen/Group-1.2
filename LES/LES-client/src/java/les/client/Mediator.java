/*
 * http://stackoverflow.com/questions/13328398/using-a-javafx-application-instance-from-another-class
 */
package les.client;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class Mediator extends Application {

    private Login login;
    private Stage primaryStage;
    
    //constructor
    public Mediator(){
        //login = new Login(this);

    }
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        login.start(primaryStage);
    }
    public void changeToLogin(){
        login.start(primaryStage);
    }
}