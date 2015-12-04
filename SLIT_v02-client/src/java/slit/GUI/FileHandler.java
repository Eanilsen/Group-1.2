/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slit.main.Main;

import java.sql.Date;
import javafx.scene.text.Text;

/**
 *
 * @author Jorgen Lybeck
 */
public class FileHandler {

    private static Stage stage;
    private static FileChooser fileChooser;
    private static File file;
    private static String name;
    private static byte[] content;
    private static Date date;
    private static int moduleID;
    private static int userID;
    private static String testContent = "Test content";
    
    private ModuleCircle mc = new ModuleCircle();
    private static ModulePane mp = new ModulePane();
    private int selectedModule;

    /**
     * Code for button action, call uploadFile() here
     */
    public static void uploadAction(Button btn, int selectedModule) throws IOException {
        btn.setOnAction(e -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Browse Module File");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            file = fileChooser.showOpenDialog(stage);
            
//            mp.getButtonBox().getChildren().add(new Text(""+file.getName()));
            
            uploadFile(file, selectedModule);
        });
        
    }
    

    /**
     * @author Jorgen Lybeck
     * Code to upload in here
     * @param file 
     */
    public static void uploadFile(File file, int selectedModule) {

//       
//            FileDTO fdto = new FileDTO(file, 1, "testName", "test".getBytes(),
//                    new java.util.Date());
            try {
                try (ObjectInputStream input
                        = new ObjectInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(file)))) {

                    //Manage file input
                    
                    System.out.println("Inside input " + input);
                    System.out.println("invoking input.read() " + input.read());
                    System.out.println("files path: " + file + " " + "files name: "
                            + file.getName());
                    
                    file.createNewFile();
                    name = file.getName();
                    content = testContent.getBytes();
                    date = new Date(System.currentTimeMillis());
                    moduleID = selectedModule;
                    userID = 3;
                    
                }
                try (
                        ObjectOutputStream output
                        = new ObjectOutputStream(
                                new BufferedOutputStream(
                                        new FileOutputStream(file)))) {
                    //Manage file output
                    System.out.println("Inside output " + output);
//                    output.writeObject(fdto);
                    output.close();

                }
            } catch (EOFException ex) {
                //Closes the file
                System.out.println("All data were read!");
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }

    public static void confirmAction(Button btn) throws IOException {
        btn.setOnAction(e -> {
            confirmFile(file);

        });
    }

    public static void confirmFile(File file) {
        System.out.println("----Confirming file. Module ID is " + moduleID);
        if (file != null) {
            Main.getFileManager().addFilesDatabase(
                    name, content,
                    date, moduleID, userID);
            //user 3 is student studentson, replace with currentUser()
            //find a way to getContent() from the file aswell 
        } else {
            System.out.println("Please choose a valid file!");
        }
        System.out.println("File confirmed");
    }
}
