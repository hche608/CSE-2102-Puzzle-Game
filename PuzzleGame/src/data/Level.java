package data;

import java.util.ArrayList;

public class Level
{
	private ArrayList<PolygonWrapper> _polyData;
	private int _time;
	private String _name;
	
	public Level(ArrayList<PolygonWrapper> data, String name, int time)
	{
		_polyData = data;
		_time = time;
		_name = name;
	}
	
	public Level()
	{
		_polyData = new ArrayList<PolygonWrapper>();
		
	}
	/**
	 * Adds a new polygon to the array
	 * @param poly
	 */
	public void addPolygon(PolygonWrapper poly)
	{
		if(_polyData.size() > 7)
			return;
		_polyData.add(poly);
	}
	
	public void setTime(int time)
	{
		_time = time;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public ArrayList<PolygonWrapper> getLevelPolys()
	{
		return _polyData;
	}
	
	public int getTime()
	{
		return _time;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String toString()
	{
		String returnThis = "Level: " + _name + "\n";
		for (int n = 0; n < _polyData.size(); n++)
		{
			PolygonWrapper poly = _polyData.get(n);
			if(poly != null)
				returnThis += "Polygon " + n + "  " + _polyData.toString() + "\n";
		}
		returnThis += "Level Length: " + _time + "s";
		return returnThis;
	}
}
