/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

	PendingList() {
		gridPane = new GridPane();
		scrollPane = new ScrollPane();
		nameBox = new VBox(5);
		buttonBox = new VBox(5);
		radioButtonBox = new VBox(5);
		names = new ArrayList<>();
		buttons = new ArrayList<>();
		radioButtonPairs = new ArrayList<>();
	}

	protected ScrollPane drawPendingList() {
		retrieveData();

		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);

		// decides how far appart the boxes should be
		gridPane.setHgap(300);

		HBox topBox = new HBox(5);
		topBox.setAlignment(Pos.CENTER);

		if (names.size() > 0 && 
			buttons.size() > 0 && 
			radioButtonPairs.size() > 0) {
			for (int i = 0; i < names.size(); i++) {
				if (names.get(i) instanceof Text) {
					nameBox.getChildren().add(names.get(i));
					names.get(i).setFont(new Font(18));
				}
			}

			for (int i = 0; i < buttons.size(); i++) {
				if (buttons.get(i) instanceof Button) {
					buttonBox.getChildren().add(buttons.get(i));
				}
			}

			for (int i = 0; i < radioButtonPairs.size(); i++) {
				if (radioButtonPairs.get(i) instanceof HBox) {
					radioButtonBox.getChildren().add(radioButtonPairs.get(i));
				}
			}
		}

		gridPane.add(nameBox, 0, 0);
		gridPane.add(buttonBox, 1, 0);
		gridPane.add(radioButtonBox, 2, 0);
		topBox.getChildren().add(gridPane);
		scrollPane.setContent(topBox);

		return scrollPane;
	}


	private void retrieveData() {
		ToggleGroup group = new ToggleGroup();
		// replace i < 100 with amount of users in database
		for (int i = 0; i < 100; i++) {
			Text t = new Text("name " + i);
			names.add(t);

			Button b = new Button("Download " + i);
			buttons.add(b);

			HBox h = new HBox(10);
			Text rbtn1Text = new Text("approve");
			Text rbtn2Text = new Text("disapprove");

			RadioButton rbtn1 = new RadioButton(rbtn1Text.getText());
			RadioButton rbtn2 = new RadioButton(rbtn2Text.getText());
			
			rbtn1.setOnAction(e -> {
				rbtn1Text.setFill(Color.GREEN);
				rbtn1.setText(rbtn1Text.getText());
				rbtn2Text.setFill(Color.BLACK);
				rbtn2.setText(rbtn2Text.getText());
			});

			rbtn2.setOnAction(e -> {
				rbtn2Text.setFill(Color.RED);
				rbtn2.setText(rbtn2Text.getText());
				rbtn1Text.setFill(Color.BLACK);
				rbtn1.setText(rbtn1Text.getText());
			});
			
			rbtn1.setToggleGroup(group);
			rbtn2.setToggleGroup(group);

			Image approvedImage = new Image("green_cross.png");
			Image disapprovedImage = new Image("cross.png");
			ImageView approvedImageView = new ImageView();
			ImageView disapprovedImageView = new ImageView();
			approvedImageView.setImage(approvedImage);
			disapprovedImageView.setImage(disapprovedImage);

			h.getChildren().addAll(
				rbtn1, disapprovedImageView, rbtn2, approvedImageView);
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