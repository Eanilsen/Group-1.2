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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author Jorgen
 */
public class MainView {
    protected static final double MENU_WIDTH = 1400.0;
    protected static final double MENU_HEIGHT = 600.0;
    protected BorderPane bPane;
    private Scene scene;
    private VBox teacherHub;
    private Button moduleSettings;
    private Button studentList;
    private Button moduleList;
    private Button pending;
    private Button is110 = new Button("IS110");
    
    private ModuleCircle m1;
    private ModuleCircle m2;
    private ModuleCircle m3;
    private ModuleCircle m4;
    private ModuleCircle m5;
    private Line line;
    protected ArrayList<ModuleCircle> moduleCircles;
    private TextArea moduleText = new TextArea();
    private HBox moduleHBox = new HBox();
    private ProgressIndicator pi;
    
    /**
     * StudentView() is called in MenuManager. 
     * It initiates the borderpane with info from Progress and ModuleDisplay,
     * then invoke displayModuleTextOnClick to put TextArea moduleText on the 
     * bottom position of bPane. After this, bPane gets added to a scene.
     */
    public MainView(){
        bPane = new BorderPane();
        scene = new Scene(bPane, MENU_WIDTH, MENU_HEIGHT);
        line = new Line();
        pi = new ProgressIndicator(0.3);

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
        
        
        bPane.setCenter(line);
        bPane.setTop(pi);
        
        
    }
    
    /**
     * 
     * @return 
     */
    public Scene getScene(){
        for (ModuleCircle b : moduleCircles){
            b.setRadius(50.0f);
            if (b.isSelected()){
                b.setRadius(70.0f);
            }
            bPane.setCenter(b);
        }      
        displayModuleTextOnClick(moduleCircles);
        bindShapes(line, m1, m2, m3, m4, m5);
        return scene;
    }
    
    /**
     * 
     * @return 
     */
    public VBox makeTeacherHub(){
        teacherHub = new VBox();
        teacherHub.setSpacing(30);
        teacherHub.setPrefWidth(MENU_WIDTH / 6);
        teacherHub.setPrefHeight(MENU_HEIGHT);
        
        moduleSettings = new Button("Module Settings");
        studentList = new Button("Student List");
        moduleList = new Button("Module List");
        pending = new Button("Pending");

        moduleSettings.setMinWidth(teacherHub.getPrefWidth());
        studentList.setMinWidth(teacherHub.getPrefWidth());
        moduleList.setMinWidth(teacherHub.getPrefWidth());
        pending.setMinWidth(teacherHub.getPrefWidth());
        
        
        teacherHub.getChildren().addAll(moduleSettings, studentList, moduleList, pending);
        return teacherHub;
    } 
    
    /**
     * 
     * @return 
     */
    public HBox makeModuleHBox(){

        moduleHBox.setPadding(new Insets(0, 0, 0, 50));
//        moduleHBox.setPrefSize(1200, 600); //Get these values from StudentView instead
        moduleHBox.setSpacing(30);
        moduleHBox.setStyle(
                "-fx-border-stroke-width:2px;" +
                "-fx-background-color:aquamarine;");
        moduleHBox.getChildren().addAll(moduleCircles);
        
        return moduleHBox;      
    } 

    /**
     * 
     * @param circles 
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
                        bPane.setBottom(moduleText);
                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
                        bPane.setBottom(null);
                        moduleText = null;
                    }
                });
            }
        }
        
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
        scene.widthProperty().addListener(new ChangeListener<Number>() {
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
        
        scene.heightProperty().addListener(new ChangeListener<Number>() {
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

