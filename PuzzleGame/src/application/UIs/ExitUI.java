/**
 * This is a interface of Exit Game
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ExitUI {
	private Resourses res = Main.res;
	private Group root;

	public ExitUI(GameController controller) {
		root = new Group();
		try {
			Text title = new Text("Exit Game?");

			title.setFont(res.minecrafter_font_title);
			title.setTranslateX(res.FRAME_WIDTH * 3 / 10);
			title.setTranslateY(res.FRAME_HEIGHT * 4 / 10);
			title.setFill(Color.BLACK);

			// OK btn
			final Button btn_OK = new Button();
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setGraphic(res.btn_OK_Image);
			btn_OK.setCursor(Cursor.HAND);
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
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
					System.exit(0);
				}
			});

			// Cancel btn
			final Button btn_Cancel = new Button();
			btn_Cancel.setBorder(null);
			btn_Cancel.setBackground(null);
			btn_Cancel.setGraphic(res.btn_CANCEL_Image);
			btn_Cancel.setCursor(Cursor.HAND);
			btn_Cancel.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Cancel.setGraphic(res.btn_CANCEL_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_Cancel.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Cancel.setGraphic(res.btn_CANCEL_Image);
				}
			});

			btn_Cancel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadMainUI();
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
				}
			});

			HBox btns = new HBox(btn_OK, btn_Cancel);
			btns.setTranslateX((res.FRAME_WIDTH - res.BTNS_WIDTH * 2 - 20.0) / 2);
			btns.setTranslateY(res.FRAME_HEIGHT * 6 / 10);

			root.getChildren().addAll(title, btns);
		} catch (Exception e) {
			System.out.println("Initial Exit UI error: " + e);
		}
	}

	public Group getExitUI() {
		return root;
	}

}
