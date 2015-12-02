/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
 
/**
 *
 * @author @Date 24.11.2015 Desc: The TeacherView is opposed to the StudentView
 * which both extends SuperView. When a user logs into the system, the users
 * role will be checked in the database and if 'Teacher' is returned,
 * TeacherView is displayed.
 */
public class TeacherView extends SuperView {
 
    protected static final double MENU_WIDTH = 1000.0;
    protected static final double MENU_HEIGHT = 600.0;
    private VBox teacherBox;
    private Button studentListBtn;
    private Button modulesBtn;
    private Button pendingBtn;
    private ArrayList<Button> buttons;
    private StudentList studentList;
    private PendingList pendingList;
    private Line verticalLine;
    private Line bottomLine;
    protected Button editBtn;
    protected Button confirmBtn;
 
    /**
     * Constructor for TeacherView that initializes items and give them values.
     */
    TeacherView() {
        super();
        scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        modulesBtn = new Button("Modules");
        pendingBtn = new Button("Pending");
        studentListBtn = new Button("Student List");
        buttons = new ArrayList<>();
        verticalLine = new Line();
        verticalLine.setStroke(Color.BLACK);
        verticalLine.setStrokeWidth(3);
        bottomLine = new Line();
        bottomLine.setStroke(Color.BLACK);
        bottomLine.setStrokeWidth(3);
 
        scene.getStylesheets().addAll(
                TeacherView.class.getResource("LES.css").toExternalForm());
        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("Line", verticalLine, bottomLine);
        
        editBtn = new Button("Edit Module");
        //TODO add method to edit text in textArea
        confirmBtn = new Button("Confirm");
        //TODO add method to apply changes and send them to database
        buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(editBtn, confirmBtn);
    }
 
    /**
     * drawMenu() adds items to the scene from TeacherView and superclass
     * SuperView. In MenuManager this method is called after the constructor.
     * Set teacher box to the left in the borderpane of teacherview.
     *
     * @return Scene scene that implements the teachers view.
     */
    @Override
    protected Scene drawMenu() {
        buttons.add(backButton);
        super.toLogin(backButton);
 
        buttons.add(modulesBtn);
        displayModulesOnClick(modulesBtn);
 
        buttons.add(pendingBtn);
        displayPendingOnClick(pendingBtn);
 
        buttons.add(studentListBtn);
        displayStudentListOnClick(studentListBtn);
 
        pane.setLeft(drawTeacherBox());
        pane.getChildren().add(verticalLine);
        pane.getChildren().add(bottomLine);
 
        bindShapes(line, circle1, circle2, circle3, circle4, circle5);
 
        return super.drawMenu();
    }
 
    /**
     * Draw the teachers hub as a VBox. For the GUI to show as it should,
     * teacherBox.setPrefWidth(200) needs to be the same as line.setStartX(200);
     * in bindShapes().
     *
     * @return VBox teacherBox with buttons for the teacher hub
     */
    private VBox drawTeacherBox() {
        teacherBox = new VBox(50);
        teacherBox.setPrefWidth(150);
        teacherBox.setAlignment(Pos.CENTER);
 
        for (Button b : buttons) {
            b.setPrefWidth(200);
        }
 
        teacherBox.setPadding(new Insets(30, 0, 0, 0));
 
        teacherBox.getChildren().addAll(backButton,
                modulesBtn, pendingBtn, studentListBtn);
 
        return teacherBox;
    }
 
    private void displayStudentListOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            //moved studentList init from constrcutor to avoid nullpointer
            studentList = new StudentList();
            pane.setCenter(studentList.drawStudentList());
            pane.setTop(studentList.drawSearchBars());
            hideShapes();
        });
    }
 
    private void displayModulesOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            if (studentList != null) {
                studentList.hideStudentList();
            }
            if (pendingList != null) {
                pendingList.hidePendingList();
            }
            pane.setCenter(null);
            showShapes();
        });
    }
 
    private void displayPendingOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            pendingList = new PendingList();
            showShapes();
            pane.setCenter(pendingList.drawPendingList());
            if (studentList != null) {
                studentList.hideStudentList();
            }
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
                double x = (double) newVal;
                line.setStartX(0);
                line.setEndX(x);
                bottomLine.setStartX(0);
                bottomLine.setEndX(150);
                verticalLine.setStartX(150);
                verticalLine.setEndX(150);
                circle1.setCenterX(1 * (line.getEndX()) / 7 + 125);
                circle2.setCenterX(2 * (line.getEndX()) / 7 + 125);
                circle3.setCenterX(3 * (line.getEndX()) / 7 + 125);
                circle4.setCenterX(4 * (line.getEndX()) / 7 + 125);
                circle5.setCenterX(5 * (line.getEndX()) / 7 + 125);
            }
        });
 
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> obser,
                    Number oldVal, Number newVal) {
                double y = (double) newVal;
                line.setStartY(y * 0.25);
                line.setEndY(y * 0.25);
                verticalLine.setStartY(y / 4);
                verticalLine.setEndY(y);
                bottomLine.setStartY(y * 0.75);
                bottomLine.setEndY(y * 0.75);
                circle1.setCenterY(y / 4);
                circle2.setCenterY(y / 4);
                circle3.setCenterY(y / 4);
                circle4.setCenterY(y / 4);
                circle5.setCenterY(y / 4);
            }
        });
    }
 
    private void hideShapes() {
        for (Circle c : moduleCircles) {
            c.setVisible(false);
        }
//        line.setVisible(false);
    }
 
    private void showShapes() {
        for (Circle c : moduleCircles) {
            c.setVisible(true);
        }
        line.setVisible(true);
    }
}