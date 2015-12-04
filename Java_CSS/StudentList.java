import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.control.ScrollPane;

public class StudentList {
	private GridPane pane;
	private ArrayList<Label> names;
	private ArrayList<Label> emails;
	private ArrayList<ProgressBar> statuses;
	private ScrollPane scrollPane;

	StudentList() {
		pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);

		names = new ArrayList<>();
		//note that all these fields need to come from the database.
		Label name1 = new Label("Name name");
		Label name2 = new Label("D-dawg MacJackson");
		Label name3 = new Label("Surferdude");
		names.add(name1);
		names.add(name2);
		names.add(name3);

		emails = new ArrayList<>();
		Label email1 = new Label("horselover@ranchinglyfe.com");
		Label email2 = new Label("dropdebeet@therapbattle.com");
		Label email3 = new Label("surfindude@californialove.com");
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

		StyleManager.setStyleClass("GridPane", pane);
	}

	protected GridPane drawStudentList() {
		if ((names != null) && (names.size() > 0)) {
			for(int i = 0; i < names.size(); i++) {
				if (names.get(i) instanceof Label) {
					pane.add(names.get(i), 0, i);
					names.get(i).setFont(new Font(18));
				}
			}
		}

		if ((emails != null) && (emails.size() > 0)) {
			for(int i = 0; i < emails.size(); i++) {
				if (emails.get(i) instanceof Label) {
					pane.add(emails.get(i), 1, i);
					emails.get(i).setFont(new Font(18));
				}
			}
		}

		if ((statuses != null) && (statuses.size() > 0)) {
			for (int i = 0; i < statuses.size(); i++) {
				if(statuses.get(i) instanceof ProgressBar) {
					pane.add(statuses.get(i), 2, i);
				}
			}
		}

		return pane;
	}

	protected void hideStudentList() {
        if (scrollPane != null) {
            scrollPane = null;
        }

        if (names.size() > 0) {
            names.clear();
        }

        if (emails.size() > 0) {
            emails.clear();
        }

        if (statuses.size() > 0) {
            statuses.clear();
        }
    }
}