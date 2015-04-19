package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LevelUI {

	Resourses res = Main.res;
	Group root;

	public LevelUI(GameController controller) {
		root = new Group();
		try {

			GridPane level_btns = new GridPane();
			level_btns.setHgap(30);
			level_btns.setVgap(30);
			level_btns.setPadding(new Insets(0, 10, 0, 10));

			final Button btn = new Button();
			btn.setGraphic(res.LevelUI_Images.get(0));
			level_btns.add(btn, 1, 0);
			btn.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadGame(1);
				}
			});

			final Button btn2 = new Button("2");
			level_btns.add(btn2, 2, 0);
			btn2.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn3 = new Button("3");
			level_btns.add(btn3, 3, 0);
			btn3.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn4 = new Button("4");
			level_btns.add(btn4, 4, 0);
			btn4.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn5 = new Button("5");
			level_btns.add(btn5, 5, 0);
			btn5.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn6 = new Button("6");
			level_btns.add(btn6, 1, 1);
			btn6.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn7 = new Button("7");
			level_btns.add(btn7, 2, 1);
			btn7.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn8 = new Button("8");
			level_btns.add(btn8, 3, 1);
			btn8.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn9 = new Button("9");
			level_btns.add(btn9, 4, 1);
			btn9.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final Button btn10 = new Button("10");
			level_btns.add(btn10, 5, 1);
			btn10.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);

			final VBox btns = new VBox(level_btns);
			btns.setAlignment(Pos.CENTER);
			btns.setLayoutX((res.FRAME_WIDTH - (res.BTN_MINWIDTH + 30) * 5) / 2);
			btns.setLayoutY((res.FRAME_HEIGHT - res.BTNS_HEIGHT) / 2);

			// return btn
			final Button rbtn = new Button("Return");
			rbtn.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);
			rbtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadMainUI();
				}
			});

			final VBox btm_btn = new VBox(rbtn);

			btm_btn.setAlignment(Pos.CENTER);
			btm_btn.setLayoutX((res.FRAME_WIDTH - 3 * res.BTN_MINWIDTH));
			btm_btn.setLayoutY((res.FRAME_HEIGHT - 2 * res.BTN_MINHEIGHT));

			root.getChildren().addAll(btns, btm_btn);
		} catch (Exception e) {
			System.out.println("Initial Level UI error: " + e);
		}

	}

	public Group getLevelUI() {
		return root;

	}

}
