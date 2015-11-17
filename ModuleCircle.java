import javafx.scene.shape.Circle;

public class ModuleCircle extends Circle {
    private boolean selected;
    private String name;
    
    ModuleCircle() {
        super();
    }
    
    ModuleCircle(double radius) {
        super(radius);
        this.selected = false;
    }
    
    ModuleCircle(double radius, String name) {
        super(radius);
        this.name = name;
        this.selected = false;
    }
    
    protected void setSelected(Boolean value) {
        this.selected = value;
    }
    
    protected boolean isSelected() {
        return selected;
    }
}
