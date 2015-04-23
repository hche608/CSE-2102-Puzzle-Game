package data;

import java.awt.geom.Point2D;


public class Coordinate extends Point2D
{
	public double x, y;
	
	public Coordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
		
	}

}
