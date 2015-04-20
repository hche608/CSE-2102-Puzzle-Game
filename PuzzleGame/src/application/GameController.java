	/**
	 * This is a Game Controller class
	 * this class controls all UIs and interactions with UIs' buttons
	 * 
	 * @author hche608
	 * 
	 */
package application;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class GameController {
	public MainUI mainUI;
	public LevelUI levelUI;
	public ScoresListUI scoresUI;
	public GamePanelUI gamePanelUI;
	Resourses res = Main.res;
	Group root;
	ShapesManger shapesManger;
	ArrayList<Piece> polygons, maps;
	Label timerLabel;
	Group gameBoard;
	int level_num = 1;

	ArrayList<Player> players = new ArrayList<Player>();

	GameTimer timer;

	public GameController(Group root) throws Exception {
		this.root = root;
		mainUI = new MainUI(this);
		levelUI = new LevelUI(this);
		scoresUI = new ScoresListUI(this);
		gamePanelUI = new GamePanelUI(this);
	}
	
	/**
	 * Initialed the main UI
	 * Load MainUI into scene
	 * Display 
	 */
	public void loadMainUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, mainUI.getMainUI());
	}

	/**
	 * remove previous object in the scene
	 * Load the LevelUI into scene
	 * unlock initial level 1
	 * 
	 */
	public void loadLevelUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, levelUI.getLevelUI());
		levelUI.unlock(1);
	}

	/**
	 * remove previous object in the scene
	 * Load the ScoresUI into scene
	 */
	public void loadScoresUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, scoresUI.getScoresUI());
	}

	/**
	 * remove previous object in the scene
	 * Load the GameUI with para, then laod is into scene
	 * 
	 * @param level_num
	 * 
	 * initial a new timer and a new gameboard
	 */
	public void loadGame(int level_num) {
		this.level_num = level_num;
		levelUI.unlock(level_num);
		root.getChildren().clear();
		shapesManger = new ShapesManger(this, level_num);

		// Set Timer
		timer = new GameTimer(res.countdown);
		timerLabel = timer.getTimerLabel();
		timerLabel.setLayoutX(100);
		timerLabel.setLayoutY(res.FRAME_HEIGHT - 50);
		gameBoard = new Group();
		try {

			polygons = new ArrayList<Piece>();
			polygons = shapesManger.getCube();
			maps = new ArrayList<Piece>();
			maps = shapesManger.getMaps();
			gameBoard.getChildren().addAll(polygons);
			gameBoard.getChildren().addAll(maps);
		} catch (Exception e) {
			System.out.println("Initial game board error: " + e);
		}
		root.getChildren().addAll(res.background_Image,
				gamePanelUI.getGamePanelUI(), timerLabel);
		if (gameBoard != null)
			root.getChildren().add(gameBoard);
	}

	/**
	 * Start timer
	 * 
	 */
	public void playTimer() {
		timer.playTimer();
	}

	/**
	 * Pause or Resume the timer
	 */
	public void pauseORresumeTimer() {
		timer.pauseORresumeTimer();
	}

	/**
	 * Set timer with
	 * @param countdown
	 * 
	 */
	public void setCountDown(int countdown) {
		timer.setCountDown(countdown);
	}

	/**
	 * go to next level
	 * 
	 */
	public void previousLevel() {
		if (level_num > 2)
			loadGame(level_num - 1);
	}

	/**
	 * go to previous level
	 * 
	 */
	public void nextLevel() {
		if (level_num < 20)
			loadGame(level_num + 1);
	}

	/**
	 * Check is completed
	 * 
	 */
	public void completed() {
		timer.stopTimer();

		System.out.println(timer.getCountDown());
	}

	/**
	 * Reset UI
	 * 
	 */
	public void reset() {
		timer = new GameTimer(res.countdown);
		shapesManger = new ShapesManger(this, 1);
	}


	/**
	 * Returns a list of player info
	 * 
	 * @return list
	 */
	public String[] showList() {

		return null;

	}

}
