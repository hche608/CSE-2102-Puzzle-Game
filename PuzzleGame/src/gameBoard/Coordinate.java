package gameBoard;

/**
 * This class used to represent coordinates within the game board
 * Meant to make drawing, removal and references easier.
 * @author Chris_000
 *
 */
public class Coordinate 
{
	private int _x;
	private int _y;
	
	public Coordinate (int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	public int getX()
	{
		return _x;
	}
	
	public int getY()
	{
		return _y;
	}

	
	public boolean isEqual(Coordinate coord)
	{
		return _x == coord.getX() && _y == coord.getY();
	}
}
