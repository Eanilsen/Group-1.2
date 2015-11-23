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
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import static slit.jorgen.StudentView.MENU_HEIGHT;
import static slit.jorgen.StudentView.MENU_WIDTH;

/**
 *
 * @author Jorgen
 */
public class ModuleDisplay {
    private ModuleCircle m1;
    private ModuleCircle m2;
    private ModuleCircle m3;
    private ModuleCircle m4;
    private ModuleCircle m5;
    private HBox moduleHBox;
//    private Pane pane = new Pane();
    private Line line = new Line();
    protected ArrayList<ModuleCircle> moduleCircles;
    private TextArea moduleText = new TextArea();
    private StudentView sview;
        
    public ArrayList<ModuleCircle> createModuleCircles(){
        
        m1 = new ModuleCircle(35, "Module 1 text"); //See ModuleCircle for text, setActive etc.
        m2 = new ModuleCircle(35, "Module 2 text");
        m3 = new ModuleCircle(35, "Module 3 text");
        m4 = new ModuleCircle(35, "Module 4 text");
        m5 = new ModuleCircle(35, "Module 5 text");
        
        moduleCircles = new ArrayList();
        moduleCircles.add(m1);
        moduleCircles.add(m2);
        moduleCircles.add(m3);
        moduleCircles.add(m4);
        moduleCircles.add(m5);
        
        for(ModuleCircle c : moduleCircles) {  
            if (c.isSelected()){
                c.setRadius(50);
            }
//            moduleHBox.getChildren().add(c);
        }
        
        return moduleCircles;
    }
    
    /*
    * @method displayModuleTextOnClick
    * @param ArrayList<Shape> shapes: the shapes that recevies an actionevent
    * listener
    * This method adds actionevent listeners to all shapes of type circle in 
    * the ArrayList shapes. The event itself brings up a textbox or closes the
    * the textbox if it already exists.
    */
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {       
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                    if (moduleText == null || circle.isSelected() == false) {
                        circle.setSelected(true);
                        moduleText = new TextArea(circle.getText());
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.75, MENU_HEIGHT / 4);
//                        bPane.setBottom(moduleText);
                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
//                        bPane.setBottom(null);
                        moduleText = null;
                    }
                });
            }
        }
    }
    
    public TextArea makeModuleText(){
        displayModuleTextOnClick(moduleCircles);
        return moduleText;
    }
    
    public HBox makeModuleHBox(){
        createModuleCircles(); //return ArrayList<ModuleCircles> with 5 moduleCircles 
        bindShapes(line, m1, m2, m3, m4, m5); //
        moduleHBox.setPadding(new Insets(0, 0, 0, 50));
        moduleHBox.setSpacing(30);
        moduleHBox.setStyle("-fx-background-color:aquamarine;");
        
        moduleHBox.getChildren().addAll(m1, m2, m3, m4, m5);
        
        return moduleHBox;      
    } 
    
    /*
    * @method bindShapes()
    * @param Line line: line to be bound
    * @param Circle circle1: circle to be bound
    * @param Circle circl2: same as above, etc
    * This method uses the functional interface "ChangeListener" to listen for
    * changes in scene's WidthProperty and HeightProperty. Whenever a change
    * occurs in either, the position of the nodes is adjusted to fit the scene.
    * Note that we create a ChangeListener with Number generic type since we
    * are listening for Number values to change, namely the scene's 
    * width(double) and (double)height. 
    * Also removes errors about unsafe compilation.
    */
    protected void bindShapes(
            Line line, 
            Circle circle1, 
            Circle circle2, 
            Circle circle3,
            Circle circle4,
            Circle circle5) {
        sview.getScene().widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double x = (double)newVal;
                line.setStartX(0);
                line.setEndX(x);
                circle1.setCenterX(line.getStartX() + circle1.getRadius() +20);
                circle2.setCenterX(line.getEndX() * 0.25 + 20);
                circle3.setCenterX(line.getEndX() / 2);
                circle4.setCenterX(line.getEndX() * 0.75 - 20);
                circle5.setCenterX(line.getEndX() - circle5.getRadius() - 20);
            }
        });
        
        sview.getScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double)newVal;
                line.setStartY(y / 4);
                line.setEndY(y / 4);
                circle1.setCenterY(y / 4);
                circle2.setCenterY(y / 4);
                circle3.setCenterY(y / 4);
                circle4.setCenterY(y / 4);
                circle5.setCenterY(y / 4);
            }
        });
    }
}
