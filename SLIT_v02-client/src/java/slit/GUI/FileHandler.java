/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import DTOs.FileDTO;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slit.main.Main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 *
 * @author Jorgen
 */
public class FileHandler {

    private static Stage stage;
    private static FileChooser fileChooser = new FileChooser();
//    private static Desktop desktop = Desktop.getDesktop();
    private static File file;

    /**
     * Code for button action, call uploadFile() here
     */
    public static void uploadAction(Button btn) throws IOException {
        btn.setOnAction(e -> {

            fileChooser.setTitle("Browse Module File");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            file = fileChooser.showOpenDialog(stage);

            //find a way to getContent() from the file aswell
            //
            String fileName = file.getName(); //file is now the filename that is chosen.
            uploadFile(file);
            System.out.println("Path " + file + " " + "Filename " + fileName);



            if (file != null) {
                FileDTO fdto = new FileDTO(file, 1, "testName", "test".getBytes(),
                        new java.util.Date());
                try {
                    ObjectOutputStream output
                            = new ObjectOutputStream(
                                    new BufferedOutputStream(
                                            new FileOutputStream(file)));

                    output.writeObject(fdto);
                    output.close();
//                openFile(file);
                } catch (IOException ex) {
                    Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    /**
     * Code to upload in here
     * @param file 
     */
    public static void uploadFile(File file){
        try {
            file.toPath();
//        Path path = Paths.get("path/to/file");
            byte[] content = Files.readAllBytes(file.toPath());
            System.out.println(content);
        } catch (IOException ex) {
            System.out.println("Could not find file");
        }

    }

    public static void confirmAction(Button btn) {
        btn.setOnAction(e -> {
            confirmFile(null); //replace with file from uploadAction()

        });
    }

    public static void confirmFile(File file) {
        Main.getFileManager().createFile(file);
    }

    public String getCurrentUser() {
        return Main.getMyUserManager().getUserName(3);
        //change to currentUser
    }
    
//                
//    public static void openFile(File file) {
//        try {
////            System.out.println(desktop.isDesktopSupported());
////            desktop.open(file);
////            desktop.print(file);
//        } catch (IOException ex) {
//            Logger.getLogger(
//                FileHandler.class.getName()).log(
//                    Level.SEVERE, null, ex
//                );
//        }
//    }
}
