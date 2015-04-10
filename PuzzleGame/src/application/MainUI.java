package application;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI {
	Resourses res;
	Stage primaryStage;
	boolean disable;

	public MainUI(Stage primaryStage, Resourses res) {
		this.res = res;
		this.primaryStage = primaryStage;
		disable = false;
	}

	public void show() {
		try {

			final Group background = new Group(res.mainUI_background_Image);

			// start btn
			final Button btn = new Button();
			btn.setGraphic(res.mainUI_start_Image);
			btn.setBorder(null);
			btn.setBackground(null);
			btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn.setGraphic(res.mainUI_start_Image1);
				}
			});
			btn.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn.setGraphic(res.mainUI_start_Image);

				}
			});

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Main.gamePanelUI.show();

				}
			});

			// level select btn
			final Button btn1 = new Button();
			btn1.setGraphic(res.mainUI_level_Image);
			btn1.setBorder(null);
			btn1.setBackground(null);
			btn1.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn1.setGraphic(res.mainUI_level_Image1);

				}
			});
			btn1.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn1.setGraphic(res.mainUI_level_Image);

				}
			});

			btn1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Main.levelUI.show();
				}
			});

			// scores btn

			final Button btn2 = new Button();
			btn2.setBorder(null);
			btn2.setBackground(null);
			btn2.setGraphic(res.mainUI_scores_Image);

			btn2.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn2.setGraphic(res.mainUI_scores_Image1);
				}
			});
			btn2.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn2.setGraphic(res.mainUI_scores_Image);
				}
			});

			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Main.scoresUI.show();
				}
			});

			// exit btn

			final Button btn3 = new Button();
			btn3.setGraphic(res.mainUI_exit_Image);
			btn3.setBorder(null);
			btn3.setBackground(null);
			btn3.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn3.setGraphic(res.mainUI_exit_Image1);

				}
			});
			btn3.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn3.setGraphic(res.mainUI_exit_Image);

				}
			});
			btn3.setOnAction(new EventHandler<ActionEvent>() {
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

			final VBox btns = new VBox(btn, btn1, btn2, btn3);
			btns.alignmentProperty();
			btns.setAlignment(Pos.CENTER);
			btns.setLayoutX((res.FRAME_WIDTH - res.BTNS_WIDTH) / 2);
			btns.setLayoutY((res.FRAME_HEIGHT - res.BTNS_HEIGHT) / 2);

			final Group root = new Group(background, btns);
			Scene scene = new Scene(root, res.FRAME_WIDTH, res.FRAME_HEIGHT);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Tangram Game");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
