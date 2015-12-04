package slit.GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;
import slit.main.Main;

/**
 * @author
 * @Date 24.11.2015
 * Desc:
 * SuperView is the superclass of TeacherView and StudentView. It handles 
 * everything which is the same for the subclasses. Information for the panes
 * and scenes of subclasses is managed here.
 */
public class SuperView {
	
    protected static final double MENU_WIDTH = 1000.0;
    protected static final double MENU_HEIGHT = 600.0;
    protected Scene scene;
    protected BorderPane pane;
    protected ModuleCircle circle1;
    protected ModuleCircle circle2;
    protected ModuleCircle circle3;
    protected ModuleCircle circle4;
    protected ModuleCircle circle5;    
    protected Line line;
    protected TextArea moduleText;
    protected ArrayList<ModuleCircle> moduleCircles;
    protected Button backButton;
    protected Text clockText;
    protected ImagePattern imagePattern;
    protected ImagePattern imagePattern2;
    protected ImagePattern imagePattern3;
    protected Image image1;
    protected Image image2;
    protected Image image3;
    protected VBox timeBox;
    protected Label userLabel;
    protected Label timeLabel;
    protected Label dateLabel;
    protected ModulePane modulePane;
    protected HBox buttonsBox;

    /**
     * Constructor for SuperView that initializes items and give them values.
     * This constructor is called in both subclasses.
     */
    SuperView() {
    	pane = new BorderPane();
        scene = new Scene(new BorderPane(), 0, 0);
        line = new Line();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        circle1 = new ModuleCircle(35, Main.getModuleManager().getDescription(1), 1);
        circle2 = new ModuleCircle(35, Main.getModuleManager().getDescription(2), 2);
        circle3 = new ModuleCircle(35, Main.getModuleManager().getDescription(3), 3);
        circle4 = new ModuleCircle(35, Main.getModuleManager().getDescription(4), 4);
        circle5 = new ModuleCircle(35, Main.getModuleManager().getDescription(5), 5);
        
        moduleCircles = new ArrayList<>();
        moduleCircles.add(circle1);
        moduleCircles.add(circle2); 
        moduleCircles.add(circle3);
        moduleCircles.add(circle4);
        moduleCircles.add(circle5);
        
        backButton = new Button("Logout");
        addImageResources();
        
        userLabel = new Label();
        userLabel.setFont(Font.font("Courier", FontPosture.ITALIC, 20));
        timeLabel = new Label();
        timeLabel.setFont(new Font(18));
        dateLabel = new Label();
        dateLabel.setFont(new Font(16));

        timeBox = new VBox(5);
        timeBox.setAlignment(Pos.TOP_CENTER);

        startTimeAnimator();
        timeBox.getChildren().addAll(userLabel, timeLabel, dateLabel);
        
        timeBox.setPadding(new Insets(0, 0, 20, 0));
        pane.setBottom(timeBox);
        
        pane.setTop(new Text("LA OSS TESTE!"));
        

    }

    public void addImageResources() {
        image1 = new Image(
                SuperView.class.getResource(
                        "Icon-Green.png").toExternalForm(), false);
        image2 = new Image(
                SuperView.class.getResource(
                        "Icon-Red2.png").toExternalForm(), false);
        image3 = new Image(
                SuperView.class.getResource(
                        "Icon-Gray.png").toExternalForm(), false);
        imagePattern = new ImagePattern(image1);
        imagePattern2 = new ImagePattern(image2);
        imagePattern3 = new ImagePattern(image3);
        scene.getStylesheets().addAll(SuperView.class.getResource("LES.css").toExternalForm());
        StyleManager.setStyleClass("Circle", circle1, circle2, circle3, circle4, circle5);
        StyleManager.setStyleClass("Line", line);
    }
    
    /**
     * Adds items to the scene which should apply to both subclasses.
     * @return 
     */
    protected Scene drawMenu() {
        circle1.setFill(imagePattern);
        circle2.setFill(imagePattern2);
        circle3.setFill(imagePattern3);
        circle4.setFill(imagePattern);
        circle5.setFill(imagePattern3);
        
        pane.getChildren().add(line);
        
        for(Circle c : moduleCircles) {
            pane.getChildren().add(c);
        }
        
        displayModuleTextOnClick(moduleCircles);
        
        bindShapes(line, circle1, circle2, circle3, circle4, circle5);

        return scene;
    }
    
    public void startTimeAnimator() {

        EventHandler<ActionEvent> eventHandler = e -> {
            TimeAndName timeAndName = new TimeAndName();

            userLabel.setText(timeAndName.getUserString());
            timeLabel.setText(timeAndName.getTimeString());
            dateLabel.setText(timeAndName.getDateString());

        };

        Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
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

    /**
     * Adds function to the circles. When they're clicked, something should
     * happend. This is further implemented in both subclasses.
     * @param circles
     */
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                    RotateTransition rotation = new RotateTransition(Duration.seconds(0.5), circle);
                    rotation.setCycleCount(1);
                    rotation.setByAngle(180);
                    rotation.play();
                    if (circle.isSelected() == false) {
                        for (ModuleCircle c : circles) {
//                            FileHandler.setActive(c);
                            if (c != circle) {
                                c.setSelected(false);
                            }
                        }
                        circle.setSelected(true);
                        modulePane = new ModulePane(
                                new TextArea(circle.getText()), buttonsBox,
                                MENU_WIDTH, MENU_HEIGHT /2.25);
                        pane.setCenter(modulePane);
                        
                        
                        FadeTransition ft = new FadeTransition(
                                Duration.seconds(0.5), modulePane);
                        ft.setFromValue(0);
                        ft.setToValue(1);
                        ft.setCycleCount(1);
                        ft.setAutoReverse(true);
                        ft.play();

                    } else if (circle.isSelected() == true) {
                        FadeTransition ft = new FadeTransition(
                                Duration.seconds(0.5), modulePane);
                        ft.setFromValue(1);
                        ft.setToValue(0);
                        ft.setCycleCount(1);
                        ft.setAutoReverse(true);
                        ft.play();
                        circle.setSelected(false);
                    }
                });
            }
        }
    }

    /**
     * takes you back to the login screen
     * @param backButton 
     */
    public void toLogin(Button backButton){
        backButton.setOnMouseClicked(e -> {
            MenuManager.makeLogin();
        });
    }
}