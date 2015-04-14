package gameBoard;

public class BasicShape implements DrawableShape
{
	private Vector[] _vectors;		//Sorted by shortest magnitude 
	private Coordinate[] _vertices;   //Coincides with start coordinates of vertexes
	private int _rotation;
	private int _sides;
	
	public BasicShape(Vector[] vectors)
	{
		_rotation = 0;
		_vectors = vectors;
		_sides = _vectors.length;
		_vertices = new Coordinate[_sides];
		setCoords(_vectors);
	}
	
	/**
	 * Returns coordinates in A,B,C in array
	 * @return
	 */
	public Coordinate[] getVertices()
	{
		return _vertices;
	}
	
	/**
	 * Sets coordinates according to the vertices
	 * @param Vectors of a polygon
	 */	
	private void setCoords(Vector[] vectors)
	{
		for(int count = 0; count < _sides; count++)
		{
			_vertices[count] = vectors[count].getStartCoords();
		}
	}
	
	/**
	 * Returns side lengths A, B and C
	 * @return
	 */
	public Vector[] getVectors()
	{
		return _vectors;
	}
	
	public void rotate(int angle)
	{
		_rotation = angle;
		for(int count = 0; count < _sides; count++)
		{
			_vectors[count].rotate(angle);
		}
	}
	
	public int getAngle()
	{
		return _rotation;
	}
	

}
