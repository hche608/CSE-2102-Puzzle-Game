package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	Resourses res = new Resourses();
	GameController controller = new GameController(res);
	static MainUI mainUI;
	static LevelUI levelUI;
	static ScoresListUI scoresUI;
	static GamePanelUI gamePanelUI;

	@Override
	public void start(Stage primaryStage) {
		// initial all UIs
		mainUI = new MainUI(primaryStage, res);
		levelUI = new LevelUI(primaryStage, res);
		scoresUI = new ScoresListUI(primaryStage, res);
		gamePanelUI = new GamePanelUI(primaryStage, res, controller);

		// test Main UI
		mainUI.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
