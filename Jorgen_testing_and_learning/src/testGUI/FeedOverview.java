/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Tyrion
 */
public class FeedOverview {    
    
    private BorderPane bPane = new BorderPane();
    //private Scene scene = new Scene(bPane, 1200, 800);
    private Scene feedScene = new Scene(getFeedOverviewPane(), 1200, 900);
    
    private Circle c1 = new Circle();
    private Circle c2 = new Circle();
    private Circle c3 = new Circle();
    private Circle c4 = new Circle();
    private Circle c5 = new Circle();

    
    public ProgressIndicator makePI(){
        ProgressIndicator pi = new ProgressIndicator();
        
        pi.setProgress(0.33);
        pi.setPrefSize(50, 100);
        
        return pi;
    }
    
    public HBox makeHBox(){
        HBox hbox = new HBox(10);
        
        hbox.setPrefSize(400, 200);
        hbox.getChildren().addAll(c1, c2, c3, c4, c5); //Add nodes to HBox
        hbox.setMaxWidth(Double.MAX_VALUE);
        hbox.setStyle(
                "-fx-stroke-width:2px; -fx-stroke:red; -fx-cursor: hand;"
                        + "-fx-background-color: aquamarine;");
        return hbox;
    }
    
    public void fixBorderPane(){
        bPane.setTop(makePI());
        bPane.setCenter(makeHBox());
//        bPane.setLeft(setVBox());
//        bPane.setRight(try to put in the already created vbox here);
//        bPane.setBottom();
    }
    
    private void setupFeedOverview(){
        
        //makePI();
        fixBorderPane();
    }
    
    protected Scene getFeedScene(){
        return feedScene;
    }
    
    /**
     * Called in login.java to access FeedOverviews borderpane bpane
     * @return bPane
     */
    protected BorderPane getFeedOverviewPane(){
        setupFeedOverview();
        return bPane;
    }    
}
