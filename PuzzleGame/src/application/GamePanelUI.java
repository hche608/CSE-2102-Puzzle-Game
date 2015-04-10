package application;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePanelUI {
	Resourses res;
	Stage primaryStage;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	Polygon triangle_One_L, triangle_Two_L, triangle_One_M, triangle_One_S,
			triangle_Two_S, square_One_S, rhombus_One_S;

	Timeline timeline;
	int startTime = 50;
	private Label timerLabel;
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);

	public GamePanelUI(Stage primaryStage, Resourses res) {
		this.res = res;
		this.primaryStage = primaryStage;

		setTimerLabel(new Label());

		timeSeconds.set(startTime);
		timeline = new Timeline();
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(startTime + 1), new KeyValue(
						timeSeconds, 0)));

	}

	public void show() {

		final Group background = new Group(res.background_Image);

		final Button redo = new Button();
		redo.setGraphic(res.gamePanelUI_redo_Image);
		redo.setBorder(null);
		redo.setBackground(null);

		final Button flip = new Button();
		flip.setGraphic(res.gamePanelUI_flip_Image);
		flip.setBorder(null);
		flip.setBackground(null);

		final Button hbtn1 = new Button();
		hbtn1.setGraphic(res.gamePanelUI_counterclockwise_rotate_Image);
		hbtn1.setBorder(null);
		hbtn1.setBackground(null);

		final Button hbtn2 = new Button();
		hbtn2.setGraphic(res.gamePanelUI_clockwise_rotate_Image);
		hbtn2.setBorder(null);
		hbtn2.setBackground(null);

		final HBox hbtns = new HBox(hbtn1, hbtn2);
		final VBox topBTNs = new VBox(redo, flip, hbtns);
		topBTNs.alignmentProperty();
		topBTNs.setAlignment(Pos.CENTER);
		topBTNs.setLayoutX(50.0);
		topBTNs.setLayoutY(50.0);
		
		/*
		 * Bottom Line
		 */
		
		final Label counter = new Label("Time: ");
		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setTextFill(Color.RED);
		timerLabel.setStyle("-fx-font-size: 4em;");

		final Button btn_pre = new Button();
		//btn_pre.setText("Start Timer");
		btn_pre.setGraphic(res.gamePanelUI_previous_Image);
		btn_pre.setBorder(null);
		btn_pre.setBackground(null);
		btn_pre.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				if (timeline != null) {
					timeline.stop();
				}
				if (timeline.getStatus() == Status.PAUSED) {
					timeline.play();
				} else if (timeline.getStatus() == Status.RUNNING) {
					timeline.pause();
				}
				timeline.playFromStart();
			}
		});

		final Button btn_pause = new Button();
		//btn_pause.setText("Pause Timer");
		btn_pause.setGraphic(res.gamePanelUI_pause_Image);
		btn_pause.setBorder(null);
		btn_pause.setBackground(null);
		btn_pause.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				pauseORresumeTimer();

			}
		});
		
		final Button btn_next = new Button();
		btn_next.setGraphic(res.gamePanelUI_next_Image);
		btn_next.setBorder(null);
		btn_next.setBackground(null);
		btn_next.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

			}
		});

		final Button btn_mute = new Button();
		btn_mute.setGraphic(res.gamePanelUI_mute_Image);
		btn_mute.setBorder(null);
		btn_mute.setBackground(null);
		btn_mute.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
			}
		});
		final HBox lowBTNs = new HBox(counter, timerLabel, btn_pre, btn_pause, btn_next, btn_mute );
		//lowBTNs.setLayoutX(0.0);
		//lowBTNs.setLayoutY(res.FRAME_HEIGHT - 50);
		lowBTNs.setAlignment(Pos.BASELINE_RIGHT);
		/*
		 * RED TRIANGLE
		 */
		triangle_One_L = new Polygon();
		triangle_One_L.getPoints().addAll(
				new Double[] { 0.0, 0.0, 
						0.0, 150.0, 
						75.0, 75.0 });
		triangle_One_L.setFill(Color.RED);
		triangle_One_L.setStroke(Color.BLACK);
		triangle_One_L.setLayoutX(res.O_pointX);
		triangle_One_L.setLayoutY(res.O_pointY);
		triangle_One_L.setCursor(Cursor.HAND);
		triangle_One_L.setOnMousePressed(polygonOnMousePressedEventHandler);
		triangle_One_L.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * BLUE TRIANGLE
		 */
		triangle_Two_L = new Polygon();
		triangle_Two_L.getPoints().addAll(
				new Double[] { 0.0, 0.0, 
						150.0, 0.0, 
						75.0, 75.0 });
		triangle_Two_L.setFill(Color.BLUE);
		triangle_Two_L.setStroke(Color.BLACK);
		triangle_Two_L.setLayoutX(res.O_pointX);
		triangle_Two_L.setLayoutY(res.O_pointY);
		triangle_Two_L.setCursor(Cursor.HAND);
		triangle_Two_L.setOnMousePressed(polygonOnMousePressedEventHandler);
		triangle_Two_L.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * 
		 */
		triangle_One_M = new Polygon();
		triangle_One_M.getPoints().addAll(
				new Double[] { 75.0, 150.0, 
						150.0, 150.0, 
						150.0, 75.0 });
		triangle_One_M.setFill(Color.YELLOW);
		triangle_One_M.setStroke(Color.BLACK);
		triangle_One_M.setLayoutX(res.O_pointX);
		triangle_One_M.setLayoutY(res.O_pointY);
		triangle_One_M.setCursor(Cursor.HAND);
		triangle_One_M.setOnMousePressed(polygonOnMousePressedEventHandler);
		triangle_One_M.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * 
		 */
		triangle_One_S = new Polygon();
		triangle_One_S.getPoints().addAll(
				new Double[] { 150.0, 0.0, 
						112.5, 37.5, 
						150.0, 75.0 });
		triangle_One_S.setFill(Color.PINK);
		triangle_One_S.setStroke(Color.BLACK);
		triangle_One_S.setLayoutX(res.O_pointX);
		triangle_One_S.setLayoutY(res.O_pointY);
		triangle_One_S.setCursor(Cursor.HAND);
		triangle_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
		triangle_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * 
		 */
		triangle_Two_S = new Polygon();
		triangle_Two_S.getPoints().addAll(
				new Double[] { 75.0, 75.0,
						37.5,112.5,
						112.5, 112.5 });
		triangle_Two_S.setFill(Color.CORNFLOWERBLUE);
		triangle_Two_S.setStroke(Color.BLACK);
		triangle_Two_S.setLayoutX(res.O_pointX);
		triangle_Two_S.setLayoutY(res.O_pointY);
		triangle_Two_S.setCursor(Cursor.HAND);
		triangle_Two_S.setOnMousePressed(polygonOnMousePressedEventHandler);
		triangle_Two_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * 
		 */
		square_One_S = new Polygon();
		square_One_S.getPoints().addAll(
				new Double[] { 112.5, 37.5, 
						150.0, 75.0, 
						112.5, 112.5,
						75.0,75.0});
		square_One_S.setFill(Color.GREEN);
		square_One_S.setStroke(Color.BLACK);
		square_One_S.setLayoutX(res.O_pointX);
		square_One_S.setLayoutY(res.O_pointY);
		square_One_S.setCursor(Cursor.HAND);
		square_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
		square_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		/*
		 * 
		 */
		rhombus_One_S = new Polygon();
		rhombus_One_S.getPoints().addAll(
				new Double[] { 0.0, 150.0, 
						37.5, 112.5,
						112.5,112.5,
						75.0, 150.0 });
		rhombus_One_S.setFill(Color.BROWN);
		rhombus_One_S.setStroke(Color.BLACK);
		rhombus_One_S.setLayoutX(res.O_pointX);
		rhombus_One_S.setLayoutY(res.O_pointY);
		rhombus_One_S.setCursor(Cursor.HAND);
		rhombus_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
		rhombus_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		final Group gameBoard = new Group(triangle_One_L, triangle_Two_L,
				triangle_One_M, triangle_One_S, triangle_Two_S, square_One_S,
				rhombus_One_S);

		final Group root = new Group(background, topBTNs,lowBTNs, gameBoard);

		Scene scene = new Scene(root, res.FRAME_WIDTH, res.FRAME_HEIGHT);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tangram Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	EventHandler<MouseEvent> polygonOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Polygon) (t.getSource())).getTranslateX();
			orgTranslateY = ((Polygon) (t.getSource())).getTranslateY();
		}
	};

	EventHandler<MouseEvent> polygonOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Polygon) (t.getSource())).setTranslateX(newTranslateX);
			((Polygon) (t.getSource())).setTranslateY(newTranslateY);
		}
	};

	protected void pauseORresumeTimer() {
		if (timeline.getStatus() == Status.RUNNING) {
			timeline.pause();
		} else {
			timeline.play();
		}

	}

	public Label getTimerLabel() {
		return timerLabel;
	}

	public void setTimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

}
