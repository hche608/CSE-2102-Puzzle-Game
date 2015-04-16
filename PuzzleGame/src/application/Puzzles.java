package application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Puzzles {

	Resourses res;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	Group puzzleBoard;
	Polygon magicShape;

	public Puzzles(Resourses res) {
		this.res = res;
		puzzleBoard = new Group();
	}

	public Group generatePuzzle() {
		/*
		 * 
		 * RED TRIANGLE
		 */
		magicShape = new Polygon();
		magicShape.getPoints().addAll(
				new Double[] { 0.0, 0.0, res.Cube_Size, 0.0, res.Cube_Size,
						res.Cube_Size, 0.0, res.Cube_Size });
		magicShape.setFill(Color.ANTIQUEWHITE);
		magicShape.setStroke(Color.BLACK);
		magicShape.setLayoutX(res.O_pointX + 350);
		magicShape.setLayoutY(res.O_pointY - 100);
		magicShape.setOnDragOver(polygonEnteredPropertyEventHandler);
		// System.out.println(magicShape.computeAreaInScreen());
		// magicShape.setOnMousePressed(polygonOnMousePressedEventHandler);
		// magicShape.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		puzzleBoard.getChildren().add(magicShape);

		return puzzleBoard;
	}

	EventHandler<DragEvent> polygonEnteredPropertyEventHandler = new EventHandler<DragEvent>() {

		@Override
		public void handle(DragEvent e) {
			System.out.println("X: " + e.getX() + "Y: " + e.getY());

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
}
