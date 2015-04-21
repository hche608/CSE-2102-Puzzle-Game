/**
 * This is a interface of Main Panel
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
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainUI {
	Resourses res = Main.res;
	Group root;

	public MainUI(GameController controller) {
		root = new Group();
		try {

			Text title = new Text("Tangram Puzzle");

			title.setFont(res.minecrafter_font_title);
			title.setTranslateX(160);
			title.setTranslateY(175);
			title.setFill(Color.BLACK);
			// start btn

			final Button btn_Start = new Button();
			btn_Start.setGraphic(res.mainUI_start_Image);
			btn_Start.setBorder(null);
			btn_Start.setBackground(null);
			btn_Start.setCursor(Cursor.HAND);
			btn_Start.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Start.setGraphic(res.mainUI_start_Image1);
					res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_Start.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Start.setGraphic(res.mainUI_start_Image);

				}
			});

			btn_Start.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					// controller.loadLevelUI();
					controller.loadNewPlayerUI();
					res.mouseClickedFXmediaPlayer.play();
				}
			});

			// scores btn
			final Button btn_Scores = new Button();
			btn_Scores.setBorder(null);
			btn_Scores.setBackground(null);
			btn_Scores.setGraphic(res.mainUI_scores_Image);
			btn_Scores.setCursor(Cursor.HAND);
			btn_Scores.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Scores.setGraphic(res.mainUI_scores_Image1);
					res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_Scores.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Scores.setGraphic(res.mainUI_scores_Image);
				}
			});

			btn_Scores.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadScoresUI();
					res.mouseClickedFXmediaPlayer.play();
				}
			});

			// about btn
			final Button btn_About = new Button();
			btn_About.setGraphic(res.mainUI_about_Image);
			btn_About.setBorder(null);
			btn_About.setBackground(null);
			btn_About.setCursor(Cursor.HAND);
			btn_About.setMinSize(res.BTN_MINWIDTH, res.BTN_MINHEIGHT);
			btn_About.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_About.setGraphic(res.mainUI_about_Image1);
					res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_About.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_About.setGraphic(res.mainUI_about_Image);

				}
			});
			btn_About.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadAboutUI();
					res.mouseClickedFXmediaPlayer.play();
				}
			});

			// exit btn
			final Button btn_Exit = new Button();
			btn_Exit.setGraphic(res.mainUI_exit_Image);
			btn_Exit.setBorder(null);
			btn_Exit.setBackground(null);
			btn_Exit.setCursor(Cursor.HAND);
			btn_Exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Exit.setGraphic(res.mainUI_exit_Image1);
					res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_Exit.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Exit.setGraphic(res.mainUI_exit_Image);

				}
			});
			btn_Exit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadExitUI();
					res.mouseClickedFXmediaPlayer.play();
				}
			});

			final VBox btns = new VBox(btn_Start, btn_Scores, btn_About,
					btn_Exit);
			// btns.alignmentProperty();
			btns.setAlignment(Pos.CENTER);
			btns.setTranslateX((res.FRAME_WIDTH - res.BTNS_WIDTH) / 2);
			btns.setTranslateY((res.FRAME_HEIGHT - res.BTNS_HEIGHT) * 3 / 5);

			root.getChildren().addAll(title, btns);

		} catch (Exception e) {
			System.out.println("Initial Main UI error: " + e);
		}
	}

	public Group getMainUI() {
		return root;
	}

}
