import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.shape.Line;

public class StudentList {
	private GridPane gridPane;
	private ScrollPane scrollPane;
	private ArrayList<Text> names;
	private ArrayList<Text> emails;
	private ArrayList<ProgressBar> statuses;

	StudentList() {
		gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);

		names = new ArrayList<>();
		//note that all the strings contained in these Texts must come from
		//the databse somehow
		Text name1 = new Text("Name name");
		Text name2 = new Text("D-dawg MacJackson");
		Text name3 = new Text("Surferdude");
		names.add(name1);
		names.add(name2);
		names.add(name3);

		emails = new ArrayList<>();
		Text email1 = new Text("horselover@ranchinglyfe.com");
		Text email2 = new Text("dropdebeet@therapbattle.com");
		Text email3 = new Text("surfindude@californialove.com");
		emails.add(email1);
		emails.add(email2);
		emails.add(email3);

		statuses = new ArrayList<>();
		ProgressBar pb1 = new ProgressBar(1);
		ProgressBar pb2 = new ProgressBar(0.7);
		ProgressBar pb3 = new ProgressBar(0.3);
		statuses.add(pb1);
		statuses.add(pb2);
		statuses.add(pb3);
	}

	protected GridPane drawStudentList() {
		if ((names != null) && (names.size() > 0)) {
			for(int i = 0; i < names.size(); i++) {
				if (names.get(i) instanceof Text) {
					gridPane.add(names.get(i), 0, i);
					names.get(i).setFont(new Font(18));
				}
			}
		}



		if ((emails != null) && (emails.size() > 0)) {
			for(int i = 0; i < emails.size(); i++) {
				if (emails.get(i) instanceof Text) {
					gridPane.add(emails.get(i), 1, i);
					emails.get(i).setFont(new Font(18));
				}
			}
		}

		if ((statuses != null) && (statuses.size() > 0)) {
			for (int i = 0; i < statuses.size(); i++) {
				if(statuses.get(i) instanceof ProgressBar) {
					gridPane.add(statuses.get(i), 2, i);
				}
			}
		}

		return gridPane;
	}
}