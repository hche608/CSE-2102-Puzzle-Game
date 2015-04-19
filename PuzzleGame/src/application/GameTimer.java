package application;

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
	Resourses res = Main.res;
	int countdown;
	IntegerProperty timeSeconds;

	public GameTimer(int countdown) {
		this.countdown = countdown;
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

	public Label getTimerLabel() {
		return timerLabel;
	}

	public void playTimer() {
		if (timeline.getStatus() != Status.RUNNING
				&& timeline.getStatus() != Status.STOPPED)
			timeline.play();
	}

	public void pauseORresumeTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.pause();
		} else {
			timeline.play();
		}
	}

	public void stopTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.stop();
		}
	}

	public void setCountDown(int v) {
		timeSeconds.setValue(v);
	}

	public int getCountDown() {
		return timeSeconds.getValue();
	}

	public void setTimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

}
