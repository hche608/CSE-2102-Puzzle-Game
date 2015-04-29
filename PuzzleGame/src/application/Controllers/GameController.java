/**
 * This is a Game Controller class
 * this class controls all UIs and interactions with UIs' buttons
 * 
 * @author hche608
 * 
 */
package application.Controllers;

import java.util.ArrayList;

import application.Main;
import application.Resourses;
import application.Data.GameTimer;
import application.Data.Level;
import application.Data.LevelLoader;
import application.Data.Piece;
import application.Data.Player;
import application.UIs.AboutUSUI;
import application.UIs.CompletedGameUI;
import application.UIs.ExitUI;
import application.UIs.GamePanelUI;
import application.UIs.LevelUI;
import application.UIs.MainUI;
import application.UIs.NewPlayerUI;
import application.UIs.ScoresListUI;
import javafx.animation.Animation.Status;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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
	private LevelLoader levelLoader = new LevelLoader("Nothing");

	private ArrayList<Level> levels;
	private ArrayList<Player> players;
	private Player player;
	private GameTimer timer;
	
	private boolean musicPlaying,soundFXPlaying;

	public GameController(Group root) throws Exception {
		this.root = root;
		this.setMusicPlaying(true);
		this.setSoundFXPlaying(true);
		
		players = new ArrayList<Player>();
		try {
			setLevels(levelLoader.getLevels());
		} catch (Exception e){
			System.out.println("Load levels error: " + e);
		}
	}

	/**
	 * Check is completed
	 * 
	 */
	public void completed() {
		timer.stopTimer();
		//root.getChildren().clear();
		if (res.debug)
			System.out.println("Time remainder:" + getCountDown());
		if (timer.getCountDown() > 0) {
			getLastPlayer().setScore(getCountDown());
			if (getLastPlayer().getCurrentLevel() < res.numOfLevel + 1) {
				getLastPlayer().setCurrentLevel(
						getLastPlayer().getCurrentLevel() + 1);
				if (getLastPlayer().getCurrentLevel() >= getLastPlayer()
						.getHighestLevel()) {
					getLastPlayer().setHighestLevel(
							getLastPlayer().getCurrentLevel());
				}
				if (getLastPlayer().getCurrentLevel() > res.numOfLevel) {
					getLastPlayer().setHighestLevel(res.numOfLevel);
				}
			}
		}	
		
		res.completedFXmediaPlayer.play();		
		loadCompletedGameUI();		
		if (res.debug)
			System.out.println(getLastPlayer());
	}

	/**
	 * Returns a list of player info
	 * 
	 * @return list
	 */
	public Player getLastPlayer() {
		if (players.size() > 0)
			player = players.get((players.size() - 1));
		return player;
	}

	/**
	 * remove previous object in the scene Load the ScoresUI into scene
	 */
	public void loadAboutUI() {
		aboutUSUI = new AboutUSUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image,
				aboutUSUI.getAboutUSUI());
	}

	/**
	 * remove previous object in the scene Load the ScoresUI into scene
	 */
	public void loadCompletedGameUI() {
		completedGameUI = new CompletedGameUI(this, getLastPlayer());
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image,
				completedGameUI.getCompletedGameUI());
	}

	/**
	 * remove previous object in the scene Load the ExitUI into scene
	 */
	public void loadExitUI() {
		exitUI = new ExitUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, exitUI.getExitUI());
	}

	/**
	 * remove previous object in the scene Load the GameUI with para, then load
	 * is into scene
	 * 
	 * @param level_num
	 * 
	 *            initial a new timer and a new gameboard
	 */
	public void loadGame(int current_level_num) {
		Level level = getLevels().get((current_level_num - 1));
		
		levelUI.unlock(getLastPlayer().getHighestLevel());
		root.getChildren().clear();
		shapesManger = new ShapesManger(this, level);

		// name label
		Text level_name = new Text(level.getName());
		level_name.setFont(res.minecrafter_font_label);
		level_name.setFill(Color.BLACK);
		level_name.setTranslateX(300);
		level_name.setTranslateY(100);
		// Set Timer
		timer = new GameTimer(level.getTime());
		timerLabel = timer.getTimerLabel();
		timerLabel.setTranslateX(50);
		timerLabel.setTranslateY(40);
		
		
		gamePanelUI = new GamePanelUI(this);
		
		
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
				gamePanelUI.getGamePanelUI(), timerLabel, level_name);
		if (gameBoard != null)
			root.getChildren().add(gameBoard);
	}

	/**
	 * remove previous object in the scene Load the LevelUI into scene unlock
	 * initial level 1
	 * 
	 */
	public void loadLevelUI() {
		levelUI = new LevelUI(this);
		levelUI.unlock(getLastPlayer().getHighestLevel());
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, levelUI.getLevelUI());
	}

	/**
	 * Initialed the main UI Load MainUI into scene Display
	 */
	public void loadMainUI() {
		mainUI = new MainUI(this);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, mainUI.getMainUI());
	}

	/**
	 * Initialed the new Player UI Load MainUI into scene Display
	 */
	public void loadNewPlayerUI() {
		newPlayerUI = new NewPlayerUI(this);
		// only stores 5 players info
		while (players.size() >= 5){
			players.remove(0);
		}
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image,
				newPlayerUI.getNewPlayerUI());
	}

	/**
	 * remove previous object in the scene Load the ScoresUI into scene
	 */
	public void loadScoresUI() {
		scoresUI = new ScoresListUI(this, players);
		root.getChildren().clear();
		root.getChildren().addAll(res.background_Image, scoresUI.getScoresUI());
	}

	/**
	 * go to previous level
	 * 
	 */
	public void nextLevel() {
		if (getLastPlayer().getCurrentLevel() < getLastPlayer()
				.getHighestLevel()
				&& getLastPlayer().getCurrentLevel() < res.numOfLevel) {
			loadGame(getLastPlayer().getCurrentLevel() + 1);
			getLastPlayer().setCurrentLevel(
					getLastPlayer().getCurrentLevel() + 1);
		}
		if (res.debug)
			System.out.println(getLastPlayer());
	}

	/**
	 * Pause or Resume the timer
	 */
	public void pauseORresumeTimer() {
		timer.pauseORresumeTimer();
	}

	/**
	 * Start timer
	 * 
	 */
	public void playTimer() {
		timer.playTimer();
	}

	/**
	 * go to next level
	 * 
	 */
	public void previousLevel() {
		if (getLastPlayer().getCurrentLevel() >= 2) {
			loadGame(getLastPlayer().getCurrentLevel() - 1);
			getLastPlayer().setCurrentLevel(
					getLastPlayer().getCurrentLevel() - 1);
		}
		if (res.debug)
			System.out.println(getLastPlayer());

	}

	/**
	 * Set timer with
	 * 
	 * @param countdown
	 * 
	 */
	public void setCountDown(int countdown) {
		timer.setCountDown(countdown);
	}
	
	public int getCountDown(){
		return timer.getCountDown();
	}
	
	public Status getCountDownStatus(){
		return timer.getStatus();
	}
	
	/**
	 * Add a player to the list
	 * 
	 */
	public void setNewPlayer(String name) {
		Player player = new Player(name);
		if (res.debug){
			player.setHighestLevel(res.numOfLevel);
			System.out.println(player);
		}
			
		
		players.add(player);
	}

	public LevelLoader getLevelLoader() {
		return levelLoader;
	}

	public void setLevelLoader(LevelLoader levelLoader) {
		this.levelLoader = levelLoader;
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}

	/**
	 * @return the music
	 */
	public boolean isMusicPlaying() {
		return musicPlaying;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusicPlaying(boolean musicPlaying) {
		this.musicPlaying = musicPlaying;
	}

	/**
	 * @return the soundFX
	 */
	public boolean isSoundFXPlaying() {
		return soundFXPlaying;
	}

	/**
	 * @param soundFX the soundFX to set
	 */
	public void setSoundFXPlaying(boolean soundFXPlaying) {
		this.soundFXPlaying = soundFXPlaying;
	}

}
