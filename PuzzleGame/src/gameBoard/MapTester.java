package gameBoard;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
public class MapTester 
{
	public static void main(String[] args)
	{
		Map map = new Map(50);
		//assertEquals(false, map.complete());
		BasicTriangle tri = new BasicTriangle(50, 50, 17);
		tri.setCoords(new Coordinate(0,49), new Coordinate(0,0), new Coordinate(49,49));
		map.put(tri);
		map.printState();
		//assertEquals(true, map.put(null));
		//assertEquals(true, map.take(null));
		//assertEquals(true, map.complete());
	}
}
