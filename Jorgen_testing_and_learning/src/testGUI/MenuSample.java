/*
 * 
 * http://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm
 */
package testGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class MenuSample extends Application{
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private Scene scene1 = new Scene(new VBox(), 900, 600);
    private Stage stage;
    
    
    @Override
    public void start(Stage stage) {
        
        this.stage = stage;
        
        createMenu();
        
        stage.setTitle("Menu Sample");
        stage.setScene(scene1);
        stage.show();
    }
    
    
    public void createMenu(){
        scene1.setFill(Color.OLDLACE);
 
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        ((VBox) scene1.getRoot()).getChildren().addAll(menuBar);
        
        MenuItem open = new MenuItem("Open");
        open.setAccelerator(KeyCombination.keyCombination("CTRL-O"));
        open.setOnAction((ActionEvent o) -> {
            // action for open here
        });
        
        MenuItem save = new MenuItem("Save");
        save.setAccelerator(KeyCombination.keyCombination("CTRL-S"));
        save.setOnAction((ActionEvent s) -> {
            // action for save here
        });
        
        MenuItem clear = new MenuItem("Clear");
        clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        clear.setOnAction((ActionEvent c) -> {
            // action for clear here
        });
        
        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("CTRL-X"));
        exit.setOnAction((ActionEvent x) -> {
            System.exit(0);
        });
        
        menuFile.getItems().addAll(open, save, clear, exit);
            
           
 
    }
}
