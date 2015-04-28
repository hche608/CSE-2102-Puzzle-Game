package dataTest;

import java.io.IOException;
import java.util.ArrayList;

import application.Data.Player;
import data.LevelLoader;
import data.SaveWriter;

public class MainTest 
{
	public static void main(String[] args) throws IOException
	{
		Player p1 = new Player("name1", 0, 10);
		Player p2 = new Player("name2", 1230, 12);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		SaveWriter.writeSaves(players, "PlayerSaves.ini");
		System.out.println("Done");
	}

}
