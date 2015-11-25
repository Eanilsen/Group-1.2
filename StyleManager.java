import java.util.*;
import javafx.scene.Node;

public class StyleManager {
	private StyleManager(){
	}

	public static void setStyleClass(String targetText, Node... nodes) {
		for(Node node : nodes) {
			node.getStyleClass().add(targetText);
		}
	}
}