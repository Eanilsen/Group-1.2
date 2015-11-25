/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import beans.InitializeDatabaseBeanRemote;
import beans.ProgressManagerBeanRemote;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 *
 * @author Jorgen
 */
public class Launcher extends Application {

    
    private static Stage stage;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        try {
            MenuManager.makeLogin();
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
    }
    
    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        Application.launch();
    }

}
