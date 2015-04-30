/**
 * This is a interface of Score Panel
 * this class is controlled by GameController
 * 
 * this class only allocates all labels and buttons on the Panel
 * 
 * @author hche608
 * 
 */
package application.UIs;

import java.util.ArrayList;

import application.Main;
import application.Resourses;
import application.Controllers.GameController;
import application.Data.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ScoresListUI {
	private Resourses res = Main.res;
	private Group root;
	private Text name, format, score;
	private VBox list1, list2, list3;
	private HBox table;

	public ScoresListUI(GameController controller, ArrayList<Player> players) {
		root = new Group();
		list1 = new VBox();
		list2 = new VBox();
		list3 = new VBox();
		table = new HBox();
		// name list
		try {
			for (int index = 0; index < players.size(); index++) {
				name = new Text(players.get(index).getPlayerName());
				name.setFont(res.minecrafter_font_title);
				name.setTextAlignment(TextAlignment.LEFT);
				name.setFill(Color.BLACK);
				list1.getChildren().add(name);
			}
			list1.setAlignment(Pos.CENTER_LEFT);
			table.getChildren().add(list1);
		} catch (Exception e) {
			System.out.println("Initial Names in Scores UI error: " + e);
		}

		// format list
		try {
			for (int index = 0; index < players.size(); index++) {
				format = new Text("    ....................    ");
				format.setFont(res.minecrafter_font_title);
				format.setTextAlignment(TextAlignment.CENTER);
				format.setFill(Color.BLACK);
				list2.getChildren().add(format);
			}
			list2.setAlignment(Pos.CENTER);
			table.getChildren().add(list2);
		} catch (Exception e) {
			System.out.println("Initial format in Scores UI error: " + e);
		}

		// score list
		try {
			for (int index = 0; index < players.size(); index++) {
				score = new Text("" + players.get(index).getScore());
				score.setFont(res.minecrafter_font_title);
				score.setTextAlignment(TextAlignment.RIGHT);
				score.setFill(Color.BLACK);
				list3.getChildren().add(score);
			}
			list3.setAlignment(Pos.CENTER_RIGHT);
			table.getChildren().add(list3);
		} catch (Exception e) {
			System.out.println("Initial Scores in Scores UI error: " + e);
		}

		try {
			// return btn
			final Button rbtn = new Button();
			rbtn.setBorder(null);
			rbtn.setBackground(null);
			rbtn.setCursor(Cursor.HAND);
			rbtn.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);
			rbtn.setGraphic(res.btn_Return_Image);
			rbtn.setTranslateX((res.FRAME_WIDTH - 3 * res.BTN_MINWIDTH));
			rbtn.setTranslateY((res.FRAME_HEIGHT - 2 * res.BTN_MINHEIGHT));
			rbtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					rbtn.setGraphic(res.btn_Return_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			rbtn.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					rbtn.setGraphic(res.btn_Return_Image);

				}
			});
			rbtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadMainUI();
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
				}
			});
			table.setTranslateX(res.FRAME_WIDTH * 1 / 10);
			table.setTranslateY(res.FRAME_HEIGHT * 1 / 30);
			root.getChildren().addAll(table, rbtn);
		} catch (Exception e) {
			System.out.println("Initial Scores UI error: " + e);
		}

	}

	public Group getScoresUI() {
		return root;
	}

}
