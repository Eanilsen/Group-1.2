/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_14_javaFX;

import javafx.geometry.Insets;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * @author Jorgen
 */
public class GoWildProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        primaryStage.setTitle("JavaFX Welcome");
                
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        btn.setOnAction((ActionEvent e) -> {
           Stage secondStage = new Stage();
           secondStage.setTitle("Main window");
           
            /**
             * LET THE BULLSHIT BEGIN!
             */
            Button btn2 = new Button("Go back to login");
            btn2.setStyle("-fx-font-family:fantasy;-fx-base:palegreen ;");
            Button btn3 = new Button("Or stay!");
            Button btn4 = new Button("Vertical box!");
            Button btn5 = new Button("Horizontal box?");
            Button btn6 = new Button("Blue node(button)");
            btn6.setStyle("-fx-base: lightblue");
            Button btn7 = new Button("FLOWPANE SUP");
            Button btn8 = new Button("Testing all the nodes!");
            Button lButton = new Button("Im hyooge! The biggest button there is");
            lButton.setPrefSize(500, 500);
            lButton.setStyle("-fx-base:mediumpurple ;");


            VBox vertiBox = new VBox(10); //spacing 10
            vertiBox.setPadding(new Insets(20, 20, 20, 20));
            vertiBox.setPrefSize(200, 400);
            vertiBox.setMaxWidth(Double.MAX_VALUE);
            vertiBox.getChildren().addAll(btn2, btn3, btn4);
            vertiBox.setStyle(
                    "-fx-stroke-width:2px; -fx-stroke:red; -fx-cursor: hand;"
                            + "-fx-background-color: aquamarine;");

            HBox horBox = new HBox(10); //spacing 10
            horBox.setPrefSize(400, 200);
            horBox.getChildren().addAll(btn5, btn6);
            horBox.setStyle("-fx-background-color: cadetblue ;");

            FlowPane fPane = new FlowPane(Orientation.VERTICAL);
            fPane.setColumnHalignment(HPos.LEFT);
            fPane.setPrefWidth(250);
            fPane.setStyle("-fx-background-color:palevioletred;");
            fPane.getChildren().addAll(btn7, btn8);

            TilePane tile = new TilePane();
            tile.setHgap(8);
            tile.setPrefColumns(4);              
            for (int i = 0; i < 6; i++) {        //REMOVE HARDCODE
                tile.getChildren().add(new Button("repeatingButton"));
                if (i == 3){                     //REMOVE HARDCODE
                    Button surprise = new Button("TRY ME Mfka");
                    surprise.setStyle("-fx-base:palevioletred;"
                            + "-fx-cursor:crosshair; -fx-background-radius: 5em;");
                    surprise.setPrefWidth(150);
                    tile.getChildren().add(surprise);
                    surprise.setOnAction((ActionEvent exitEvent) -> {
                        System.exit(0);
                    });
                }
            }



            BorderPane bPane = new BorderPane();//(center, top, right, bottom, left
            bPane.setTop(horBox);
            bPane.setCenter(lButton);
            bPane.setLeft(vertiBox);
            bPane.setRight(fPane);
            bPane.setBottom(tile);

            /**
             * Bullshit ends here... 
             */

            secondStage.setScene(new Scene(bPane, 1200, 800));
            secondStage.setResizable(true); //cant resize the second window
            secondStage.show();
            primaryStage.hide();

            btn2.setOnAction((ActionEvent e2) -> {
                 secondStage.hide();
                 primaryStage.show();
           
            });
        });

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        ComboBox choiceBox = new ComboBox();
        choiceBox.getItems().addAll(
            "Lecturer", 
            "Student",
            "Test Scroll",
            "Still testing",
            "Hawaii"
        );
        choiceBox.setPromptText("Alias");
        
        grid.add(choiceBox, 0, 4);
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        primaryStage.show();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
