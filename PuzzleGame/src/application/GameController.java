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

	ArrayList<Player> players = new ArrayList<Player>();

	GameTimer timer;

	public GameController(Group root) throws Exception {
		this.root = root;
		mainUI = new MainUI(this);
		levelUI = new LevelUI(this);
		scoresUI = new ScoresListUI(this);
		gamePanelUI = new GamePanelUI(this);
		// shapesManger = new ShapesManger(this);

	}

	public void loadInitial() {
		loadMainUI();
	}

	public void loadMainUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, mainUI.getMainUI());
	}

	public void loadLevelUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, levelUI.getLevelUI());
	}

	public void loadScoresUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, scoresUI.getScoresUI());
	}

	public void loadGamePanelUI() {
		root.getChildren().clear();

		timerLabel = timer.getTimerLabel();
		timerLabel.setLayoutX(100);
		timerLabel.setLayoutY(res.FRAME_HEIGHT - 50);
		root.getChildren().addAll(res.background_Image,
				gamePanelUI.getGamePanelUI(), timerLabel);
	}

	public void loadGame(int level_num) {
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

	public void playTimer() {
		timer.playTimer();
	}

	public void pauseORresumeTimer() {
		timer.pauseORresumeTimer();
	}

	public void setCountDown(int countdown) {
		timer.setCountDown(countdown);
	}

	public void updatePieces() {

	}

	public void redo() {

	}

	public void undo() {

	}

	public void completed() {
		timer.stopTimer();

		System.out.println(timer.getCountDown());
	}

	public void reset() {
		timer = new GameTimer(res.countdown);
		shapesManger = new ShapesManger(this, 1);
	}

	/*
	 *  
	 */
	public String[] showList() {

		return null;

	}

}
