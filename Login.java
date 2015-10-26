/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
* @Author Simen Fuglestad
* @Date 30.09.2015
* Desc:
* This document describes the implementation of the login screen for the
* SLIT/LES project.
*/

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import javafx.scene.input.MouseEvent;

public class Login {
    private static final double MENU_WIDTH = Launcher.MENU_WIDTH;
    private static final double MENU_HEIGHT = Launcher.MENU_HEIGHT;
    private BorderPane pane = new BorderPane();
    private Circle circleDrag;
    private double circleDragXPos;
    private double circleDragYPos;
    private Text title;
    private Circle circleDrop;
    private double circleDropXPos;
    private double circleDropYPos;
    private Button btHelp;
    private Scene scene;
    
    Login() {
    }
    
    protected BorderPane getPane() {
        
        VBox leftVBox = new VBox();
        VBox topVBox = new VBox();
        VBox rightVBox = new VBox();
        VBox bottomVBox = new VBox();
        
        leftVBox.setPadding(new Insets(0, 0, 0, 50));
        topVBox.setPadding(new Insets(30, 0, 0, 0));
        rightVBox.setPadding(new Insets(0, 50, 0, 0));
        bottomVBox.setPadding(new Insets(0, 0, 30, 0));
        
        leftVBox.setAlignment(Pos.CENTER);
        topVBox.setAlignment(Pos.CENTER);
        rightVBox.setAlignment(Pos.CENTER);
        bottomVBox.setAlignment(Pos.CENTER);
        
        circleDrop = new Circle(50);
        circleDropXPos = 
                MENU_WIDTH - rightVBox.getInsets().getRight() - 
                circleDrop.getRadius();
        circleDropYPos = MENU_HEIGHT / 2;
        pane.getChildren().add(circleDrop);
        circleDrop.setCenterX(circleDropXPos);
        circleDrop.setCenterY(circleDropYPos);

        circleDrag = new Circle(50);
        circleDragXPos =
            leftVBox.getInsets().getLeft() + circleDrag.getRadius();
        circleDragYPos = MENU_HEIGHT / 2;
        pane.getChildren().add(circleDrag);
        circleDrag.setCenterX(circleDragXPos);
        circleDrag.setCenterY(circleDragYPos);
        makeCircleDraggable(circleDrag);
        makeCircleDropable(circleDrag);
        
        title = new Text("Title");
        title.setFont(new Font(40));
        topVBox.getChildren().add(title);
        
        btHelp = new Button("Help");
        bottomVBox.getChildren().add(btHelp);
        
        pane.setLeft(leftVBox);
        pane.setTop(topVBox);
        pane.setRight(rightVBox);
        pane.setBottom(bottomVBox);
        
        Line line = 
                new Line(0, MENU_HEIGHT / 2, MENU_WIDTH, MENU_HEIGHT / 2);
        pane.getChildren().add(line);
        
        return pane;
    }
    
            
    
    void makeCircleDraggable(Circle circle) {
        circle.setOnMouseDragged(e -> {
             if ((e.getX() > 0) && (e.getX() <= MENU_WIDTH) &&
                    (e.getY() > 0) && (e.getY() <= MENU_HEIGHT)) {
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
        });
    }
    
    void makeCircleDropable(Circle circle) {
        //Bounds bounds = circle.localToScene(circle.getBoundsInLocal());
        //System.out.println(bounds);
        double dropRadius = circleDrop.getRadius();
        circle.setOnMouseReleased((MouseEvent e) -> {
            if (!((e.getX() > circleDropXPos - dropRadius)
                    && (e.getX() < circleDropXPos + dropRadius)
                    && (e.getY() > circleDropYPos - dropRadius)
                    && (e.getY() < circleDropYPos + dropRadius))) {
                circle.setCenterX(circleDragXPos);
                circle.setCenterY(circleDragYPos);
            }
            else {
                System.out.println("dropped!");
                
                pane.getChildren().clear();
                Launcher.makeMain(Launcher.getStage());
            }
        });
    }
}
