package slit.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ModulePane extends BorderPane {

    private TextArea textArea;
    private static HBox buttons;
    private FileHandler fileHandler;

    ModulePane() {
        super();
    }

    ModulePane(TextArea textArea, HBox buttons, double width, double height) {
        super();
        this.textArea = textArea;
        this.buttons = buttons;
        setCenter(textArea);
        setBottom(buttons);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        setMaxSize(width, height);
    }

    public TextArea getTextArea() {
        return textArea;
    }
    
//    public static HBox getButtonBox(){
//        return buttons();
//    }
}
