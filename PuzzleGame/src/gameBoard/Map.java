package gameBoard;

import java.awt.Shape;
import java.util.ArrayList;

public class Map 
{
	private boolean[][] map;
	private int _size;
	/**
	 * Constructs map object that keeps track of completion of puzzle
	 * @param size
	 */
	public Map(int size)
	{
		_size = size;
		map = new boolean[size][size];
	}
	
	/**
	 * Given a piece it will place it in the map. If it overlaps it will return false.
	 * If successful it will return true.
	 * Object will snap to the closest shape
	 * @param piece
	 * @return success?
	 */
	public boolean put(BasicTriangle piece)
	{
		Coordinate[] coords = piece.getVertices();
		
		return true;
	}
	
	/**
	 * Given a piece to remove it will take it out of the map.
	 * Returns false if it is not in the map or if operation fails
	 * @param piece
	 * @return success?
	 */
	public boolean take(Shape piece)
	{
		boolean successful = true;
		if(successful)
			return true;
		return false;
	}
	
	/**
	 * Checks to see if the map is filled
	 */
	public boolean complete()
	{
		for(int count = 0; count < _size; count++)
		{
			for(int x = 0; x < _size; x++)
			{
				if(!map[count][x])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Fills every location in the map with true
	 */
	public void fill() 
	{
		for(int count = 0; count < _size; count++)
		{
			for(int x = 0; x < _size; x++)
			{
				map[count][x] = true;
			}
		}		
	}

}
