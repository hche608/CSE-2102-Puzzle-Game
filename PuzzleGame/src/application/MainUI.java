package application;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
			title.setLayoutX(160);
			title.setLayoutY(70);
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
					controller.loadGamePanelUI();
				}
			});

			// level select btn
			final Button btn_Level = new Button();
			btn_Level.setGraphic(res.mainUI_level_Image);
			btn_Level.setBorder(null);
			btn_Level.setBackground(null);
			btn_Level.setCursor(Cursor.HAND);
			btn_Level.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Level.setGraphic(res.mainUI_level_Image1);

				}
			});
			btn_Level.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_Level.setGraphic(res.mainUI_level_Image);

				}
			});

			btn_Level.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadLevelUI();
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
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Look, a Confirmation Dialog");
					alert.setContentText("Are you ok with this?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						// ... user chose OK
						Platform.exit();
					} else {
						// ... user chose CANCEL or closed the dialog
					}
				}
			});

			final VBox btns = new VBox(btn_Start, btn_Level, btn_Scores,
					btn_Exit);
			// btns.alignmentProperty();
			btns.setAlignment(Pos.CENTER);
			btns.setLayoutX((res.FRAME_WIDTH - res.BTNS_WIDTH) / 2);
			btns.setLayoutY((res.FRAME_HEIGHT - res.BTNS_HEIGHT) / 2);

			root.getChildren().addAll(title, btns);

		} catch (Exception e) {
			System.out.println("Initial Main UI error: " + e);
		}
	}

	public Group getMainUI() {
		return root;
	}

}
