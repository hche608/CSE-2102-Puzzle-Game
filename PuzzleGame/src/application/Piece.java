package application;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

public class Piece extends Polygon implements PieceInfo {
	Resourses res = Main.res;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	Polygon polygon;
	double rotation;

	public Piece() {
		super();
		rotation = 0;
		this.setOnMousePressed(polygonOnMousePressedEventHandler);
		this.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
		this.setOnMouseClicked(polygonOnMouseClickedEventHandler);
		this.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPolygonInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return null;
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

			System.out.println("X: " + t.getSceneX() + " ,Y: " + t.getSceneY());
			if(t.getClickCount() >= 2){
				double offset = ((Polygon) (t.getSource())).getRotate();
				offset = (offset + 45.0) % 360;
				((Polygon) (t.getSource())).setRotate(offset);
				((Polygon) (t.getSource())).toFront();
			}

		}
	};

	EventHandler<MouseEvent> polygonOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			//controller.playTimer();
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Polygon) (t.getSource())).setTranslateX(newTranslateX);
			((Polygon) (t.getSource())).setTranslateY(newTranslateY);
		}
	};
	
	EventHandler<MouseEvent> polygonOnMouseEnteredEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			((Polygon) (t.getSource())).toFront();
			//orgSceneX = t.getSceneX();
			//orgSceneY = t.getSceneY();
			//orgTranslateX = ((Polygon) (t.getSource())).getTranslateX();
			//orgTranslateY = ((Polygon) (t.getSource())).getTranslateY();
		}
	};
}
