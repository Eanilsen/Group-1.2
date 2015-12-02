/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import DTOs.ProgressDTO;
import DTOs.UserDTO;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import slit.main.Main;
import slit.search.TreeSearch;

/**
 *
 * @author Jorgen
 */
public class PendingList {

    private GridPane gridPane;
    private ScrollPane scrollPane;
    private VBox nameBox;
    private VBox buttonBox;
    private VBox radioButtonBox;
    private ArrayList<Text> names;
    private ArrayList<Button> buttons;
    private ArrayList<HBox> radioButtonPairs;
    private ArrayList<Button> confirmButtons;
    private VBox confButtonBox;

    PendingList() {
        gridPane = new GridPane();
        scrollPane = new ScrollPane();
        nameBox = new VBox(5);
        buttonBox = new VBox(5);
        radioButtonBox = new VBox(5);
        confButtonBox = new VBox(5);
        names = new ArrayList<>();
        buttons = new ArrayList<>();
        radioButtonPairs = new ArrayList<>();
        confirmButtons = new ArrayList<>();
        StyleManager.setStyleClass("Pane", gridPane);
    }

    protected ScrollPane drawPendingList() {
        retrieveData();

        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        //scrollPane.setPrefWidth(1600);

        // decides how far appart the boxes should be
        gridPane.setHgap(120);
        gridPane.setVgap(20);
        //gridPane.setGridLinesVisible(true);
        gridPane.setMinWidth(90000);

        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);

        if (names.size() > 0
                && buttons.size() > 0
                && radioButtonPairs.size() > 0) {
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i) instanceof Text) {
                    gridPane.add(names.get(i), 0, i);
                }
            }

            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i) instanceof Button) {
                    gridPane.add(buttons.get(i), 1, i);
                }
            }

            for (int i = 0; i < radioButtonPairs.size(); i++) {
                if (radioButtonPairs.get(i) instanceof HBox) {
                    gridPane.add(radioButtonPairs.get(i), 2, i);
                }
            }

            for (int i = 0; i < confirmButtons.size(); i++) {
                if (confirmButtons.get(i) instanceof Button) {
//                    gridPane.add(confirmButtons.get(i), 3, i);
                }
            }
        }

        topBox.getChildren().add(gridPane);
        scrollPane.setContent(topBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        return scrollPane;
    }

    private void retrieveData() {
        ToggleGroup group = new ToggleGroup();
        // replace i < 100 with amount of users in database
        
        System.out.println("Trying to get pending progress....");
        Collection<ProgressDTO> progressDTO = Main.getProgressBean().getAllPendingProgress();
        System.out.println("retrieved all pending progress. count = " + progressDTO.size() );
        for (ProgressDTO p : progressDTO) {
            
            names.add(new Text(p.user.name + " / " + p.module.name));
            
            Button b = new Button("Download");
            buttons.add(b);

            Button confB = new Button("Confirm");
            confirmButtons.add(confB);

            HBox h = new HBox(5);
            //Text rbtn1Text = new Text("approve");
            //Text rbtn2Text = new Text("disapprove");

            RadioButton rbtn1 = new RadioButton();
            RadioButton rbtn2 = new RadioButton();

            rbtn1.setToggleGroup(group);
            rbtn2.setToggleGroup(group);
            Image approvedImage = new Image(
                    PendingList.class.getResource(
                            "green_cross.png").toExternalForm(), false);
            Image disapprovedImage = new Image(
                    SuperView.class.getResource(
                            "cross.png").toExternalForm(), false);
            //Image approvedImage = new Image("file:green_cross.png");
            //Image disapprovedImage = new Image("file:cross.png");
            ImageView approvedImageView = new ImageView();
            ImageView disapprovedImageView = new ImageView();
            approvedImageView.setImage(approvedImage);
            disapprovedImageView.setImage(disapprovedImage);

            h.getChildren().addAll(
                    rbtn1, approvedImageView, rbtn2, disapprovedImageView, confB);
            radioButtonPairs.add(h);
        }
    }

    protected void hidePendingList() {
        if (scrollPane != null) {
            scrollPane = null;
        }

        if (names.size() > 0) {
            names.clear();
        }

        if (buttons.size() > 0) {
            buttons.clear();
        }
    }
}
