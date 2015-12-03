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
import slit.main.Main;

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
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                openFile(file);
                Main.getFileManager().createFile(file);
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
        
    public String getCurrentUser(){
        return Main.getMyUserManager().getUserName(3);
        //change to currentUser
    }
}

