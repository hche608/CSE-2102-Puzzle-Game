package dataTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import data.Level;
import application.Data.Player;
import data.LevelLoader;
import data.PlayerLoader;
import data.PolygonWrapper;
import data.SaveWriter;
import junit.*;

public class MainTest 
{
	/**
	 * Test for player data read
	 * @param args
	 * @throws IOException
	 */
	@Test
	public void saveWriteTester() throws IOException
	{
		Player p1 = new Player("name1", 0, 10);
		Player p2 = new Player("name2", 1230, 12);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		SaveWriter.writeSaves(players, "PlayerSavesTest.ini");
		PlayerLoader loader = new PlayerLoader("PlayerSavesTest.ini");
		ArrayList<Player> loadedPlayers = loader.getData();
		
		for (int i = 0; i < loadedPlayers.size(); i++)
		{
			Player savedPlayer = loadedPlayers.get(i);
			Player actualPlayer = players.get(i);
			String savedName = savedPlayer.getPlayerName();
			String actualName = actualPlayer.getPlayerName();
			int savedScore = savedPlayer.getScore();
			int actualScore = actualPlayer.getScore();
			int savedHighestLvl = savedPlayer.getHighestLevel();
			int actualHighestLvl = actualPlayer.getHighestLevel();
			assertEquals(savedName.equals(actualName), true);
			assertEquals(savedScore, actualScore);
			assertEquals(savedHighestLvl, actualHighestLvl);
			
		}
		
	}
	
	@Test
	public void levelReadTester() throws IOException
	{
		LevelLoader load = new LevelLoader("LevelReadTest.ini");
		ArrayList<Level> levels = load.getData();
		assertEquals(levels.size() > 0, true);
		Level level = levels.get(0);
		assertEquals(level.getName(), "Level1");
		assertEquals(level.getTime(), 45);
		ArrayList<PolygonWrapper> polys = level.getLevelPolys();
		PolygonWrapper poly = polys.get(0);
		assertEquals(poly.getType(), "shape");
		assertEquals((int) poly.getRotation(), 45);
		assertEquals((int) poly.getCoord().getX(), 0);
		assertEquals((int) poly.getCoord().getY(), 0);
		
		
	}

}
