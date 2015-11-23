/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jorgen
 */
public class StudentView {
    protected static final double MENU_WIDTH = 1200.0;
    protected static final double MENU_HEIGHT = 600.0;
    private BorderPane bPane;
    private Scene scene;
    private Progress progress;
    private ModuleDisplay module;
    
    /**
     * StudentView() is called in MenuManager. 
     * It initiates the borderpane with info from Progress and ModuleDisplay,
     * then invoke displayModuleTextOnClick to put TextArea moduleText on the 
     * bottom position of bPane. After this, bPane gets added to a scene.
     */
    public StudentView(){
        bPane = new BorderPane();
        progress = new Progress();
        module = new ModuleDisplay();
        
        bPane.setTop(progress.makePI());
        bPane.setCenter(module.makeModuleHBox());
        bPane.setBottom(module.makeModuleText());
        scene = new Scene(bPane, MENU_WIDTH, MENU_HEIGHT);
    }
    
    
    public Scene getScene(){
        return scene;
    }
    
//    protected void displayModuleTextOnClick(ArrayList<ModuleCircle> circles) {
//        for (ModuleCircle circle : circles) {
//            if (circle instanceof Circle) {
//                circle.setOnMouseClicked(e -> {
//                    if (moduleText == null || circle.isSelected() == false) {
//                        circle.setSelected(true);
//                        moduleText = new TextArea(circle.getText());
//                        moduleText.setEditable(false);
//                        moduleText.setMaxSize(
//                                MENU_WIDTH * 0.75, MENU_HEIGHT / 4);
//                        bPane.setBottom(moduleText);
//                    } else if (circle.isSelected() == true)  {
//                        circle.setSelected(false);
//                        bPane.setBottom(null);
//                        moduleText = null;
//                    }
//                });
//            }
//        }
//    }
    
//    public BorderPane makeBorderPane(){
//        //Had an JavaFX application thread error for 1 hour before I noticed
//        //I never created objects of progress and moduledisplay... 
////        progress = new Progress();
////        module = new ModuleDisplay();
////        bPane.setTop(progress.makePI());
////        bPane.setCenter(module.makeModuleHBox());
//
//        return bPane; 
//    }

}
