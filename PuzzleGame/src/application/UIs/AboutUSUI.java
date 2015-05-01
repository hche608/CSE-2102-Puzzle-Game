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

public class AboutUSUI {
	private Resourses res = Main.res;
	private Group root;
	GameController controller;

	public AboutUSUI(GameController controller) {
		root = new Group();
		Text title = new Text();
		this.controller = controller;
		try {

			title.setText("About US!\n"
					+ "Composed by Hao Chen, \n"
					+ "Christian Kuntz, \n"
					+ "Erming Gao\n");

			title.setFont(res.minecrafter_font_label);
			title.setTranslateX(30);
			title.setTranslateY(60);
			title.setFill(Color.BLACK);

			final Button btn_OK = new Button();
			btn_OK.setGraphic(res.btn_OK_Image);
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setCursor(Cursor.HAND);
			btn_OK.setTranslateX(res.FRAME_WIDTH * 3 / 10);
			btn_OK.setTranslateY(res.FRAME_HEIGHT * 7 / 10);
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
					controller.loadMainUI();
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
						e.consume();
					}
				}
			});
			root.getChildren().addAll(title, btn_OK);

		} catch (Exception e) {
			System.out.println("Initial Player in About US UI error: " + e);
		}
	}

	public Group getAboutUSUI() {
		return root;
	}
}
