	/**
	 * This is a interface of Game Panel
	 * this class is controlled by GameController
	 * 
	 * this class only allocates all labels and buttons on the Panel
	 * 
	 * @author hche608
	 * 
	 */
package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GamePanelUI {
	Resourses res = Main.res;
	Group root;
	GameController controller;

	public GamePanelUI(GameController controller) {
		root = new Group();
		try {

			this.controller = controller;
			/*
			 * Bottom Line
			 */

			Text counter = new Text("Time: ");
			counter.setFont(res.minecrafter_font_label);
			counter.setFill(Color.BLACK);
			counter.setLayoutX(20);
			counter.setLayoutY(res.FRAME_HEIGHT - 10);

			final Button btn_pre = new Button();
			btn_pre.setGraphic(res.gamePanelUI_previous_Image);
			btn_pre.setBorder(null);
			btn_pre.setBackground(null);
			btn_pre.setScaleShape(false);
			btn_pre.setLayoutX(250);
			btn_pre.setLayoutY(res.FRAME_HEIGHT - 55);
			btn_pre.setCursor(Cursor.HAND);
			btn_pre.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					controller.previousLevel();
					;
				}
			});

			final Button btn_pause = new Button();
			btn_pause.setGraphic(res.gamePanelUI_pause_Image);
			btn_pause.setBorder(null);
			btn_pause.setBackground(null);
			btn_pause.setLayoutX(385);
			btn_pause.setLayoutY(res.FRAME_HEIGHT - 55);
			btn_pause.setCursor(Cursor.HAND);
			btn_pause.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					controller.pauseORresumeTimer();
				}
			});

			final Button btn_next = new Button();
			btn_next.setGraphic(res.gamePanelUI_next_Image);
			btn_next.setBorder(null);
			btn_next.setBackground(null);
			btn_next.setLayoutX(520);
			btn_next.setLayoutY(res.FRAME_HEIGHT - 55);
			btn_next.setCursor(Cursor.HAND);
			btn_next.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					controller.setCountDown(40);
					controller.nextLevel();
				}
			});

			final Button btn_mute = new Button();
			btn_mute.setGraphic(res.gamePanelUI_mute_Image);
			btn_mute.setBorder(null);
			btn_mute.setBackground(null);
			btn_mute.setLayoutX(655);
			btn_mute.setLayoutY(res.FRAME_HEIGHT - 55);
			btn_mute.setCursor(Cursor.HAND);
			btn_mute.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					controller.loadMainUI();
				}
			});

			Group lowBTNs = new Group(btn_pre, btn_pause, btn_next, btn_mute);
			root.getChildren().addAll(lowBTNs, counter);

		} catch (Exception e) {
			System.out.println("Initial game panel error: " + e);
		}

	}

	public Group getGamePanelUI() {
		return root;
	}

}
