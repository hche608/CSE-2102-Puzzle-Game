/**
 * This is a interface of input a new player
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class NewPlayerUI {
	private Resourses res = Main.res;
	private Group root;

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
					// controller.loadLevelUI();
					controller.setNewPlayer(textField.getText());
					textField.clear();
					controller.loadLevelUI();
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
				}
			});

			final Button btn_lastPlayer = new Button();
			btn_lastPlayer.setGraphic(res.last_Player_Image);
			btn_lastPlayer.setBorder(null);
			btn_lastPlayer.setBackground(null);
			btn_lastPlayer.setCursor(Cursor.HAND);
			btn_lastPlayer.setTranslateX(res.FRAME_WIDTH * 3 / 10);
			btn_lastPlayer.setTranslateY(res.FRAME_HEIGHT * 2 / 3);
			btn_lastPlayer.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_lastPlayer.setGraphic(res.last_Player_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_lastPlayer.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_lastPlayer.setGraphic(res.last_Player_Image);

				}
			});
			btn_lastPlayer.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					// controller.loadLevelUI();
					controller.loadLevelUI();
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
				}
			});
			
			
			
			textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					if(controller.isSoundFXPlaying())
						res.mouseClickedFXmediaPlayer.play();
					if (e.getCode() == KeyCode.ENTER) {
						if (res.debug)
							System.out.println("Enter Released!");
						controller.setNewPlayer(textField.getText());
						textField.clear();
						controller.loadLevelUI();
						e.consume();
					}

				}
			});

			hb.getChildren().addAll(label1, textField);
			hb.setTranslateX(res.FRAME_WIDTH * 1 / 10);
			hb.setTranslateY(res.FRAME_HEIGHT * 1 / 10);
			hb.setSpacing(10);
			root.getChildren().addAll(hb,btn_OK);
			if (controller.getLastPlayer() != null){
				root.getChildren().add(btn_lastPlayer);
			}
		} catch (Exception e) {
			System.out.println("Initial New Player UI error: " + e);
		}
		
	}

	public Group getNewPlayerUI() {
		return root;
	}

}
