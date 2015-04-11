package application;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Shapes {
	Resourses res;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	Group gameBoard;
	Polygon triangle_One_L, triangle_Two_L, triangle_One_M, triangle_One_S,
			triangle_Two_S, square_One_S, rhombus_One_S;

	public Shapes(Resourses res) {
		this.res = res;
		gameBoard = new Group();
		// generateCbue();
	}

	public Group generateCbue() {
		/*
		 * 
		 * RED TRIANGLE
		 */
		triangle_One_L = new Polygon();
		triangle_One_L.getPoints().addAll(
				new Double[] { 0.0, 0.0, 0.0, res.Cube_Size, res.Cube_Size / 2,
						res.Cube_Size / 2 });
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
				new Double[] { 0.0, 0.0, res.Cube_Size, 0.0, res.Cube_Size / 2,
						res.Cube_Size / 2 });
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
				new Double[] { res.Cube_Size / 2, res.Cube_Size, res.Cube_Size,
						res.Cube_Size, res.Cube_Size, res.Cube_Size / 2 });
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
				new Double[] { res.Cube_Size, 0.0, res.Cube_Size * 3 / 4,
						res.Cube_Size / 4, res.Cube_Size, res.Cube_Size / 2 });
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
				new Double[] { res.Cube_Size / 2, res.Cube_Size / 2,
						res.Cube_Size / 4, res.Cube_Size * 3 / 4,
						res.Cube_Size * 3 / 4, res.Cube_Size * 3 / 4 });
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
				new Double[] { res.Cube_Size * 3 / 4, res.Cube_Size / 4,
						res.Cube_Size, res.Cube_Size / 2,
						res.Cube_Size * 3 / 4, res.Cube_Size * 3 / 4,
						res.Cube_Size / 2, res.Cube_Size / 2 });
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
		rhombus_One_S
				.getPoints()
				.addAll(new Double[] { 0.0, res.Cube_Size, res.Cube_Size / 4,
						res.Cube_Size * 3 / 4, res.Cube_Size * 3 / 4,
						res.Cube_Size * 3 / 4, res.Cube_Size / 2, res.Cube_Size });
		rhombus_One_S.setFill(Color.BROWN);
		rhombus_One_S.setStroke(Color.BLACK);
		rhombus_One_S.setLayoutX(res.O_pointX);
		rhombus_One_S.setLayoutY(res.O_pointY);
		rhombus_One_S.setCursor(Cursor.HAND);
		rhombus_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
		rhombus_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);

		gameBoard.getChildren().add(triangle_One_L);
		gameBoard.getChildren().add(triangle_Two_L);
		gameBoard.getChildren().add(triangle_One_M);
		gameBoard.getChildren().add(triangle_One_S);
		gameBoard.getChildren().add(triangle_Two_S);
		gameBoard.getChildren().add(square_One_S);
		gameBoard.getChildren().add(rhombus_One_S);

		/*
		 * gameBoard = new Group(triangle_One_L, triangle_Two_L, triangle_One_M,
		 * triangle_One_S, triangle_Two_S, square_One_S, rhombus_One_S);
		 */

		return gameBoard;
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

}
