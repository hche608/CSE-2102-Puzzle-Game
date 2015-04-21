/**
 * This is a interface of Completed Game
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CompletedGameUI {
	Resourses res = Main.res;
	Group root;
	final GameController controller;

	public CompletedGameUI(GameController controller, Player player) {
		root = new Group();
		Text title = new Text();
		this.controller = controller;
		try {
			if (player.getScore() > 0) {
				try {
					title.setText("You Win!\n" + player.getPlayerName());

				} catch (Exception e) {
					System.out
							.println("Initial Player in Completed Game UI error: "
									+ e);
				}
			} else {
				try {
					title.setText("TRY AGAIN!\n" + player.getPlayerName());

				} catch (Exception e) {
					System.out
							.println("Initial TRY AGAIN in Completed Game UI error: "
									+ e);
				}
			}
			title.setFont(res.minecrafter_font_title);
			title.setTranslateX(160);
			title.setTranslateY(175);
			title.setFill(Color.BLACK);

			final Button btn_OK = new Button();
			btn_OK.setGraphic(res.btn_OK_Image);
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setCursor(Cursor.HAND);
			btn_OK.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.btn_OK_Image1);
				}
			});
			btn_OK.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.btn_OK_Image);
				}
			});
			btn_OK.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadGame(controller.getLastPlayer()
							.getCurrentLevel());
					e.consume();
				}
			});

			root.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					if (e.getCode() == KeyCode.ENTER) {
						if (controller.getLastPlayer().getCurrentLevel() < res.numOfLevel) {
							controller.loadGame(controller.getLastPlayer()
									.getCurrentLevel());
						} else {
							controller.loadScoresUI();
						}
						e.consume();
					}
				}
			});
			root.getChildren().addAll(title, btn_OK);
		} catch (Exception e) {
			System.out.println("Initial Player in Completed Game UI error: "
					+ e);
		}
	}

	public Group getCompletedGameUI() {
		return root;
	}
}
