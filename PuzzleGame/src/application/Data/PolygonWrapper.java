package application.Data;
/**
 * Made to hold all the data necessary for a new Polygon class instance
 * All variables are public, so getter's aren't really necessary, but they help readability
 * @Author Christian
 */

import java.awt.geom.Point2D;

public class PolygonWrapper
{
	public Point2D _coordinate;
	public double  _rotation;
	public String _name;
	
	public PolygonWrapper(String name, Point2D coord, double rotation)
	{
		_coordinate = coord;
		_rotation = rotation;
		_name = name;
	}
	
	
	public Point2D getCoord()
	{
		return _coordinate;
	}
	
	public double getRotation()
	{
		return _rotation;
	}
	
	public String  getType()
	{
		return _name;
	}
	
	public String toString()
	{
		return "PolyID: " + _name + "  Coordinate: " + _coordinate.toString() + "  Angle: " + _rotation;
	}

}
