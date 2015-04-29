/**
 * This is a interface of Dialog
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

public class DialogUI {
	private Resourses res = Main.res;
	private Group root;
	GameController controller;

	public DialogUI(GameController controller) {
		root = new Group();
		Text title = new Text();
		this.controller = controller;

		try {
			title.setText("This is an empty dialog!\n");
			title.setFont(res.minecrafter_font_title);
			title.setTranslateX(160);
			title.setTranslateY(175);
			title.setFill(Color.BLACK);

			final Button btn_OK = new Button();
			btn_OK.setGraphic(res.mainUI_start_Image);
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setCursor(Cursor.HAND);
			btn_OK.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.mainUI_start_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_OK.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.mainUI_start_Image);
				}
			});
			btn_OK.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadGame(controller.getLastPlayer()
							.getCurrentLevel());
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
					e.consume();
				}
			});

			root.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					if (e.getCode() == KeyCode.ENTER) {
						controller.loadMainUI();
						if(controller.isSoundFXPlaying())
							res.mouseClickedFXmediaPlayer.play();
						e.consume();
					}
				}
			});
			root.getChildren().addAll(title, btn_OK);

		} catch (Exception e) {
			System.out.println("Initial Dialog UI error: " + e);
		}
	}

	public Group getCompletedGameUI() {
		return root;
	}
}
