package gameBoard;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class BasicTriangle implements Shape 
{
	private final int _A;		//Shortest side length  
	private final int _B;		//Second longest length side
	private final int _C;		//Hypotenmoose, all lengths are in pixels 
	private Coordinate _aCoord; //Intersection of A and B
	private Coordinate _bCoord; //Intersection of B and C
	private Coordinate _cCoord; //Intersection of C and A
	private int _rotation;
	
	public BasicTriangle(int a, int b, int c)
	{
		_A = a;
		_B = b;
		_C = c;
	}
	
	/**
	 * Returns coordinates in A,B,C in array
	 * @return
	 */
	public Coordinate[] getVertices()
	{
		Coordinate[] coords = {_aCoord, _bCoord, _cCoord};
		return coords;
	}
	
	/**
	 * Returns side lengths A, B and C
	 * @return
	 */
	public int[] getSides()
	{
		int[] sides = {_A, _B, _C};
		return sides;
	}
	
	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
