package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Timer {
	private Timeline timeline;
	private Label timerLabel;

	public Timer(Resourses res) {
		setTimerLabel(new Label());
		IntegerProperty timeSeconds = new SimpleIntegerProperty(res.countdown);
		timeSeconds.set(res.countdown);
		timeline = new Timeline();
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(res.countdown + 1), new KeyValue(
						timeSeconds, 0)));

		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setTextFill(Color.RED);
		timerLabel.setFont(res.minecrafter_font_label);

	}

	public Label getTimerLabel() {
		return timerLabel;
	}

	public void playTimer() {
		if (timeline.getStatus() != Status.RUNNING)
			timeline.play();
	}

	public void pauseORresumeTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.pause();
		} else {
			timeline.play();
		}

	}

	public void setTimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

}
