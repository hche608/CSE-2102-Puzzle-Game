package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Shapes {
	Resourses res = Main.res;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	ArrayList<Polygon> polygons;
	Polygon triangle_One_L, triangle_Two_L, triangle_One_M, triangle_One_S,
			triangle_Two_S, square_One_S, rhombus_One_S, map;
	GameController controller;


	public Shapes(GameController controller) {
		this.controller = controller;
		polygons = new ArrayList<Polygon>();
		try {
			map = new Polygon();

			map.getPoints().addAll(
					new Double[] { 278.0, 0.0, 203.0, 0.0, 203.0, 75.0, 165.5,
							112.5, 150.0, 97.0, 150.0, 0.0, 0.0, 150.0, 150.0,
							150.0, 97.0, 203.0, 203.0, 203.0, 150.0, 150.0,
							203.0, 150.0, 240.5, 112.5, 240.5, 37.5 });
			/*
			 * map.getPoints().addAll( new Double[] {0.0,0.0, res.Cube_Size,0.0,
			 * res.Cube_Size,res.Cube_Size, 0.0,res.Cube_Size});
			 */
			map.setLayoutX(res.O_pointX + 400);
			map.setLayoutY(res.O_pointY - 100);
			map.setFill(Color.WHITE);
			/*
			 * 
			 * RED TRIANGLE
			 */
			triangle_One_L = new Polygon();
			triangle_One_L.getPoints().addAll(
					new Double[] { 0.0, 0.0, 0.0, res.Cube_Size,
							res.Cube_Size / 2, res.Cube_Size / 2 });
			triangle_One_L.setFill(Color.RED);
			triangle_One_L.setStroke(Color.BLACK);
			triangle_One_L.setLayoutX(res.O_pointX);
			triangle_One_L.setLayoutY(res.O_pointY);
			triangle_One_L.setCursor(Cursor.HAND);
			triangle_One_L.setOnMousePressed(polygonOnMousePressedEventHandler);
			triangle_One_L.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
			triangle_One_L.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			triangle_One_L.setOnMouseEntered(polygonOnMouseEnteredEventHandler);

			/*
			 * BLUE TRIANGLE
			 */
			triangle_Two_L = new Polygon();
			triangle_Two_L.getPoints().addAll(
					new Double[] { 0.0, 0.0, res.Cube_Size, 0.0,
							res.Cube_Size / 2, res.Cube_Size / 2 });
			triangle_Two_L.setFill(Color.BLUE);
			triangle_Two_L.setStroke(Color.BLACK);
			triangle_Two_L.setLayoutX(res.O_pointX);
			triangle_Two_L.setLayoutY(res.O_pointY);
			triangle_Two_L.setCursor(Cursor.HAND);
			triangle_Two_L.setOnMousePressed(polygonOnMousePressedEventHandler);
			triangle_Two_L.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
			triangle_Two_L.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			triangle_Two_L.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
			/*
			 * 
			 */
			triangle_One_M = new Polygon();
			triangle_One_M.getPoints().addAll(
					new Double[] { res.Cube_Size / 2, res.Cube_Size,
							res.Cube_Size, res.Cube_Size, res.Cube_Size,
							res.Cube_Size / 2 });
			triangle_One_M.setFill(Color.YELLOW);
			triangle_One_M.setStroke(Color.BLACK);
			triangle_One_M.setLayoutX(res.O_pointX);
			triangle_One_M.setLayoutY(res.O_pointY);
			triangle_One_M.setCursor(Cursor.HAND);
			triangle_One_M.setOnMousePressed(polygonOnMousePressedEventHandler);
			triangle_One_M.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
			triangle_One_M.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			triangle_One_M.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
			/*
			 * 
			 */
			triangle_One_S = new Polygon();
			triangle_One_S.getPoints()
					.addAll(new Double[] { res.Cube_Size, 0.0,
							res.Cube_Size * 3 / 4, res.Cube_Size / 4,
							res.Cube_Size, res.Cube_Size / 2 });
			triangle_One_S.setFill(Color.PINK);
			triangle_One_S.setStroke(Color.BLACK);
			triangle_One_S.setLayoutX(res.O_pointX);
			triangle_One_S.setLayoutY(res.O_pointY);
			triangle_One_S.setCursor(Cursor.HAND);
			triangle_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
			triangle_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
			triangle_One_S.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			triangle_One_S.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
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
			triangle_Two_S.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			triangle_Two_S.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
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
			square_One_S.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			square_One_S.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
			/*
			 * 
			 */
			rhombus_One_S = new Polygon();
			rhombus_One_S.getPoints().addAll(
					new Double[] { 0.0, res.Cube_Size, res.Cube_Size / 4,
							res.Cube_Size * 3 / 4, res.Cube_Size * 3 / 4,
							res.Cube_Size * 3 / 4, res.Cube_Size / 2,
							res.Cube_Size });
			rhombus_One_S.setFill(Color.BROWN);
			rhombus_One_S.setStroke(Color.BLACK);
			rhombus_One_S.setLayoutX(res.O_pointX);
			rhombus_One_S.setLayoutY(res.O_pointY);
			rhombus_One_S.setCursor(Cursor.HAND);
			rhombus_One_S.setOnMousePressed(polygonOnMousePressedEventHandler);
			rhombus_One_S.setOnMouseDragged(polygonOnMouseDraggedEventHandler);
			rhombus_One_S.setOnMouseClicked(polygonOnMouseClickedEventHandler);
			rhombus_One_S.setOnMouseEntered(polygonOnMouseEnteredEventHandler);
			
			
			polygons.add(map);
			polygons.add(triangle_One_L);
			polygons.add(triangle_Two_L);
			polygons.add(triangle_One_M);
			polygons.add(triangle_One_S);
			polygons.add(triangle_Two_S);
			polygons.add(square_One_S);
			polygons.add(rhombus_One_S);

		} catch (Exception e) {
			System.out.println("Initial Shapes error: " + e);
		}
	}

	public ArrayList<Polygon> getCube() {
		return polygons;
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
			controller.playTimer();
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
