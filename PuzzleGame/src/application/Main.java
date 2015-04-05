package application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	static Resourses res = new Resourses();
	GameController controller = new GameController();
	static MainUI mainUI;
	static LevelUI levelUI;
	static ScoresListUI scoresUI;
	static GamePanelUI gamePanelUI;
			
	@Override
	public void start(Stage primaryStage) {		
		//initial all UIs
		mainUI = new MainUI(primaryStage,res);	
		levelUI = new LevelUI(primaryStage,res);
		scoresUI = new ScoresListUI(primaryStage,res);
		gamePanelUI = new GamePanelUI(primaryStage,res);	
		
		// test Main UI			
		mainUI.show();
		
		//Level UI
		//levelUI.show();
		
		// test Scores UI				
		//scores.show();
		
		// test Game Panel UI 		
		//gamePanelUI.show();
		
	}
			
	public static void main(String[] args) {
		launch(args);
	}
}
