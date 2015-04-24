/**
 * This is polygon controller
 * this class is controlled by GameController
 * 
 * this class only allocates all pickable and unpickable polygons
 * 
 * this class is kind of simple level factory now.
 * 
 * @author hche608
 * 
 */
package application;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class ShapesManger {
	private Resourses res = Main.res;
	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;
	private ArrayList<Piece> polygons;
	private ArrayList<Piece> maps;
	

	private Piece triangle_One_L, triangle_Two_L, triangle_One_M, triangle_One_S,
			triangle_Two_S, square_One_S, rhombus_One_S, triangle_One_L_map,
			triangle_Two_L_map, triangle_One_M_map, triangle_One_S_map,
			triangle_Two_S_map, square_One_S_map, rhombus_One_S_map;
	private GameController controller;

	/**
	 * if Mouse is Pressed
	 * 
	 * get coordinates of the current point and store it for further use
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
			t.consume();
		}
	};

	/**
	 * Dragged the polygon
	 * 
	 * 
	 */
	EventHandler<MouseEvent> polygonOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			controller.playTimer();
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			if(res.debug){
				System.out.printf("I am %s,(%s,%s).\n", ((Piece) (t.getSource())).getPolygonInfo(), newTranslateX,newTranslateY);
			}
			((Polygon) (t.getSource())).setTranslateX(newTranslateX);
			((Polygon) (t.getSource())).setTranslateY(newTranslateY);
			
			t.consume();
		}
	};

	/**
	 * if Mouse is released
	 * 
	 * check if a pickable polygon moved
	 * 
	 * check is the game completed
	 * 
	 * 
	 */
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
						break;
					}
				}
				if (isTaken == false
						|| ((Piece) (t.getSource())).getMatchedIndex() == MatchedIndex) {
					setMatchedPieces((Piece) (t.getSource()),
							maps.get(MatchedIndex));
					
					((Piece) (t.getSource())).setMatchedIndex(MatchedIndex);
				}
			} else {
				((Piece) (t.getSource())).setMatchedIndex(-1);
			}
			
			if (isCompleted()) {
				System.out.printf("(%s,%s)",((Piece) (t.getSource())).getTranslateX(),((Piece) (t.getSource())).getTranslateY());
				System.out.printf("(%s,%s)",maps.get(MatchedIndex).getTranslateX(),maps.get(MatchedIndex).getTranslateY());
				System.out.println("Index of the Last Polygon: " + MatchedIndex);
				controller.completed();
			}
			t.consume();
		}
	};

	public ShapesManger(GameController controller, int level) {
		this.controller = controller;
		
		polygons = new ArrayList<Piece>();
		maps = new ArrayList<Piece>();
		
		try {

			// initial a puzzle
			triangle_One_L_map = new Piece(res.Triangle_L, "Triangle_L", 180.0);
			triangle_One_L_map.setTranslateX(453);
			triangle_One_L_map.setTranslateY(240);

			triangle_Two_L_map = new Piece(res.Triangle_L, "Triangle_L", 270.0);
			triangle_Two_L_map.setTranslateX(415);
			triangle_Two_L_map.setTranslateY(277.5);

			triangle_One_M_map = new Piece(res.Triangle_M, "Triangle_M", 45.0);
			triangle_One_M_map.setTranslateX(490);
			triangle_One_M_map.setTranslateY(406);

			triangle_One_S_map = new Piece(res.Triangle_S, "Triangle_S", 135.0);
			triangle_One_S_map.setTranslateX(523.5);
			triangle_One_S_map.setTranslateY(339);

			triangle_Two_S_map = new Piece(res.Triangle_S, "Triangle_S", 90.0);
			triangle_Two_S_map.setTranslateX(601.6);
			triangle_Two_S_map.setTranslateY(218.6);

			square_One_S_map = new Piece(res.Square_S, "Square_S", 0.0);
			square_One_S_map.setTranslateX(470);
			square_One_S_map.setTranslateY(276);

			rhombus_One_S_map = new Piece(res.Rhombus_S, "Rhombus_S", 90.0);
			rhombus_One_S_map.setTranslateX(546);
			rhombus_One_S_map.setTranslateY(163);

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

	/**
	 * if a pickable polygon intersects a unpickable polygon
	 * 
	 * 1st test is checking if the two shapes are intersected 2nd test is
	 * checking the area of intersected is large enough 3rd test is checking if
	 * the two shapes are in the same type and size 4nd test is checking if the
	 * two shapes are same rotated
	 * 
	 * if all matched then return
	 * 
	 * @return the index of the matched unpickable polygon
	 * 
	 */

	private int checkPieceIntersection(Piece test_polygon,
			ArrayList<Piece> target_polygons) {
		int collisionDetected = -1;
		for (int i = 0; i < target_polygons.size(); i++) {
			Shape intersect = Shape.intersect(test_polygon,
					target_polygons.get(i));
			if (intersect.getBoundsInLocal().getWidth() != -1) {
				if (Math.abs(test_polygon.getTranslateX()
						- target_polygons.get(i).getTranslateX()) < 50.0
						&& Math.abs((test_polygon.getTranslateY() - target_polygons
								.get(i).getTranslateY())) < 50.0) {
					if (test_polygon.getPolygonInfo().equals(
							target_polygons.get(i).getPolygonInfo()))
						if (test_polygon.getRotate() == target_polygons.get(i)
								.getRotate()) {
							collisionDetected = i;
							break;
						}
				}
			}
		}
		return collisionDetected;
	}

	public ArrayList<Piece> getCube() {
		return polygons;
	}

	public ArrayList<Piece> getMaps() {
		return maps;
	}

	/**
	 * Returns is all unpickable polygon 100% matched
	 * 
	 * @return isCompleted
	 */
	private boolean isCompleted() {
		boolean isCompleted = true;
		for (int i = 0; i < polygons.size(); i++) {
			if (polygons.get(i).getMatchedIndex() == -1) {
				isCompleted = false;
				break;
			}
		}
		return isCompleted;
	}

	/**
	 * if a pickable polygon is matched to a unpickable polygon
	 * 
	 * set the coordinates of the pickable polygon
	 * 
	 */

	private void setMatchedPieces(Piece test_polygon, Piece target_polygon) {
		test_polygon.setTranslateX(target_polygon.getTranslateX());
		test_polygon.setTranslateY(target_polygon.getTranslateY());
		res.shapesMatchedFXmediaPlayer.play();
	}
}
