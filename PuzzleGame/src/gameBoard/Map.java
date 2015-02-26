package gameBoard;

import java.awt.Shape;
import java.util.ArrayList;

public class Map 
{
	private boolean[][] map;
	private int _size;
	/**
	 * Constructs map object that keeps track of completion of puzzle
	 * @param shapes
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
	public boolean put(Shape piece)
	{
		boolean successful = true;
		if (successful)
			return true;
		return false;
	}
	
	/**
	 * Given a piece to remove it will take it out of the map.
	 * Returns false if it is not in the map
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
	 * For testing purposes only
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
	/**
	 * Adds given triangle shape to the map
	 * @param tri
	 */
	private boolean putTriangle(Shape tri)
	{
		boolean successful = true;
		if (successful)
			return true;
		return false;
	}
	
	/**
	 * Adds given rectangle to the map
	 * @param rect
	 * @return true if successful
	 */
	private boolean putRectangle(Shape rect)
	{
		boolean successful = true;
		if (successful)
			return true;
		return false;
	}

}
