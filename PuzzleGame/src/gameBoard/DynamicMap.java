package gameBoard;

import java.awt.Shape;
import java.util.ArrayList;

public class DynamicMap extends Map
{

	public DynamicMap(ArrayList<Shape> shapes, int size) {
		super(size);
		for(int i = 0; i < shapes.size(); i++)
		{
			super.put(shapes.get(i));
		}
	}

}
