package gameBoard;
/**
 * Dynamic map is a class that allows non-square boards to be created
 * Only change is constructor 
 */
import java.awt.Shape;
import java.util.ArrayList;

public class DynamicMap extends Map
{

	public DynamicMap(ArrayList<Shape> shapes, int size) 
	{
		super(size);
		for (int count = 0; count < shapes.size(); count++)
		{
			this.put(shapes.get(count));
		}
	}
	

}
