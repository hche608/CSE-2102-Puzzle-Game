/**
 * This is a interface of Completed Game
 * this class is controlled by GameController
 * 
 * this class only allocates all labels and buttons on the Panel
 * 
 * @author hche608
 * 
 */
package application.UIs;

import application.Main;
import application.Resourses;
import application.Controllers.GameController;
import application.Data.Player;
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
import javafx.scene.text.TextAlignment;

public class CompletedGameUI {
	private Resourses res = Main.res;
	private Group root;
	GameController controller;

	public CompletedGameUI(GameController controller, Player player) {
		root = new Group();
		Text title = new Text();
		this.controller = controller;
		System.out.println("Score: " + controller.getCountDown());
		try {
			if (controller.getCountDown() > 0) {
				try {
					title.setText("You Win!\n Click OK move to next level!" + player.getPlayerName());

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
			title.setFont(res.minecrafter_font_label);
			title.setTranslateX(res.FRAME_WIDTH * 1 / 4);
			title.setTranslateY(res.FRAME_HEIGHT * 1 / 3);
			title.setTextAlignment(TextAlignment.CENTER);
			title.setFill(Color.BLACK);

			final Button btn_OK = new Button();
			btn_OK.setGraphic(res.btn_OK_Image);
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setCursor(Cursor.HAND);
			btn_OK.setTranslateX(res.FRAME_WIDTH * 3 / 10);
			btn_OK.setTranslateY(res.FRAME_HEIGHT * 2 / 3);
			btn_OK.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.btn_OK_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
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
					if (controller.getLastPlayer().getCurrentLevel() < res.numOfLevel + 1) {
						controller.loadGame(controller.getLastPlayer()
								.getCurrentLevel());
					} else {
						controller.loadScoresUI();
					}
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
					e.consume();
				}
			});

			root.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					if (e.getCode() == KeyCode.ENTER) {
						if (controller.getLastPlayer().getCurrentLevel() < res.numOfLevel + 1) {
							controller.loadGame(controller.getLastPlayer()
									.getCurrentLevel());
						} else {
							controller.loadScoresUI();
						}
						if(controller.isSoundFXPlaying())
							res.mouseClickedFXmediaPlayer.play();
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
