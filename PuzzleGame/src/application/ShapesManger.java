package application;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class ShapesManger {
	Resourses res = Main.res;
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	ArrayList<Piece> polygons;
	ArrayList<Piece> maps;

	Piece triangle_One_L, triangle_Two_L, triangle_One_M, triangle_One_S,
			triangle_Two_S, square_One_S, rhombus_One_S, triangle_One_L_map,
			triangle_Two_L_map, triangle_One_M_map, triangle_One_S_map,
			triangle_Two_S_map, square_One_S_map, rhombus_One_S_map;
	GameController controller;

	public ShapesManger(GameController controller, int level) {
		this.controller = controller;
		polygons = new ArrayList<Piece>();
		maps = new ArrayList<Piece>();
		try {

			// initial a puzzle
			triangle_One_L_map = new Piece(res.Triangle_L, "Triangle_L", 0.0);
			triangle_One_L_map.setTranslateX(400);
			triangle_One_L_map.setTranslateY(300);

			triangle_Two_L_map = new Piece(res.Triangle_L, "Triangle_L", 90.0);
			triangle_Two_L_map.setTranslateX(480);
			triangle_Two_L_map.setTranslateY(200);

			triangle_One_M_map = new Piece(res.Triangle_M, "Triangle_M", 180.0);
			triangle_One_M_map.setTranslateX(380);
			triangle_One_M_map.setTranslateY(80);

			triangle_One_S_map = new Piece(res.Triangle_S, "Triangle_S", 270.0);
			triangle_One_S_map.setTranslateX(450);
			triangle_One_S_map.setTranslateY(400);

			triangle_Two_S_map = new Piece(res.Triangle_S, "Triangle_S", 90.0);
			triangle_Two_S_map.setTranslateX(450);
			triangle_Two_S_map.setTranslateY(450);

			square_One_S_map = new Piece(res.Square_S, "Square_S", 0.0);
			square_One_S_map.setTranslateX(500);
			square_One_S_map.setTranslateY(200);

			rhombus_One_S_map = new Piece(res.Rhombus_S, "Rhombus_S", 0.0);
			rhombus_One_S_map.setTranslateX(500);
			rhombus_One_S_map.setTranslateY(230);

			maps.add(triangle_One_L_map);
			maps.add(triangle_Two_L_map);
			maps.add(triangle_One_M_map);
			maps.add(triangle_One_S_map);
			maps.add(triangle_Two_S_map);
			maps.add(square_One_S_map);
			maps.add(rhombus_One_S_map);

			/*
			 * 
			 * RED TRIANGLE
			 */
			triangle_One_L = new Piece(res.Triangle_L, "Triangle_L", 0.0,
					Color.RED);
			triangle_One_L.setTranslateX(res.O_pointX);
			triangle_One_L.setTranslateY(res.O_pointY);

			/*
			 * BLUE TRIANGLE
			 */
			triangle_Two_L = new Piece(res.Triangle_L, "Triangle_L", 90.0,
					Color.BLUE);
			triangle_Two_L.setTranslateX(res.O_pointX + res.Cube_Size / 4);
			triangle_Two_L.setTranslateY(res.O_pointY - res.Cube_Size / 4);

			/*
			 * 
			 */
			triangle_One_M = new Piece(res.Triangle_M, "Triangle_M", 180.0,
					Color.YELLOW);
			triangle_One_M.setTranslateX(res.O_pointX + res.Cube_Size / 2);
			triangle_One_M.setTranslateY(res.O_pointY + res.Cube_Size / 2);

			/*
			 * 
			 */
			triangle_One_S = new Piece(res.Triangle_S, "Triangle_S", 180.0,
					Color.PINK);
			triangle_One_S.setTranslateX(res.O_pointX + res.Cube_Size / 4 * 3);
			triangle_One_S.setTranslateY(res.O_pointY);

			/*
			 * 
			 */
			triangle_Two_S = new Piece(res.Triangle_S, "Triangle_S", 270.0,
					Color.CORNFLOWERBLUE);
			triangle_Two_S
					.setTranslateX(res.O_pointX + res.Cube_Size / 53 * 20);
			triangle_Two_S
					.setTranslateY(res.O_pointY + res.Cube_Size / 53 * 20);

			/*
			 * 
			 */
			square_One_S = new Piece(res.Square_S, "Square_S", 0, Color.GREEN);
			square_One_S.setTranslateX(res.O_pointX);
			square_One_S.setTranslateY(res.O_pointY);

			/*
			 * 
			 */
			rhombus_One_S = new Piece(res.Rhombus_S, "Rhombus_S", 0.0,
					Color.BROWN);
			rhombus_One_S.setTranslateX(res.O_pointX);
			rhombus_One_S.setTranslateY(res.O_pointY);

			polygons.add(triangle_One_L);
			polygons.add(triangle_Two_L);
			polygons.add(triangle_One_M);
			polygons.add(triangle_One_S);
			polygons.add(triangle_Two_S);
			polygons.add(square_One_S);
			polygons.add(rhombus_One_S);

			for (int i = 0; i < 7; i++) {
				polygons.get(i).setOnMousePressed(
						polygonOnMousePressedEventHandler);
				polygons.get(i).setOnMouseDragged(
						polygonOnMouseDraggedEventHandler);
				polygons.get(i).setOnMouseReleased(
						polygonOnMouseReleasedEventHandler);
			}
		} catch (Exception e) {
			System.out.println("Initial Shapes error: " + e);
		}
	}

	public ArrayList<Piece> getCube() {
		return polygons;
	}

	public ArrayList<Piece> getMaps() {
		return maps;
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
			controller.playTimer();
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Polygon) (t.getSource())).setTranslateX(newTranslateX);
			((Polygon) (t.getSource())).setTranslateY(newTranslateY);
		}
	};

	EventHandler<MouseEvent> polygonOnMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			// collision Detection
			int MatchedIndex = checkPieceIntersection((Piece) (t.getSource()),
					maps);
			if (MatchedIndex != -1) {
				boolean isTaken = false;
				for (int i = 0; i < polygons.size(); i++) {
					if (polygons.get(i).getMatchedIndex() == MatchedIndex) {
						isTaken = true;
					}
				}
				if (isTaken == false
						|| ((Piece) (t.getSource())).getMatchedIndex() == MatchedIndex) {
					matchedPieces((Piece) (t.getSource()),
							maps.get(MatchedIndex));
					((Piece) (t.getSource())).setMatchedIndex(MatchedIndex);
				}
			} else {
				((Piece) (t.getSource())).setMatchedIndex(-1);
			}
			if (isCompleted()) {
				System.out.println("Win");
				controller.completed();
			}
		}
	};

	private int checkPieceIntersection(Piece test_polygon,
			ArrayList<Piece> target_polygons) {
		int collisionDetected = -1;
		for (int i = 0; i < target_polygons.size(); i++) {
			Shape intersect = Shape.intersect(test_polygon,
					target_polygons.get(i));
			if (intersect.getBoundsInLocal().getWidth() != -1) {
				if (test_polygon.getPolygonInfo().equals(
						target_polygons.get(i).getPolygonInfo()))
					if (test_polygon.getRotate() == target_polygons.get(i)
							.getRotate()) {
						collisionDetected = i;
						break;
					}
			}
		}
		return collisionDetected;
	}

	private void matchedPieces(Piece test_polygon, Piece target_polygon) {
		test_polygon.setTranslateX(target_polygon.getTranslateX());
		test_polygon.setTranslateY(target_polygon.getTranslateY());
	}

	private boolean isCompleted() {
		boolean isCompleted = true;
		for (int i = 0; i < polygons.size(); i++) {
			if (polygons.get(i).getMatchedIndex() == -1) {
				isCompleted = false;
			}
		}
		return isCompleted;
	}
}
