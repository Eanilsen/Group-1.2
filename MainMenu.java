/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
/**
 *
 * @author Sifu
 */
public class MainMenu {
    MainMenu(){
        
    }
    
    protected Pane getPane() {
        Pane pane = new Pane();
        Button bt = new Button("Here goes the main menu!");
        pane.getChildren().add(bt);
        return pane;
    }
}
