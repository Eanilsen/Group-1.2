/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Jorgen
 */
public class FileHandler {
    private static Stage stage;
    private static FileChooser fileChooser = new FileChooser();
    private static Desktop desktop = Desktop.getDesktop();
    
        /**
     * Lybecks upload button
     */
    public static void uploadAction(Button btn){
        btn.setOnAction(e -> {
            
            fileChooser.setTitle("Browse Module File");
            
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                openFile(file);
            }
        });
    }
                
    public static void openFile(File file) {
        try {
            System.out.println(desktop.isDesktopSupported());
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                FileHandler.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}
