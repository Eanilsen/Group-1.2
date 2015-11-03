/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class FeedOverview {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private BorderPane bPane = new BorderPane();
    private VBox vbox = new VBox(10); //spacing 10
    private HBox hbox = new HBox(10); //spacing 10
    //private Scene scene = new Scene(bPane, 1200, 800);
    
    public void setVBox(){
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setPrefSize(200, 400);
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(); //Add nodes to vbox
        vbox.setStyle(
                "-fx-stroke-width:2px; -fx-stroke:red; -fx-cursor: hand;"
                        + "-fx-background-color: aquamarine;");
    }
    
    public void setHBox(){
        hbox.setPrefSize(400, 200);
        hbox.getChildren().addAll(); //Add nodes to vbox
        hbox.setStyle("-fx-background-color: cadetblue ;");
    }
    
    public void fixBorderPane(){
        bPane.setTop(hbox);
        bPane.setCenter(new Label("implement something cool here"));
        bPane.setLeft(vbox);
//        bPane.setRight(try to put in the already created vbox here);
//        bPane.setBottom();
    }
    
    private void setupFeedOverview(){
        setVBox();
        setHBox();
        fixBorderPane();

        
    }
    
    
    protected BorderPane getFeedOverviewPane(){
        
        return bPane;
    }
}
