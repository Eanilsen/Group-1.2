/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import javafx.scene.shape.Circle;
 
/**
 *
 * @author Simen
 */
public class ModuleCircle extends Circle {
    private boolean selected;
    private String text;
    private int moduleID;
   
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
   
    ModuleCircle(double radius, String text, int moduleID){
        super(radius);
        this.text = text;
        this.selected = false;
        this.moduleID = moduleID;
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
 
    protected void setText(String text) {
        this.text = text;
    }
 
    protected String addText(String text) {
        return this.text = this.text + text;
    }
    
    protected int getModuleID(){
        return moduleID;
}
}