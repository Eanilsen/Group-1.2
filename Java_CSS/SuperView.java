import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.control.ProgressIndicator;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class SuperView {
	
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
    protected Image image1;
    protected Image image2;
    protected Image image3;

    SuperView() {
    	pane = new BorderPane();
        line = new Line();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        circle1 = new ModuleCircle(35, "Module 1 text");
        circle2 = new ModuleCircle(35, "Module 2 text");
        circle3 = new ModuleCircle(35, "Module 3 text");
        circle4 = new ModuleCircle(35, "Module 4 text");
        circle5 = new ModuleCircle(35, "Module 5 text");
        image1 = new Image("Icon-Green.png");
        image2 = new Image("Icon-Red2.png");
        image3 = new Image("Icon-Gray.png");
        
        moduleCircles = new ArrayList<>();
        moduleCircles.add(circle1);
        moduleCircles.add(circle2); 
        moduleCircles.add(circle3);
        moduleCircles.add(circle4);
        moduleCircles.add(circle5);

        //Adds the CSS-document and adds different variables as selectors in the stylesheet.
        pane.getStylesheets().add("LES.css");
        StyleManager.setStyleClass("Circle", circle1, circle2, circle3, circle4, circle5);
        StyleManager.setStyleClass("Line", line);
    }

    protected Scene drawMenu() {
        ImagePattern imagePattern = new ImagePattern(image1);
        ImagePattern imagePattern2 = new ImagePattern(image2);
        ImagePattern imagePattern3 = new ImagePattern(image3);

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
                circle1.setCenterY(y / 4 + 6);
                circle2.setCenterY(y / 4 + 6);
                circle3.setCenterY(y / 4 + 6);
                circle4.setCenterY(y / 4 + 6);
                circle5.setCenterY(y / 4 + 6);
            }
        });
    }

        protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
    }

        /*public void rotateField(){
        }*/

}