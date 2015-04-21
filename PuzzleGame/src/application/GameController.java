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
	private MainUI mainUI;
	private LevelUI levelUI;
	private ScoresListUI scoresUI;
	private AboutUSUI aboutUSUI;
	private GamePanelUI gamePanelUI;
	private ExitUI exitUI;
	private NewPlayerUI newPlayerUI;
	private CompletedGameUI completedGameUI;
	private Resourses res = Main.res;
	private Group root;
	private ShapesManger shapesManger;
	private ArrayList<Piece> polygons, maps;
	private Label timerLabel;
	private Group gameBoard;

	ArrayList<Player> players;
	Player player;
	GameTimer timer;

	public GameController(Group root) throws Exception {
		this.root = root;
		players = new ArrayList<Player>();		
	}
	
	/**
	 * Initialed the main UI
	 * Load MainUI into scene
	 * Display 
	 */
	public void loadMainUI() {
		mainUI = new MainUI(this);
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
		levelUI = new LevelUI(this);
		levelUI.unlock(getLastPlayer().getHighestLevel());
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, levelUI.getLevelUI());
	}

	/**
	 * remove previous object in the scene
	 * Load the ScoresUI into scene
	 */
	public void loadScoresUI() {
		scoresUI = new ScoresListUI(this, players);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, scoresUI.getScoresUI());
	}
	
	/**
	 * remove previous object in the scene
	 * Load the ScoresUI into scene
	 */
	public void loadAboutUI() {
		aboutUSUI = new AboutUSUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, aboutUSUI.getAboutUSUI());
	}
	
	/**
	 * Initialed the new Player UI
	 * Load MainUI into scene
	 * Display 
	 */
	public void loadNewPlayerUI() {
		newPlayerUI = new NewPlayerUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, newPlayerUI.getNewPlayerUI());
	}


	/**
	 * remove previous object in the scene
	 * Load the ExitUI into scene
	 */
	public void loadExitUI() {
		exitUI = new ExitUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, exitUI.getExitUI());
	}
	
	/**
	 * remove previous object in the scene
	 * Load the ScoresUI into scene
	 */
	public void loadCompletedGameUI() {
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, completedGameUI.getCompletedGameUI());
	}
	
	/**
	 * remove previous object in the scene
	 * Load the GameUI with para, then load is into scene
	 * 
	 * @param level_num
	 * 
	 * initial a new timer and a new gameboard
	 */
	public void loadGame(int current_level_num) {
		gamePanelUI = new GamePanelUI(this);
		levelUI.unlock(getLastPlayer().getHighestLevel());
		root.getChildren().clear();
		shapesManger = new ShapesManger(this, current_level_num);

		// Set Timer
		timer = new GameTimer(res.countdown);
		timerLabel = timer.getTimerLabel();
		timerLabel.setTranslateX(50);
		timerLabel.setTranslateY(40);
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
		if (getLastPlayer().getCurrentLevel() > 2){
			loadGame(getLastPlayer().getCurrentLevel() - 1);
			getLastPlayer().setCurrentLevel(getLastPlayer().getCurrentLevel() - 1);
		}
		if (res.debug)
			System.out.println(getLastPlayer());
			
	}

	/**
	 * go to previous level
	 * 
	 */
	public void nextLevel() {
		if (getLastPlayer().getCurrentLevel() < getLastPlayer().getHighestLevel() && getLastPlayer().getCurrentLevel() < 20){
			loadGame(getLastPlayer().getCurrentLevel() + 1);
			getLastPlayer().setCurrentLevel(getLastPlayer().getCurrentLevel() + 1);
		}
		if (res.debug)
			System.out.println(getLastPlayer());
	}

	/**
	 * Check is completed
	 * 
	 */
	public void completed() {
		timer.stopTimer();
		System.out.println(timer.getCountDown());
		if (timer.getCountDown() > 0){
			getLastPlayer().setScore(timer.getCountDown());
			getLastPlayer().setCurrentLevel(getLastPlayer().getCurrentLevel() + 1);
			if (getLastPlayer().getCurrentLevel() >= getLastPlayer().getHighestLevel()){
				getLastPlayer().setHighestLevel(getLastPlayer().getCurrentLevel());
			}
			
		}
		completedGameUI = new CompletedGameUI(this,getLastPlayer());
		loadCompletedGameUI();
		if (res.debug)
			System.out.println(getLastPlayer());
	}


	/**
	 * Returns a list of player info
	 * 
	 * @return list
	 */
	public Player getLastPlayer(){
		if (players.size() > 0)
			player = players.get((players.size() - 1));
		return player;
	}
	
	/**
	 * Add a player to the list
	 * 
	 */
	public void setNewPlayer(String name){
		Player player = new Player(name);
		players.add(player);
	}

}
