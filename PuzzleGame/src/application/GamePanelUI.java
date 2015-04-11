package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GamePanelUI {
	Resourses res;
	Stage primaryStage;
	GameController controller;

	public GamePanelUI(Stage primaryStage, Resourses res,
			GameController controller) {
		this.controller = controller;
		this.res = res;
		this.primaryStage = primaryStage;

	}

	public void show() {

		final Group background = new Group(res.background_Image);

		final Button redo = new Button();
		redo.setGraphic(res.gamePanelUI_redo_Image);
		redo.setBorder(null);
		redo.setBackground(null);
		redo.setCursor(Cursor.HAND);

		final Button flip = new Button();
		flip.setGraphic(res.gamePanelUI_flip_Image);
		flip.setBorder(null);
		flip.setBackground(null);
		flip.setCursor(Cursor.HAND);

		final Button hbtn1 = new Button();
		hbtn1.setGraphic(res.gamePanelUI_counterclockwise_rotate_Image);
		hbtn1.setBorder(null);
		hbtn1.setBackground(null);

		final Button hbtn2 = new Button();
		hbtn2.setGraphic(res.gamePanelUI_clockwise_rotate_Image);
		hbtn2.setBorder(null);
		hbtn2.setBackground(null);
		hbtn2.setAlignment(Pos.BASELINE_RIGHT);

		final HBox hbtns = new HBox(hbtn1, hbtn2);

		final VBox topBTNs = new VBox(redo, flip, hbtns);
		topBTNs.alignmentProperty();
		topBTNs.setAlignment(Pos.CENTER);
		topBTNs.setLayoutX(50.0);
		topBTNs.setLayoutY(50.0);

		/*
		 * Bottom Line
		 */
		Text counter = new Text("Time: ");
		counter.setFont(res.minecrafter_font_label);
		counter.setFill(Color.BLACK);
		counter.setLayoutX(20);
		counter.setLayoutY(res.FRAME_HEIGHT - 10);

		final Label timerLabel;
		timerLabel = controller.getTimerLabel();
		timerLabel.setLayoutX(100);
		timerLabel.setLayoutY(res.FRAME_HEIGHT - 50);

		final Button btn_pre = new Button();
		btn_pre.setGraphic(res.gamePanelUI_previous_Image);
		btn_pre.setBorder(null);
		btn_pre.setBackground(null);
		btn_pre.setScaleShape(false);
		btn_pre.setLayoutX(250);
		btn_pre.setLayoutY(res.FRAME_HEIGHT - 55);
		btn_pre.setCursor(Cursor.HAND);

		final Button btn_pause = new Button();
		btn_pause.setGraphic(res.gamePanelUI_pause_Image);
		btn_pause.setBorder(null);
		btn_pause.setBackground(null);
		btn_pause.setLayoutX(385);
		btn_pause.setLayoutY(res.FRAME_HEIGHT - 55);
		btn_pause.setCursor(Cursor.HAND);

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

			}
		});

		final Group lowBTNs = new Group(btn_pre, btn_pause, btn_next, btn_mute);

		final Group gameBoard = controller.loadCube();
		final Group root = new Group(background, topBTNs, lowBTNs, counter,
				timerLabel, gameBoard);

		Scene scene = new Scene(root, res.FRAME_WIDTH, res.FRAME_HEIGHT);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tangram Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
