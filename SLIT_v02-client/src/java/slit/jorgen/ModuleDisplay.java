/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;

/**
 *
 * @author Jorgen
 */
public class ModuleDisplay {    
    private Button m1;
    private Button m2;
    private Button m3;
    private Button m4;
    private Button m5;
    private HBox moduleHBox = new HBox();
    private Line line = new Line();
    private TextArea moduleText = new TextArea();
    private ArrayList<Button> moduleButtons = new ArrayList<Button>();
    private StudentView sview = new StudentView();

    public Scene getSceneProperties(){
        return null;
    }
    
    public ArrayList<Button> createModuleCircles(){

        m1 = new Button("Module 1");
        m2 = new Button("Module 2");
        m3 = new Button("Module 3");
        m4 = new Button("Module 4");
        m5 = new Button("Module 5");    
        moduleButtons.add(m1);
        moduleButtons.add(m2);
        moduleButtons.add(m3);
        moduleButtons.add(m4);
        moduleButtons.add(m5);
        
        for (Button b : moduleButtons){
            //for each button in modulebuttons, add these properties
            b.setStyle(
            "-fx-background-radius: 5em; " +
            "-fx-background-insets:5px;" +
            "-fx-min-width: 100px; " +
            "-fx-min-height: 100px; " +
            "-fx-max-width: 100px; " +
            "-fx-max-height: 100px;" +
            "-fx-background-color: LIGHTGRAY;");
            //if b is activeModule(), make b size 50px
            //if b is approved, make b -background-color: GREEN
            //if b is pending, make b -background-color: YELLOW
            //if b is failed, make b -background-color: RED
            displayModuleTextOnClick(b);
            moduleHBox.getChildren().add(b);
            
        }        
        
        return moduleButtons;
    }
//    
//    protected Scene getScene() {
//        pane = new BorderPane();
//        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
//        
//
//
//        hbox.getChildren().addAll(m1, m2, m3, m4, m5);
//
//
//        return scene;
//    }

    private void displayModuleTextOnClick(Button button) {
        button.setOnMouseClicked(e -> {
            if (moduleText == null) {
                //insert path to the text as the param for new TextArea
                moduleText = new TextArea("Insert path to text here!");
                moduleText.setEditable(false);
                //moduleText.setPrefRowCount(20);
                //moduleText.setPrefColumnCount(20);
                //moduleText.setPadding(new Insets(50, 50, 50, 50));
            } else {
                moduleText = null;
            }   
        });
    }
            
    public HBox makeModuleHBox(){
        createModuleCircles();
//        hbox.getChildren().addAll(m1, m2, m3, m4, m5);
        
        moduleHBox.setPadding(new Insets(0, 0, 0, 50));
        moduleHBox.setPrefSize(1200, 600); //Get these values from StudentView instead
        moduleHBox.setStyle(
                "-fx-border-stroke-width:2px;" +
                "-fx-stroke:red;" +
                "-fx-border-color:aquamarine;");

//        line = new Line(50, MENU_HEIGHT/2, MENU_WIDTH-50, MENU_HEIGHT/2);
        moduleHBox.getChildren().add(line);
//        alignNodes(line, createModuleCircles());
        System.out.println("8 ModuleView: Going to return moduleview now()");
        return moduleHBox;      
    } 
    

    /*
    * @method alignNodes()
    * @param Line line: line to be centered
    * This method uses the functional interface "ChangeListener" to listen for
    * changes in scene's WidthProperty and HeightProperty. Whenever a change
    * occurs in either, the position of the nodes is adjusted to fit the scene.
    
    private void alignNodes(Line line, ArrayList<Button> moduleButtons) { //Button m1, Button, m2 ... instead  of arralist
        Scene scene = sview.getScene();
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double x = (double)newVal;
                line.setStartX(0);
                line.setEndX(x);
                
                
                
                
                //NOTE: These positions needs to be adjusted, button 4 is
                //inaccurate.
                button1.setCenterX(line.getStartX() + button1.getRadius() + 20);
                button2.setCenterX(line.getEndX() / 3.5);
                
                button3.setCenterX(line.getEndX() / 2);
                
                button4.setCenterX(line.getEndX() / 2 + (line.getEndX() / 5));
                button5.setCenterX(line.getEndX() - button5.getRadius() - 20);
            }
        });
        
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double)newVal;
                line.setStartY(y / 2);
                line.setEndY(y / 2);
                button1.setCenterY(y / 2);
                button2.setCenterY(y / 2);
                button3.setCenterY(y / 2);
                button4.setCenterY(y / 2);
                button5.setCenterY(y / 2);
            }
        });
    }*/
    
    public int activeModule(){
        return 0;
    }

    public int modulePending(){
        int pendingSize = 20;
        return pendingSize;
    }

    public Boolean moduleApproved(){
        return true;      
    }

    public Boolean moduleFailed(){
        int failedSize = 20;
        return false;       
    }
}
