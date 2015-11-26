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
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;

public class TeacherView extends SuperView {
	protected static final double MENU_WIDTH = 1400.0;
    protected static final double MENU_HEIGHT = 600.0;
    private VBox teacherBox;
    private Button moduleSettingsBtn;
    private Button studentListBtn;
    private Button modulesBtn;
    private Button pendingBtn;
    private ArrayList<Button> buttons;
    private StudentList studentList;
    private ScrollBar scrollBar;

    TeacherView() {
    	super();
    	scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
    	modulesBtn = new Button("Modules");
    	pendingBtn = new Button("Pending");
        moduleSettingsBtn = new Button("Module Settings");
        studentListBtn = new Button("Student List");
        scrollBar = new ScrollBar();
        buttons = new ArrayList<>();
    }

    @Override
    protected Scene drawMenu() {
        buttons.add(modulesBtn);
        displayModulesOnClick(modulesBtn);

        buttons.add(pendingBtn);
        buttons.add(moduleSettingsBtn);

        buttons.add(studentListBtn);
        displayStudentListOnClick(studentListBtn);

    	pane.setLeft(drawTeacherBox());

    	bindShapes(line, circle1, circle2, circle3, circle4, circle5);

        pane.setRight(scrollBar);
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setVisible(false);
        return super.drawMenu();
    }

    private VBox drawTeacherBox() {
    	teacherBox = new VBox(20);
    	teacherBox.setPrefWidth(200);
    	teacherBox.setStyle("-fx-background-color:pink");

    	for (Button b : buttons) {
    		b.setPrefWidth(200);
    	}

    	teacherBox.setPadding(new Insets(30, 0, 0, 0));
    	
    	teacherBox.getChildren().addAll(
    		modulesBtn, pendingBtn, studentListBtn, moduleSettingsBtn);

    	return teacherBox;
    }

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

    private void displayStudentListOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            studentList = new StudentList();
            pane.setCenter(studentList.drawStudentList());
            scrollBar.setVisible(true);
            hideShapes();
        });
    }

    private void displayModulesOnClick(Button btn) {
        btn.setOnMouseClicked(e -> {
            pane.setCenter(null);
            scrollBar.setVisible(false);
            showShapes();
        });
    }

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
                line.setStartX(200);
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

    private void hideShapes() {
        for (Circle c : moduleCircles) {
            c.setVisible(false);
        }
        line.setVisible(false);
    }

    private void showShapes() {
        for (Circle c : moduleCircles) {
            c.setVisible(true);
        }
        line.setVisible(true);
    }
    /*
    * StudentList need to access the scrollbar in order to add listeners
    *
    private void enableScrollbar() {
        scrollbar.valueProperty().addListener(o ->
            )
    }
    */
}