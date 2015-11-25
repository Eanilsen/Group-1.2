/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


/**
 * 
 * @author
 * @Date 24.11.2015
 * Desc:
 * The TeacherView is opposed to the StudentView which both extends SuperView.
 * When a user logs into the system, the users role will be checked in the 
 * database and if 'Teacher' is returned, TeacherView is displayed.
 */
public class TeacherView extends SuperView {
    protected static final double MENU_WIDTH = 1400.0;
    protected static final double MENU_HEIGHT = 600.0;
    private VBox teacherBox;
    private Button moduleSettings;
    private Button studentList;
    private Button modules;
    private Button pending;
    private ArrayList<Button> buttons;

    /**
     * Constructor for TeacherView that initializes items and give them values.
     */
    TeacherView() {
    	super();
    	scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
    	buttons = new ArrayList<>();
    	modules = new Button("Modules");
    	pending = new Button("Pending");
        moduleSettings = new Button("Module Settings");
        studentList = new Button("Student List");
        displayStudentListOnClick(studentList);
    }
        
        
    

    /**
     * drawMenu() adds items to the scene from TeacherView and superclass SuperView.
     * In MenuManager this method is called after the constructor.
     * Set teacher box to the left in the borderpane of teacherview. 
     * @return Scene scene that implements the teachers view.
     */
    @Override
    protected Scene drawMenu() {
        buttons.add(modules);
        buttons.add(pending);
        buttons.add(moduleSettings);
        buttons.add(studentList);
    	pane.setLeft(drawTeacherBox());
    	bindShapes(line, circle1, circle2, circle3, circle4, circle5);

        return super.drawMenu();
    }

    /**
     * Draw the teachers hub as a VBox. For the GUI to show as it should,
     * teacherBox.setPrefWidth(200) needs to be the same as 
     * line.setStartX(200); in bindShapes(). 
     * @return VBox teacherBox with buttons for the teacher hub
     */
    private VBox drawTeacherBox() {
    	teacherBox = new VBox(20);
    	teacherBox.setPrefWidth(200);
    	teacherBox.setStyle("-fx-background-color:pink");

    	for (Button b : buttons) {
    		b.setPrefWidth(200);
    	}

    	teacherBox.setPadding(new Insets(30, 0, 0, 0));
    	
    	teacherBox.getChildren().addAll(
    		modules, pending, studentList, moduleSettings);

    	return teacherBox;
    }

    /*
    * @method displayModuleTextOnClick
    * @param ArrayList<Shape> shapes: the shapes that recevies an actionevent
    * listener
    * This method adds actionevent listeners to all shapes of type circle in 
    * the ArrayList shapes. The event itself brings up a textbox or closes the
    * the textbox if it already exists.
    */
    @Override
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
                        pane.setCenter(moduleText);
                        
                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
                        pane.setCenter(null);
                        moduleText = null;
                    }
                });
            }
        }
    }
    /**
     * 
     */
    private void displayStudentListOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            StudentList studentList = new StudentList();
            pane.setCenter(studentList.drawStudentList());
        });
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
    @Override
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
                line.setStartX(200); //0 in StudentView
                line.setEndX(x);
                circle1.setCenterX(1.5 * (line.getEndX()) / 7 + 100);
                circle2.setCenterX(2.5 * (line.getEndX()) / 7 + 100);
                circle3.setCenterX(3.5 * (line.getEndX()) / 7 + 100);
                circle4.setCenterX(4.5 * (line.getEndX()) / 7 + 100);
                circle5.setCenterX(5.5 * (line.getEndX()) / 7 + 100);
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