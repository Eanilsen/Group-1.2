/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
/**
 *
 * @author Sifu
 */
public class MainMenu {
    MainMenu(){
        
    }
    
    protected BorderPane getPane() {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Text text = new Text("Here goes the main menu!");
        vBox.getChildren().add(text);
        pane.setCenter(vBox);
        return pane;
    }
}
