package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LevelUI {

	Resourses res = Main.res;
	Group root;
	ArrayList<Button> btns_list;

	public LevelUI(GameController controller) {
		root = new Group();
		try {

			GridPane level_btns = new GridPane();
			level_btns.setHgap(30);
			level_btns.setVgap(30);
			level_btns.setPadding(new Insets(0, 10, 0, 10));

			btns_list = new ArrayList<Button>();
			int row = 0;
			for (int i = 0; i < res.numOfLevel; i++) {
				final Button btn = new Button();
				btn.setGraphic(res.LevelUI_Images.get(i));
				if (i > 0 && i % 4 == 0) {
					row++;
				}
				level_btns.add(btn, (i) % 4, row);
				btns_list.add(btn);
				btn.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);
				btn.setBorder(null);
				btn.setBackground(null);
				final int level = i;
				btn.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						controller.loadGame(1 + level);
						System.out.println("Level: " + (1 + level));
					}
				});
			}

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

	public void unlock(int level) {
		for (int i = 0; i < level; i++) {
			btns_list.get(i).setGraphic(res.LevelUI_Images.get(i));
			final int btn_index = i;
			btns_list.get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btns_list.get(btn_index).setGraphic(
							res.LevelUI_Images1.get(btn_index));
				}
			});
			btns_list.get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btns_list.get(btn_index).setGraphic(
							res.LevelUI_Images.get(btn_index));
				}
			});
		}
	}

}
