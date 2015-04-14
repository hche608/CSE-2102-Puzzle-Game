package gameBoard;

public class Vector 
{
	private int _startX, _startY;
	private int _endX, _endY;
	private int _delX, _delY;
	
	
	public Vector(int startX, int startY, int endX, int endY)
	{
		_startX = startX;
		_startY = startY;
		_endX = endX;
		_endY = endY;
		_delX = endX - startX;
		_delY = endY - startY;
	}
	
	/**
	 * Constructor creates floating vector (With bounds, but no start or end)
	 * @param x
	 * @param y
	 */
	public Vector (int x, int y)
	{
		_delX = x;
		_delY = y;
	}
	
	public void rotate(int angle)
	{
		_delX = (int) (_delX * Math.cos(angle));
		_delY = (int) (_delY * Math.sin(angle));
		_endX = _startX + _delX;
		_endY = _startY + _delY;
	}
	
	public Coordinate getStartCoords()
	{
		return new Coordinate(_startX, _startY);
	}
	
	public double magnitude()
	{	
		if (_delX == 0)
			return _delY;
		if (_delY == 0)
			return _delX;
		
		return Math.sqrt(_delX * _delX + _delY * _delY);
	}

	public Coordinate getEndCoords() 
	{
		return new Coordinate(_endX, _endY);
	}
	
	public Coordinate getVector()
	{
		return new Coordinate(_delX, _delY);
	}

	public double getAngle(Vector vector)
	{
		return Math.acos(this.magnitude() * vector.magnitude() + this.dotProduct(vector));		
	}

	public double dotProduct(Vector vector) 
	{
		return this.getVector().getX()*vector.getVector().getX() + this.getVector().getY()*vector.getVector().getY();
	}
	
	public Path getPath()
	{
		return new Path(new Coordinate(_startX, _startY), new Coordinate(_endX, _endY));
	}
	
	public Path getInvPath()
	{
		return new Path(new Coordinate(_endX, _endY), new Coordinate(_startX, _startY));
	}
	
}
