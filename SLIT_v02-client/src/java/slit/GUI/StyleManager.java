package slit.GUI;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
/*
* Class stylemanage. Use methods from this class to manage css target names.
*/
public class StyleManager {
    /*
    * Constructor is private for this class to prevent unnecessary init
    */
    private StyleManager(){
    }

    /*
    * @method setStyleClass: use to set the styleclass for any number of nodes.
    * Example of use: StyleManager.setStyleClass("styleclassName", node1, node2,
    * node3, etc)
    */
    public static void setStyleClass(String targetText, Node... nodes) {
            for(Node node : nodes) {
                    node.getStyleClass().add(targetText);
            }
    }
    /*
    * Overloaded method that accepts pane param
    */
    public static void setStyleClass(String targetText, Pane... panes) {
            for(Pane pane : panes) {
                    pane.getStyleClass().add(targetText);
            }
    }
}