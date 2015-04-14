package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class GameController {
	public MainUI mainUI;
	public LevelUI levelUI;
	public ScoresListUI scoresUI;
	public GamePanelUI gamePanelUI;
	Resourses res = Main.res;
	Group root;
	Shapes shapes;
	ArrayList<Polygon> polygons;
	Label timerLabel;
	
	ArrayList<Player> players = new ArrayList<Player>();


	Timer timer;

	public GameController(Group root) throws Exception {
		this.root = root;
		mainUI = new MainUI(this);
		levelUI = new LevelUI(this);
		scoresUI = new ScoresListUI(this);
		gamePanelUI = new GamePanelUI(this);
		timer = new Timer(this);
		shapes = new Shapes(this);
				
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
		root.getChildren().addAll(res.background_Image,gamePanelUI.getGamePanelUI(),timerLabel);
	}

	public void loadGame(int level_num) {
		root.getChildren().clear();	
		
		//Set Timer
		timerLabel = timer.getTimerLabel();
		timerLabel.setLayoutX(100);
		timerLabel.setLayoutY(res.FRAME_HEIGHT - 50);
		
		Group gameBoard = new Group();
		try {
			
			polygons = new ArrayList<Polygon>();
			polygons = shapes.getCube();
			gameBoard.getChildren().addAll(polygons);
		} catch (Exception e) {
			System.out.println("Initial game board error: " + e);
		}
		root.getChildren().addAll(res.background_Image,
				gamePanelUI.getGamePanelUI(),timerLabel);
		if (gameBoard != null)
			root.getChildren().add(gameBoard);

	}
	
	public void playTimer() {
		timer.playTimer();
	}

	public void updatePieces() {
		root.getChildren().remove(1);
		
	}
	
	public void redo() {

	}

	public void undo() {

	}

	public void completed() {

	}

	/*
	 *  
	 */
	public String[] showList() {

		return null;

	}



}
