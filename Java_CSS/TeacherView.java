import java.util.ArrayList;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TeacherView extends SuperView {
	protected static final double MENU_WIDTH = 1000.0;
    protected static final double MENU_HEIGHT = 600.0;
    private VBox teacherBox;
    private Button moduleSettings;
    private Button studentList;
    //private PendingList pendingList;
    private Button modules;
    private Button pending;
    private ArrayList<Button> buttons;
    private Line verticalLine;
    private Line bottomLine;
    
    TeacherView() {
    	super();
    	scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
    	buttons = new ArrayList<>();
    	modules = new Button("Modules");
    	pending = new Button("Pending");
        moduleSettings = new Button("Module Settings");
        studentList = new Button("Student List");
        displayStudentListOnClick(studentList);
        verticalLine = new Line();
        verticalLine.setStroke(Color.BLACK);
        verticalLine.setStrokeWidth(3);
        bottomLine = new Line();
        bottomLine.setStroke(Color.BLACK);
        bottomLine.setStrokeWidth(3);
        bindShapes(line, circle1, circle2, circle3, circle4, circle5);

        StyleManager.setStyleClass("Pane", pane);
        StyleManager.setStyleClass("Line", verticalLine, bottomLine);

    }

    @Override
    protected Scene drawMenu() {
        buttons.add(modules);
        buttons.add(pending);
        buttons.add(moduleSettings);
        buttons.add(studentList);
    	pane.setLeft(drawTeacherBox());
        pane.getChildren().add(verticalLine);
        pane.getChildren().add(bottomLine);

        return super.drawMenu();
    }

    private VBox drawTeacherBox() {
    	teacherBox = new VBox(50);
    	teacherBox.setPrefWidth(150);
        teacherBox.setAlignment(Pos.CENTER);


    	for (Button b : buttons) {
    		b.setPrefWidth(125);
    	}

    	teacherBox.setPadding(new Insets(30, 0, 0, 0));
    	
    	teacherBox.getChildren().addAll(
    		modules, pending, studentList, moduleSettings);

    	return teacherBox;
    }

    //Enables TextArea upon click.
    @Override
    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
        for (ModuleCircle circle : circles) {
            if (circle instanceof Circle) {
                circle.setOnMouseClicked(e -> {
                    RotateTransition rotation = new RotateTransition(
                            Duration.seconds(0.5), circle);
                        rotation.setCycleCount(1);
                        rotation.setByAngle(180);
                        rotation.play();
                    if (moduleText == null || circle.isSelected() == false) {
                        circle.setSelected(true);
                        moduleText = new TextArea(circle.getText());
                        moduleText.setWrapText(true);
                        moduleText.getStyleClass().add("txtArea");
                        moduleText.setEditable(false);
                        moduleText.setMaxSize(
                                MENU_WIDTH * 0.7, MENU_HEIGHT / 2.3);
                        pane.setCenter(moduleText);

                        FadeTransition ft = new FadeTransition(
                            Duration.seconds(0.5), moduleText);
                        ft.setFromValue(0);
                        ft.setToValue(1);
                        ft.setCycleCount(1);
                        ft.setAutoReverse(true);
                        ft.play();

                    } else if (circle.isSelected() == true)  {
                        circle.setSelected(false);
                        pane.setCenter(null);
                        moduleText = null;
                    }
                });
            }
        }
    }

    private void displayStudentListOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            StudentList studentList = new StudentList();
            pane.setCenter(studentList.drawStudentList());
        });
    }

   /*private void displayPendingOnClick(Button btn) {
    btn.setOnMouseClicked(e -> {
        pendingList = new PendingList();
        showShapes();
        pane.setCenter(pendingList.drawPendingList());
        if (studentList != null) {
            studentList.hideStudentList();
            }
        });
    }*/

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
                double y = (double)newVal;
                line.setStartY(y / 4);
                line.setEndY(y / 4);
                verticalLine.setStartY(y / 4);
                verticalLine.setEndY(y);
                bottomLine.setStartY(y / 1.25);
                bottomLine.setEndY(y / 1.25);
                circle1.setCenterY(y / 4);
                circle2.setCenterY(y / 4);
                circle3.setCenterY(y / 4);
                circle4.setCenterY(y / 4);
                circle5.setCenterY(y / 4);
            }
        });
    }

    /*private void showShapes() {
        for (Circle c : moduleCircles) {
            c.setVisible(true);
        }
        line.setVisible(true);
    }*/
}