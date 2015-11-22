/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import javafx.scene.shape.Circle;

/**
 * 
 * @author Simen
 */
public class ModuleCircle extends Circle {
    private boolean selected;
    private String text;
    
    ModuleCircle() {
        super();
    }
    
    ModuleCircle(double radius) {
        super(radius);
        this.selected = false;
    }
    
    ModuleCircle(double radius, String text) {
        super(radius);
        this.text = text;
        this.selected = false;
    }
    
    protected void setSelected(Boolean value) {
        this.selected = value;
    }
    
    protected boolean isSelected() {
        return selected;
    }
    
    protected String getText() {
        return text;
    }
}