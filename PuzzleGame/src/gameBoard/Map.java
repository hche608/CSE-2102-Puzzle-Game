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
		int[] lengths = piece.getSides();
		int vertical = coords[0].YCoord();
		for (int yOffset = coords[1].YCoord(); yOffset <= Math.abs(vertical); yOffset++)
		{
			int horizontal = (int)((yOffset * Math.tan(Math.atan(lengths[0]/((double)lengths[1])))) + .5) + coords[1].XCoord();
			for(int xOffset = coords[1].XCoord(); xOffset <= Math.abs(horizontal); xOffset++)
			{
				if (!map[yOffset][xOffset])
					map[yOffset][xOffset] = true;  //Works as long as a and b have same x coordinate
				else
				{
					cleanUp(piece, xOffset, yOffset);
					return false;
				}
					
								
			}
		}
		return true;
	}
	
	public void cleanUp(BasicTriangle removeThis, int x, int y)
	{
		Coordinate[] coords = removeThis.getVertices();
		int[] lengths = removeThis.getSides();
		int vertical = coords[0].YCoord();
		for (int yOffset = coords[1].YCoord(); yOffset <= Math.abs(vertical); yOffset++)
		{
			int horizontal = (int)((yOffset * Math.tan(Math.atan(lengths[0]/((double)lengths[1])))) + .5) + coords[1].XCoord();
			for(int xOffset = coords[1].XCoord(); xOffset <= Math.abs(horizontal); xOffset++)
			{
				if (map[yOffset][xOffset] && !(x == xOffset && y == yOffset))
					map[yOffset][xOffset] = false;  //Works as long as a and b have same x coordinate
				else
					return;
								
			}
		}
		
	}
	
	public boolean put(DrawableShape rect)
	{
		Coordinate[] coords = rect.getVertices();
		int[] sides = rect.getSides();
		int startY = coords[0].YCoord();
		int startX = coords[0].XCoord();
		int bottomLeft = startY + sides[0];
		int rightBound = startX + sides[1];
		for (int YOffset = startY; YOffset < bottomLeft; YOffset++)
		{
			for (int XOffset = startX; XOffset < rightBound - 1; XOffset++)
			{
				if (!map[YOffset][XOffset])
					map[YOffset][XOffset] = true;
				else
				{
					cleanUp(rect, XOffset, YOffset);
					return false;
				}
			}
		}
		return true;
	}
	
	public void cleanUp(DrawableShape removeThis, int x, int y)
	{
		Coordinate[] coords = removeThis.getVertices();
		int[] sides = removeThis.getSides();
		int startY = coords[0].YCoord();
		int startX = coords[0].XCoord();
		int bottomLeft = startY + sides[0];
		int rightBound = startX + sides[1];
		for (int YOffset = startY; YOffset < bottomLeft; YOffset++)
		{
			for (int XOffset = startX; XOffset < rightBound - 1; XOffset++)
			{
				if (map[YOffset][XOffset] && !(XOffset == x && YOffset == y))
					map[YOffset][XOffset] = false;
				else
					return;
			}
		}
	}
	
	/**
	 * Given a piece to remove it will take it out of the map.
	 * Returns false if it is not in the map or if operation fails
	 * @param piece
	 * @return success?
	 */
	public boolean take(BasicTriangle piece)
	{
		Coordinate[] coords = piece.getVertices();
		int[] lengths = piece.getSides();
		int vertical = coords[0].YCoord() - coords[1].YCoord();
		for (int yOffset = 0; yOffset <= Math.abs(vertical); yOffset++)
		{
			int horizontal = (int)(vertical * Math.tan(Math.atan(lengths[0]/((double)lengths[1]))));
			for(int xOffset = 0; xOffset <= Math.abs(horizontal); xOffset++)
			{
				if (!map[yOffset + vertical + coords[1].YCoord()][xOffset + horizontal + coords[1].XCoord()])
					map[yOffset + vertical + coords[1].YCoord()][xOffset + horizontal + coords[1].XCoord()] = true;  //Works as long as a and b have same x coordinate
				else
					return false;
			}
		}
		return true;
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
	public void printState()
	{
		for (int y = 0; y < _size; y++)
		{
			for (int x = 0; x < _size; x++)
			{
				if(map[y][x])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
	}

}
