package slit.GUI;

import DTOs.UserDTO;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import slit.search.TreeSearch;

/**
 *
 * @author Jorgen
 */
public class StudentList {

    private GridPane gridPane;
    private ScrollPane scrollPane;
    private ArrayList<Text> names;
    private ArrayList<Text> emails;
    private ArrayList<ProgressBar> statuses;
    private TextField nameSearchBar;
    private TextField emailSearchBar;
    private HBox searchBarBox;

    StudentList() {
        gridPane = new GridPane();
        scrollPane = new ScrollPane();
        names = new ArrayList<>();
        emails = new ArrayList<>();
        statuses = new ArrayList<>();
        nameSearchBar = new TextField("enter name");
        emailSearchBar = new TextField("enter email");
        searchBarBox = new HBox(200);
    }

    protected ScrollPane drawStudentList() {
        retrieveStudentInfo();

        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        // decides how far appart the boxes should be
        gridPane.setHgap(200);

        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);
        VBox nameBox = new VBox(5);
        VBox emailBox = new VBox(5);
        VBox statusBox = new VBox(5);

        if (names.size() > 0 && emails.size() > 0 && statuses.size() > 0) {
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i) instanceof Text) {
                    nameBox.getChildren().add(names.get(i));
                    names.get(i).setFont(new Font(18));
                }
            }

            for (int i = 0; i < emails.size(); i++) {
                if (emails.get(i) instanceof Text) {
                    emailBox.getChildren().add(emails.get(i));
                    emails.get(i).setFont(new Font(18));
                }
            }

            for (int i = 0; i < statuses.size(); i++) {
                if (statuses.get(i) instanceof ProgressBar) {
                    statusBox.getChildren().add(statuses.get(i));
                }
            }
        }

        gridPane.add(nameBox, 0, 0);
        gridPane.add(emailBox, 1, 0);
        gridPane.add(statusBox, 2, 0);

        topBox.getChildren().add(gridPane);
        scrollPane.setContent(topBox);

        return scrollPane;
    }

    protected HBox drawSearchBars() {
        searchBarBox.setAlignment(Pos.CENTER);
        searchBarBox.getChildren().addAll(nameSearchBar, emailSearchBar);
        return searchBarBox;
    }

    /*
        * @method retireveStudentInfo; This method should collect the name, email
        * and progress for each student from the database and fill up the ArrayLists
        * "names", "emails", and "statuses". Note that names and emails needs to get
        * string passed in to their constructor parameter while ProgressBar needs
        * a double value.
     */
    private void retrieveStudentInfo() {
        //note that this is just dummy code to test scrollbar functionality.
//            List<UserDTO> userList = Main.getMyUserManager().getUserList();
        List<UserDTO> userList = TreeSearch.getSearchTree().getUsers("");
        for (int i = 0; i < userList.size(); i++) {

            UserDTO u = userList.get(i);
            names.add(new Text(u.name));
            emails.add(new Text(u.mail));
//                    names.add(new Text("name"));
//                    emails.add(new Text("mail"));
            statuses.add(new ProgressBar(Math.random()));
        }
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

        if (searchBarBox != null) {
            searchBarBox.getChildren().clear();
        }
    }
}
