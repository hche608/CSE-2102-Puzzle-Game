package gameBoard;

public class SimpleMap 
{
	private int[][] _map;
	private DrawableShape[] _shapes;
	private Vector[] _bounds;
	
	public SimpleMap(Vector[] edges, int yDim, int xDim)
	{
		_bounds = edges;
		_map = new int[yDim][xDim];
		_shapes = new DrawableShape[7];
		for (Vector edge : _bounds)
		{
			if(!this.insertBounds(edge.getPath()))
			{
				System.out.println("Error, bad bounds");
				System.exit(1);
			}
			
		}
	}
	
	private boolean insertBounds(Path path) 
	{
		Coordinate current;
		while (path.hasNext())
		{
			current = path.getLoc();
			if(!this.setCoord(current, 8))
				return false;
			path.move();			
		}
		this.setCoord(path.getLoc(), 8);
		return true;
		
	}

	/**
	 * Draws given path into the map
	 * @param path
	 * @return
	 */	
	private void insertShapeEdge(Path path, int shapeID)
	{
		Coordinate current;
		while (path.hasNext())
		{
			current = path.getLoc();
			this.setCoord(current, shapeID);
			path.move();			
		}
		this.setCoord(path.getLoc(), shapeID);
	}
	
	/**
	 * Sets the coordinate to the given value.
	 * 1 for shape edges
	 * 2 for board edges. 
	 * @param coord
	 * @param val
	 * @return
	 */
	private boolean setCoord(Coordinate coord, int val)
	{
		int x = (int) coord.getX();
		int y = (int) coord.getY();
		if(_map[y][x] == 0)
		{
			_map[y][x] = val;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if all objects are in the game board
	 * @return
	 */
	public boolean isFull()
	{
		int count = 0;
		for (int n = 0; n < _shapes.length; n++)
		{
			if(_shapes[n] != null)
				count++;
		}
		return count == _shapes.length;
	}
	
	/**
	 * Tests to see if the shape can be inserted, then inserts the shape's edges. 
	 * @param shape
	 * @return
	 */
	public boolean put(DrawableShape shape)
	{
		for(Coordinate coord: shape.getVertices())
		{
			if(!this.validCoordinate(coord))
				return false;
		}
		for(Vector edge : shape.getVectors())
		{
			insertShapeEdge(edge.getPath(), shape.getValue());
		}
		return true;
	}
	/*
	 * Removes the shape from the map
	 * Should probably check beforehand
	 */
	public void remove(DrawableShape shape)
	{
		for(Vector edge: shape.getVectors())
		{
			insertShapeEdge(edge.getPath(), 0);
		}
	}
	/**
	 * Returns true if the coordinate is not within any shape and not outside bounds
	 * Every edge has a unique identity, and 1-6 are the 
	 * @param coord
	 * @return
	 */
	public boolean validCoordinate(Coordinate coord)
	{
		int x = coord.getX();
		int y = coord.getY();
		int[] collisions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		for (; x >= 0; x--)
		{
			if (_map[y][x] != 0)
				collisions[_map[x][y]]++;
		}
		if (collisions[8]%2 == 1 && collisions[1]%2 == 0 && collisions[2]%2 == 0 && collisions[3]%2 == 0
				&& collisions[4]%2 == 0 && collisions[5]%2 == 0 && collisions[6]%2 == 0 && collisions[7]%2 == 0)
			return true;
		else
			return false;		
	}
	
	/**
	 * Gives the closest point on the boundary of the map
	 * @param coord
	 * @return
	 */
	public Coordinate getClosestEdge(Coordinate coord)
	{
		if (coord.getY() > coord.getX())
			return new Coordinate (coord.getX(), 0);
		return new Coordinate (0, coord.getY());
	}
	/**
	 * Prints state of the board, which is just edges.
	 */
	public void printState()
	{
		for (int y = 0; y < _map.length; y++)
		{
			for (int x = 0; x < _map[x].length; x++)
			{
				System.out.print(_map[y][x]);
			}
			System.out.println();
		}
	}

}
