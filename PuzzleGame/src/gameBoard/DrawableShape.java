package gameBoard;

public interface DrawableShape
{
	public Vector[] getVectors();
	
	public Coordinate[] getVertices();
	
	/**
	 * Unique value associated with this object, from 1-7.
	 * @return
	 */
	public int getValue();

}
