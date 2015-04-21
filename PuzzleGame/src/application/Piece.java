/**
 * This is a Piece class, which extends Polygon, and implements PieceInfo
 * 
 * This class generates Polygon.
 * 
 * this class is controlled by GameController
 * 
 * 
 * @author hche608
 * 
 */
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
		this.PolygonInfo = PolygonInfo;
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
		this.PolygonInfo = PolygonInfo;
	}

	/**
	 * Matched Index used to store info that tells which index of
	 * white(unpickable) polygon matches with the colorful(pickable) polygon
	 * 
	 */
	public void setMatchedIndex(int MatchedIndex) {
		this.MatchedIndex = MatchedIndex;
	}

	public int getMatchedIndex() {
		return MatchedIndex;
	}

	/**
	 * Store the size and what type of polygon
	 * 
	 */
	@Override
	public void setPolygonInfo(String PolygonInfo) {
		this.PolygonInfo = PolygonInfo;
	}

	/**
	 * return the size and what type of polygon
	 * 
	 * @param PolygonInfo
	 */
	@Override
	public String getPolygonInfo() {
		return PolygonInfo;
	}

	/**
	 * get coordinates when Mouse Pressed
	 * 
	 * 
	 */
	EventHandler<MouseEvent> polygonOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Polygon) (t.getSource())).getTranslateX();
			orgTranslateY = ((Polygon) (t.getSource())).getTranslateY();
		}
	};

	/**
	 * rotate the polygon when double clicked
	 * 
	 * 
	 */
	EventHandler<MouseEvent> polygonOnMouseClickedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			if (t.getClickCount() >= 2) {
				double offset = ((Polygon) (t.getSource())).getRotate();
				if (PolygonInfo.equals("Square_S")) {
					offset = (offset + 45.0) % 90;
				} else if (PolygonInfo.equals("Rhombus_S")) {
					offset = (offset + 45.0) % 180;
				} else {
					offset = (offset + 45.0) % 360;
				}

				((Polygon) (t.getSource())).setRotate(offset);
				((Polygon) (t.getSource())).toFront();
				t.consume();
			}
		}
	};

	/**
	 * get the current polygon to front if it is covered by other polygon
	 * 
	 */
	EventHandler<MouseEvent> polygonOnMouseEnteredEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			((Polygon) (t.getSource())).toFront();
		}
	};
}
