package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import application.Data.Player;

public class SaveWriter
{
	private static final String PLAYER = "Player: ";
	private static final String MAXLEVEL = "MaxLevel: ";
	private static final String CURRENTLEVEL = "CurrentLevel: ";
	private static final String SCORE = "Score: ";
	public static void writeSaves(ArrayList<Player> players, String fileName) throws IOException
	{
		PrintWriter write = new PrintWriter(fileName);
		for (Player p : players)
		{
			String writeData = PLAYER + p.getPlayerName();
			write.println(writeData);
			writeData = MAXLEVEL + p.getHighestLevel();
			write.println(writeData);
			writeData = CURRENTLEVEL + p.getCurrentLevel();
			write.println(writeData);
			writeData = SCORE + p.getScore();
			write.println(writeData);
		}
		write.close();
	}

}
