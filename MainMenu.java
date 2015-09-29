import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.Node;

public class MainMenu {
    private static final int MENU_HEIGHT = 700;
    private static final int MENU_WIDTH = 800;
    
    MainMenu() {
    }
    
    protected Scene makeScene() {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);
        
        VBox rightVBox = new VBox();
        rightVBox.setPadding(new Insets(0, 50, 0, 0));
        Circle circleDrop = new Circle(50);
        rightVBox.getChildren().add(circleDrop);
        pane.getChildren().add(circleDrop);
        circleDrop.setCenterX(MENU_WIDTH - circleDrop.getRadius() - 30);
        circleDrop.setCenterY(MENU_HEIGHT / 2); 
        //rightVBox.setAlignment(Pos.CENTER);
        
        VBox leftVBox = new VBox();
        leftVBox.setPadding(new Insets(0, 0, 0, 50));
        Circle circleDrag = new Circle(50);
        //leftVBox.getChildren().add(circleDrag);
        pane.getChildren().add(circleDrag);
        circleDrag.setCenterX(circleDrag.getRadius() + 30);
        circleDrag.setCenterY(MENU_HEIGHT / 2);
        makeDraggable(circleDrag);
        //leftVBox.setAlignment(Pos.CENTER);
        
        VBox topVBox = new VBox();
        Text title = new Text("SLIT some throats");
        title.setFont(new Font(40));
        topVBox.getChildren().add(title);
        topVBox.setAlignment(Pos.CENTER);
        
        VBox bottomVBox = new VBox();
        Button btHelp = new Button("Help");
        bottomVBox.getChildren().add(btHelp);
        bottomVBox.setAlignment(Pos.CENTER);
        
        //pane.setLeft(circleDrag);
        //pane.setRight(rightVBox);
        pane.setTop(topVBox);
        pane.setBottom(bottomVBox);
        
        System.out.println(circleDrop.getCenterY());
        System.out.println(circleDrag.getCenterY());
        return scene;
    }
    
    private void makeDraggable(Circle circle) {
        circle.setOnMouseDragged(e -> {
            if ((e.getX() > 0) && (e.getX() <= MENU_WIDTH) &&
                    (e.getY() > 0) && (e.getY() <= MENU_HEIGHT)) {
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
        });
   }
}
