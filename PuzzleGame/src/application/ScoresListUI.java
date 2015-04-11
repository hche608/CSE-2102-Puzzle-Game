package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ScoresListUI {
	Resourses res;
	Stage previousStage;
	boolean mainStage;

	public ScoresListUI(Stage previousStage, Resourses res) {
		this.res = res;
		this.previousStage = previousStage;

	}

	public void show() {

		final Group background = new Group(res.background_Image);
		// final VBox scoresList = new VBox();
		final Button btn = new Button("Return Previous View");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Main.mainUI.show();
			}

		});
		// scoresList.getChildren().addAll(btn);
		final Group root = new Group(background, btn);
		Scene scene = new Scene(root, res.FRAME_WIDTH, res.FRAME_HEIGHT);
		previousStage.setResizable(false);
		previousStage.setTitle("Game Scores");
		previousStage.setScene(scene);
		previousStage.centerOnScreen();

		previousStage.show();

	}

}
