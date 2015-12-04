package slit.GUI;

import DTOs.UserDTO;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import com.sun.javafx.scene.control.skin.ColorPalette;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import slit.main.Main;
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
    private HBox searchBarBox;

    StudentList() {

        gridPane = new GridPane();
        scrollPane = new ScrollPane();
        names = new ArrayList<>();
        emails = new ArrayList<>();
        statuses = new ArrayList<>();
        nameSearchBar = new TextField("enter name");
        nameSearchBar.setMinWidth(300);
        searchBarBox = new HBox(200);
        System.out.println("Add listener to namesearch");
        nameSearchBar.setOnKeyReleased((event) -> {
            System.out.println("Searchbar key pressed. search for " + nameSearchBar.getText());
            drawStudentList(nameSearchBar.getText());
        });
        StyleManager.setStyleClass("Pane", scrollPane);
    }

    protected ScrollPane drawStudentList() {
        return drawStudentList("");
    }

    protected ScrollPane drawStudentList(String name) {
        if (name == null) {
            name = "";
        }
        gridPane.getChildren().clear();

        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        // decides how far appart the boxes should be

        gridPane.setHgap(200);
        gridPane.setVgap(5);


        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);

        List<UserDTO> users = TreeSearch.getSearchTree().getUsers(name);

        if (users == null || users.isEmpty()) {
            gridPane.add(new Text("No user starting with " + name),0,0);

        } else {
            int rowPosition = 0;
            for (UserDTO u : users) {


                Text userName = new Text(u.name);
//                nameBox.getChildren().add(userName);
                userName.setFont(new Font(17));

                gridPane.add(userName, 0, rowPosition);

                Text userMail = new Text(u.mail);
//                emailBox.getChildren().add(usermail);
                userMail.setFont(new Font(17));
                gridPane.add(userMail, 1, rowPosition);

//                statusBox.getChildren().add(new ProgressBar(Main.getProgressBean().getUserProgress(u.id)));
                gridPane.add(new ProgressBar(Main.getProgressBean().getUserProgress(u.id)), 2, rowPosition);

                rowPosition++;
            }
        }

        topBox.getChildren().add(gridPane);
        scrollPane.setContent(topBox);

        return scrollPane;
    }

    protected HBox drawSearchBars() {
        searchBarBox.setAlignment(Pos.CENTER);
        searchBarBox.getChildren().addAll(nameSearchBar);
        return searchBarBox;
    }

    /*
        * @method retireveStudentInfo; This method should collect the name, email
        * and progress for each student from the database and fill up the ArrayLists
        * "names", "emails", and "statuses". Note that names and emails needs to get
        * string passed in to their constructor parameter while ProgressBar needs
        * a double value.
     */
    /**
     * @deprecated @param name
     */
    private void retrieveStudentInfo(String name) {
        //note that this is just dummy code to test scrollbar functionality.
//            List<UserDTO> userList = Main.getMyUserManager().getUserList();

        long timeNow = Calendar.getInstance(Locale.ENGLISH).getTimeInMillis();

        List<UserDTO> userList = TreeSearch.getSearchTree().getUsers(name);
        for (int i = 0; i < userList.size(); i++) {
            names = new ArrayList<>();
            UserDTO u = userList.get(i);
            names.add(new Text(u.name));
            emails.add(new Text(u.mail));
//                    names.add(new Text("name"));
//                    emails.add(new Text("mail"));
            statuses.add(new ProgressBar(Main.getProgressBean().getUserProgress(u.id))); //ProgressManagerBean.getStudentsProgress(u.id); 

        }
        System.out.println("time start = " + timeNow);
        System.out.println("time now = " + Calendar.getInstance(Locale.ENGLISH).getTimeInMillis());
        System.out.println("time to search for users  = " + (long) (Calendar.getInstance(Locale.ENGLISH).getTimeInMillis() - timeNow));
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
