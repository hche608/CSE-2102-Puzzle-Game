package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class GameController {
	ArrayList<Player> players = new ArrayList<Player>();
	Resourses res;
	Shapes shapes;
	Label timerLabel;
	Timer timer;

	public GameController(Resourses res) {
		this.res = res;
		shapes = new Shapes(res);
		timer = new Timer(res);
	}

	public void newGame() {
		loadGame(1);
	}

	public void loadGame(int level_num) {

	}

	public Group loadCube() {
		return shapes.generateCbue();
	}

	public void redo() {

	}

	public void undo() {

	}

	public void completed() {

	}

	public Label getTimerLabel() {
		return timer.getTimerLabel();
	}

	/*
	 *  
	 */
	public String[] showList() {

		return null;

	}

	public void update() {

	}

}
