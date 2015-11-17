/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_14_javaFX;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

/**
 *
 * @author Tyrion
 */
public class BindingDemo {

    public static void main(String[] args){
        DoubleProperty d1 = new SimpleDoubleProperty(100);
        DoubleProperty d2 = new SimpleDoubleProperty(200);
        
        
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
        
        d1.bind(d2); //Bind d1 and d2 to always keep the same value

        
        d2.setValue(34.40); //We only change the value of d2
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
        //But d1 will change aswell as they're bound
    }
    
}
