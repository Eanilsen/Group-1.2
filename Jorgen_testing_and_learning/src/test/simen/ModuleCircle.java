package test.simen;

import javafx.scene.shape.Circle;

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
