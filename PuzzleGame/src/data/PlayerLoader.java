package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Main;
import application.Data.Player;

public class PlayerLoader extends LoaderFile
{
	private final String PLAYER = "Player:";
	private final String MAXLEVEL = "MaxLevel:";
	private final String CURRENTLEVEL = "CurrentLevel:";
	private final String SCORE = "Score:";

	public PlayerLoader(String file) {
		super(file);
	}

	
	public ArrayList<Player> getData() throws IOException {
		Scanner s = new Scanner(Main.res.br);
		List<String> lines = new ArrayList<String>();
		while (s.hasNext()) {
			lines.add(s.nextLine());
		}
		s.close();
		ArrayList<Player> saves = new ArrayList<Player>();
		Player player = new Player();
		for (String currentLine : lines) {
			if (currentLine != null) {

				String firstWord = getFirstWord(currentLine);

				String secondWord = getFirstWord(afterFirstWord(currentLine));

				if (firstWord != null && !secondWord.equals("")) {

					if (firstWord.equalsIgnoreCase(PLAYER)) {
						player = new Player();
						player.setPlayerName(secondWord);
						saves.add(player);
					} else if (firstWord.equalsIgnoreCase(MAXLEVEL)) {
						int max = Integer.valueOf(secondWord);
						player.setHighestLevel(max);
					} else if (firstWord.equalsIgnoreCase(CURRENTLEVEL)) {
						int currentLevel = Integer.valueOf(secondWord);
						player.setCurrentLevel(currentLevel);
					} 
					else if (firstWord.equalsIgnoreCase(SCORE))
					{
						int score = Integer.valueOf(secondWord);
						player.setScore(score);
					}
					else {
						System.out
								.println("Problem in save file, bad ID found. Data may be corrupt.");
					}
				}

			}

		}

		return saves;
	}
	
}
