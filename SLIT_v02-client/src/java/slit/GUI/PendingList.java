/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import DTOs.ProgressDTO;
import java.awt.Color;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import slit.main.Main;

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
    private final int buttonSize = 30;
    private final int selectedButtonSize = 50;
    private ImageView selectedView = null;

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

        gridPane.getChildren().clear();
        Collection<ProgressDTO> progressList = Main.getProgressBean().getAllPendingProgress();
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        //scrollPane.setPrefWidth(1600);

        // decides how far appart the boxes should be

        gridPane.setHgap(30);
        gridPane.setVgap(10);
        //gridPane.setGridLinesVisible(true);
        gridPane.setMinWidth(90000);


        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);

        Button b = new Button("Download");

        Image approvedImage = new Image(
                PendingList.class
                .getResource(
                        "green_cross.png").toExternalForm(), false);
        Image disapprovedImage = new Image(
                SuperView.class
                .getResource(
                        "cross.png").toExternalForm(), false);

        if (progressList == null || progressList.isEmpty()) {
            gridPane.add(new Text("No pending files."), 0, 0);
        } else {
            int rowPosition = 0;
            for (ProgressDTO progressDTO : progressList) {

                Text userName = new Text(progressDTO.user.name);
                gridPane.add(userName, 0, rowPosition);

                Text moduleName = new Text(progressDTO.module.name);
                gridPane.add(moduleName, 1, rowPosition);
                
                Button downloadButton = new Button("Download");
                gridPane.add(downloadButton, 2, rowPosition);

//                gridPane.add(b, 2, rowPosition);
                ImageView approvedImageView = new ImageView(approvedImage);
                approvedImageView.setFitHeight(buttonSize);
                approvedImageView.setFitWidth(buttonSize);
                gridPane.add(approvedImageView, 4, rowPosition);
                DropShadow selectedShadowAp = new DropShadow(selectedButtonSize, javafx.scene.paint.Color.BLACK);
                approvedImageView.setOnMouseClicked((event) -> {
                    System.out.println("Approved Button was clicked ");

                    if (selectedView != null) {                    //resizes the previous selected Picture to only allow one file beeing selected
//                    selectedView.setFitHeight(buttonSize);
//                    selectedView.setFitWidth(buttonSize);
                        selectedView.setEffect(null);
                    }
//                    disapprovedImageView.setFitHeight(selectedButtonSize);
//                    disapprovedImageView.setFitWidth(selectedButtonSize);
                    approvedImageView.setEffect(selectedShadowAp);
                    selectedView = approvedImageView;

                });

                ImageView disapprovedImageView = new ImageView(disapprovedImage);
                disapprovedImageView.setFitHeight(buttonSize);
                disapprovedImageView.setFitWidth(buttonSize);
                gridPane.add(disapprovedImageView, 5, rowPosition);

                DropShadow selectedShadowDis = new DropShadow(selectedButtonSize, javafx.scene.paint.Color.RED);

                disapprovedImageView.setOnMouseClicked((event) -> {
                    System.out.println("Disapproved Button was clicked ");

                    if (selectedView != null) {                    //resizes the previous selected Picture to only allow one file beeing selected
//                    selectedView.setFitHeight(buttonSize);
//                    selectedView.setFitWidth(buttonSize);
                        selectedView.setEffect(null);
                    }
//                    disapprovedImageView.setFitHeight(selectedButtonSize);
//                    disapprovedImageView.setFitWidth(selectedButtonSize);
                    disapprovedImageView.setEffect(selectedShadowDis);
                    selectedView = disapprovedImageView;
                });

                Button confirm = new Button("Confirm");
                confirm.setOnMouseClicked((event) -> {
                    System.out.println("Confirm Button was clicked ");
                    if(selectedView!=null && selectedView == approvedImageView){
                        Main.getProgressBean().setProgress(progressDTO.id, true);
                    }
                    else if(selectedView != null && selectedView == disapprovedImageView){
                        Main.getProgressBean().setProgress(progressDTO.id, false);
                    }
                    
                    drawPendingList();
                });
                gridPane.add(confirm, 6, rowPosition);

                rowPosition++;
            }
        }

//        if (names.size() > 0
//                && buttons.size() > 0
//                && radioButtonPairs.size() > 0) {
//            for (int i = 0; i < names.size(); i++) {
//                if (names.get(i) instanceof Text) {
//                    gridPane.add(names.get(i), 0, i);
//                }
//            }
//
//            for (int i = 0; i < buttons.size(); i++) {
//                if (buttons.get(i) instanceof Button) {
//                    gridPane.add(buttons.get(i), 1, i);
//                }
//            }
//
//            for (int i = 0; i < radioButtonPairs.size(); i++) {
//                if (radioButtonPairs.get(i) instanceof HBox) {
//                    gridPane.add(radioButtonPairs.get(i), 2, i);
//                }
//            }
//
//            for (int i = 0; i < confirmButtons.size(); i++) {
//                if (confirmButtons.get(i) instanceof Button) {
////                    gridPane.add(confirmButtons.get(i), 3, i);
//                }
//            }
        topBox.getChildren()
                .add(gridPane);
        scrollPane.setContent(topBox);

        scrollPane.setFitToHeight(
                true);
        scrollPane.setFitToWidth(
                true);

        return scrollPane;
    }

    /**
     * @deprecated
     */
    private void retrieveData() {
        ToggleGroup group = new ToggleGroup();
        // replace i < 100 with amount of users in database

        System.out.println("Trying to get pending progress....");
        Collection<ProgressDTO> progressDTO = Main.getProgressBean().getAllPendingProgress();
        System.out.println("retrieved all pending progress. count = " + progressDTO.size());
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
                    PendingList.class
                    .getResource(
                            "green_cross.png").toExternalForm(), false);
            Image disapprovedImage = new Image(
                    SuperView.class
                    .getResource(
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
