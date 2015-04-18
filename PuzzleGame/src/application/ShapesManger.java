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
			triangle_Two_S, square_One_S, rhombus_One_S, map;
	GameController controller;

	public ShapesManger(GameController controller) {
		this.controller = controller;
		polygons = new ArrayList<Piece>();
		maps = new ArrayList<Piece>();
		try {
			map = new Piece(res.Triangle_L, "Triangle_L", 0.0);
			map.setLayoutX(400);
			map.setLayoutY(300);

			/*
			 * 
			 * RED TRIANGLE
			 */
			triangle_One_L = new Piece(res.Triangle_L, "Triangle_L", 0.0, Color.RED);

			/*
			 * BLUE TRIANGLE
			 */
			triangle_Two_L = new Piece(res.Triangle_L, "Triangle_L", 90.0, Color.BLUE);
			triangle_Two_L.setTranslateX(40);
			triangle_Two_L.setTranslateY(-40);

			/*
			 * 
			 */
			triangle_One_M = new Piece(res.Triangle_M, "Triangle_M", 0.0, Color.YELLOW);
			triangle_One_M.setTranslateX(0);
			triangle_One_M.setTranslateY(0);

			/*
			 * 
			 */
			triangle_One_S = new Piece(res.Triangle_S, "Triangle_S", 180.0, Color.PINK);
			triangle_One_S.setTranslateX(0);
			triangle_One_S.setTranslateY(0);

			/*
			 * 
			 */
			triangle_Two_S = new Piece(res.Triangle_S, "Triangle_S", 270.0, Color.CORNFLOWERBLUE);
			triangle_Two_S.setTranslateX(40);
			triangle_Two_S.setTranslateY(-40);

			/*
			 * 
			 */
			square_One_S = new Piece(res.Square_S, "Square_S", 0, Color.GREEN);

			/*
			 * 
			 */
			rhombus_One_S = new Piece(res.Rhombus_S, "Rhombus_S", 0.0, Color.BROWN);

			
			polygons.add(triangle_One_L);
			polygons.add(triangle_Two_L);
			polygons.add(triangle_One_M);
			polygons.add(triangle_One_S);
			polygons.add(triangle_Two_S);
			polygons.add(square_One_S);
			polygons.add(rhombus_One_S);
			maps.add(map);
			
			for (int i = 0; i < 7; i++){
				polygons.get(i).setOnMousePressed(polygonOnMousePressedEventHandler);
				polygons.get(i).setOnMouseDragged(polygonOnMouseDraggedEventHandler);
				polygons.get(i).setOnMouseReleased(polygonOnMouseReleasedEventHandler);
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
			int MatchedIndex = checkPieceIntersection((Piece) (t.getSource()), maps);
			if (MatchedIndex != -1){
				System.out.println(MatchedIndex);
				matchedPieces((Piece) (t.getSource()), maps.get(MatchedIndex));
				maps.remove(MatchedIndex);
				}
		}
	};

	private int checkPieceIntersection(Piece test_polygon,
			ArrayList<Piece> target_polygons) {
		int collisionDetected = -1;
		for (int i = 0; i < target_polygons.size(); i++){
			Shape intersect = Shape.intersect(test_polygon, target_polygons.get(i));
			if (intersect.getBoundsInLocal().getWidth() != -1) {
				if (test_polygon.getPolygonInfo().equals(
						target_polygons.get(i).getPolygonInfo()))
					if (test_polygon.getRotate() == target_polygons.get(i).getRotate())
						collisionDetected = i;
						break;
			}
		}

		return collisionDetected;
	}
	
	private void matchedPieces(Piece test_polygon,
			Piece target_polygon){
		test_polygon.setTranslateX(target_polygon.getLayoutX() - test_polygon.getLayoutX());
		test_polygon.setTranslateY(target_polygon.getLayoutY() - test_polygon.getLayoutY());
	}
}
