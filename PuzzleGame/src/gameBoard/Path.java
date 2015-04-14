package gameBoard;

public class Path 
{
	private double _slope, _xCurrent, _yCurrent, _stepSize;
	private Coordinate _start, _end;
	
	public Path(Coordinate start, Coordinate end)
	{
		_start = start;
		_end = end;
		_xCurrent = start.getX();
		_yCurrent = start.getY();
		if (_end.getX() != _xCurrent && _end.getY() != _yCurrent)
		{
			_slope = (_end.getY()-_yCurrent)/(_end.getX() - _xCurrent);
			_stepSize = 1/_slope;
			if (_stepSize > 1)
			{
				_stepSize = 1;
			}
		}
		else
		{
			_slope = 0;
			_stepSize = 1;
		}
		
	}
	
	public boolean hasNext()
	{
		return !_end.isEqual(new Coordinate((int)_xCurrent, (int)_yCurrent));
	}
	
	public void move()
	{
		if (_slope != 0)
		{
			_xCurrent += _stepSize;
			_yCurrent += _slope*_stepSize;
		}
		
		else if (_end.getX() == _start.getX())
		{
			if (_end.getY() > _start.getY())
			{
				_yCurrent++;
			}
			else
			{
				_yCurrent--;
			}			
		}
		else
		{
			if (_end.getX() > _start.getX())
			{
				_xCurrent++;
			}
			else
			{
				_xCurrent--;
			}
		}		
	}
	
	public Coordinate getLoc()
	{
		return new Coordinate((int) _xCurrent,(int) _yCurrent);
	}
}
