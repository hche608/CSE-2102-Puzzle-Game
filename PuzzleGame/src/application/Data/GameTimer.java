/**
 * This is a Timer
 * this class is controlled by GameController
 * 
 * 
 * @author hche608
 * 
 */
package application.Data;

import application.Main;
import application.Resourses;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GameTimer {
	private Timeline timeline;
	private Label timerLabel;
	private Resourses res = Main.res;
	private IntegerProperty timeSeconds;

	public GameTimer(int countdown) {
		setTimerLabel(new Label());
		timeSeconds = new SimpleIntegerProperty(countdown);
		timeSeconds.set(countdown);
		timeline = new Timeline();
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(countdown + 1), new KeyValue(
						timeSeconds, 0)));

		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setTextFill(Color.RED);
		timerLabel.setFont(res.minecrafter_font_label);

	}

	public int getCountDown() {
		return timeSeconds.getValue();
	}

	public Label getTimerLabel() {
		return timerLabel;
	}

	public void pauseORresumeTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.pause();
		} else {
			timeline.play();
		}
	}

	public void playTimer() {
		if (timeline.getStatus() != Status.RUNNING)
			timeline.play();
	}

	public void setCountDown(int v) {
		timeSeconds.setValue(v);
	}

	public void setTimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void stopTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.stop();
		}
	}
	
	public Status getStatus(){
		return timeline.getStatus();
	}

}
