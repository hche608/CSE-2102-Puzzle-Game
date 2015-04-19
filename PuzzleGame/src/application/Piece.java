package application;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Piece extends Polygon implements PieceInfo {
	Resourses res = Main.res;
	String PolygonInfo;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	int MatchedIndex = -1;

	public Piece() {
		super();
		this.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
		this.setOnMouseClicked(polygonOnMouseClickedEventHandler);
	}

	public Piece(double[] points, String PolygonInfo, double rotate_value) {
		super(points);
		this.PolygonInfo = PolygonInfo;
		this.setStroke(Color.BLACK);
		this.setFill(Color.WHITE);
		this.setRotate(rotate_value);
	}

	public Piece(double[] points, String PolygonInfo, double rotate_value,
			javafx.scene.paint.Color color) {
		super(points);
		this.PolygonInfo = PolygonInfo;
		this.setStroke(Color.BLACK);
		this.setFill(color);
		this.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
		this.setOnMouseClicked(polygonOnMouseClickedEventHandler);
		this.setRotate(rotate_value);
		this.setCursor(Cursor.HAND);
		this.setLayoutX(res.O_pointX);
		this.setLayoutY(res.O_pointY);
	}

	public void setMatchedIndex(int MatchedIndex) {
		this.MatchedIndex = MatchedIndex;
	}

	public int getMatchedIndex() {
		return MatchedIndex;
	}

	@Override
	public void setPolygonInfo(String PolygonInfo) {
		this.PolygonInfo = PolygonInfo;
	}

	@Override
	public String getPolygonInfo() {
		return PolygonInfo;
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

	EventHandler<MouseEvent> polygonOnMouseClickedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			if (t.getClickCount() >= 2) {
				double offset = ((Polygon) (t.getSource())).getRotate();
				offset = (offset + 45.0) % 360;
				((Polygon) (t.getSource())).setRotate(offset);
				((Polygon) (t.getSource())).toFront();
			}
		}
	};

	EventHandler<MouseEvent> polygonOnMouseEnteredEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			((Polygon) (t.getSource())).toFront();
		}
	};
}
