package gameBoard;

import java.awt.geom.Point2D;

/**
 * This class used to represent coordinates within the game board Meant to make
 * drawing, removal and references easier.
 * 
 * @author Chris_000
 *
 */
public class Coordinate extends Point2D {
	private int _x;
	private int _y;

	public Coordinate(int x, int y) {
		_x = x;
		_y = y;
	}

	@Override
	public double getX() {
		return _x;
	}

	@Override
	public double getY() {
		return _y;
	}

	public int XCoord() {
		return _x;
	}

	public int YCoord() {
		return _y;
	}

	@Override
	public void setLocation(double x, double y) {
		_x = (int) x;
		_y = (int) y;
	}
}
