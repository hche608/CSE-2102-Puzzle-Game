/**
 * This is a interface of input a new player
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class NewPlayerUI {
	Resourses res = Main.res;
	Group root;

	public NewPlayerUI(GameController controller) {
		root = new Group();
		HBox hb = new HBox();
		try {
			Text label1 = new Text("Player Name:");
			label1.setFont(res.minecrafter_font_label);
			TextField textField = new TextField();
			textField.setFont(res.minecrafter_font_label);
			textField.setBackground(null);

			final Button btn_OK = new Button();
			btn_OK.setGraphic(res.btn_OK_Image);
			btn_OK.setBorder(null);
			btn_OK.setBackground(null);
			btn_OK.setCursor(Cursor.HAND);
			btn_OK.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_OK.setGraphic(res.btn_OK_Image1);
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
					// controller.loadLevelUI();
					controller.setNewPlayer(textField.getText());
					textField.clear();
					controller.loadLevelUI();
					res.mouseClickedFXmediaPlayer.play();
				}
			});

			textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					res.mouseClickedFXmediaPlayer.play();
					if (e.getCode() == KeyCode.ENTER) {
						System.out.println("Enter Released!");
						controller.setNewPlayer(textField.getText());
						textField.clear();
						controller.loadLevelUI();
						if (res.debug)
							System.out.println(controller.getLastPlayer());
						e.consume();
					}

				}
			});

			hb.getChildren().addAll(label1, textField, btn_OK);
			hb.setSpacing(10);

		} catch (Exception e) {
			System.out.println("Initial New Player UI error: " + e);
		}
		root.getChildren().add(hb);
	}

	public Group getNewPlayerUI() {
		return root;
	}

}
