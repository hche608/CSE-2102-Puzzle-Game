/**
 * This is a interface of Exit Game
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ExitUI {
	Resourses res = Main.res;
	Group root;

	public ExitUI(GameController controller) {
		root = new Group();
		try {
			Text title = new Text("Exit Game?");

			title.setFont(res.minecrafter_font_title);
			title.setTranslateX(160);
			title.setTranslateY(175);
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
				}
			});

			HBox btns = new HBox(btn_OK, btn_Cancel);
			btns.setTranslateX((res.FRAME_WIDTH - res.BTNS_WIDTH * 2 - 20.0) / 2);
			btns.setTranslateY((res.FRAME_HEIGHT - res.BTNS_HEIGHT) / 10 * 7);

			root.getChildren().addAll(title, btns);
		} catch (Exception e) {
			System.out.println("Initial Exit UI error: " + e);
		}
	}

	public Group getExitUI() {
		return root;
	}

}
