/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slit.main.Main;

import java.sql.Date;

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
    public static void uploadAction(Button btn) throws IOException {
        btn.setOnAction(e -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Browse Module File");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            file = fileChooser.showOpenDialog(stage);
            if (file.exists()) {
                System.out.println(file.getPath());
                System.out.println(file.canRead());
            }
            System.out.println("-----Before try Objectinputstream");


            System.out.println("files path: " + file + " " + "files name: "
                    + file.getName());

            name = file.getName();
            try {
                content = createStringFromFile(file).getBytes(StandardCharsets.UTF_8);//
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("selected: " + SuperView.getSelected());
            date = new Date(System.currentTimeMillis());
            moduleID = SuperView.getSelected();//3
            userID = Main.getMyUserManager().getCurrentUserDTO().id;

        });

    }

    /**
     * @author Jorgen Lybeck Code to upload in here
     * @param file
     */
    public static void uploadFile(File file) {

    }

    public static void confirmAction(Button btn) throws IOException {
        btn.setOnAction(e -> {
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

        });
    }

    /**
     * Takes the file object and return string
     *
     * @author Simen
     * @param file
     * @return
     */
    private static String createStringFromFile(java.io.File file)
            throws IOException {
        String total = "";
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void confirmFile(File file) {
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
