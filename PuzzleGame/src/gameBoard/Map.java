package gameBoard;

import java.awt.Shape;
import java.util.ArrayList;

public class Map 
{
	private boolean[][] map;
	
	/**
	 * Constructs map object that keeps track of completion of puzzle
	 * @param shapes
	 * @param size
	 */
	public Map(ArrayList<Shape> shapes, int size)
	{
		//create map of appropriate size and fill with shapes
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
		for(int count = 0; count < map.length; count++)
		{
			for(int x = 0; x < map[count].length; count++)
			{
				if(!map[count][x])
				{
					return false;
				}
			}
		}
		return true;
	}

}
