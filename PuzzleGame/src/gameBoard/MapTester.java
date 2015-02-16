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
		Map map = new Map(null, 50);
		assertEquals(false, map.complete());
		assertEquals(true, map.put(null));
		assertEquals(true, map.take(null));
		map.fill();
		assertEquals(true, map.complete());
	}
}
