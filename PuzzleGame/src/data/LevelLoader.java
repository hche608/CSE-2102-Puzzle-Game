package data;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Main;

/**
 * Loads data for Levels from the file
 * 
 * @author Chris_000
 *
 */

public class LevelLoader extends LoaderFile {

	public LevelLoader(String name) {
		super(name);
	}

	/**
	 * Large method that returns the list of levels read from the file
	 * 
	 * @Author Christian
	 */
	@Override
	public ArrayList<Level> getData() throws IOException {
		Scanner s = new Scanner(Main.res.br);
		List<String> lines = new ArrayList<String>();
		while (s.hasNext()) {
			lines.add(s.nextLine());
		}
		s.close();
		ArrayList<Level> levels = new ArrayList<Level>();
		Level currentLevel = new Level();
		for (String currentLine : lines) {
			if (currentLine != null) {

				String firstWord = getFirstWord(currentLine);

				String secondWord = getFirstWord(afterFirstWord(currentLine));

				if (firstWord != null && !secondWord.equals("")) {

					if (firstWord.equalsIgnoreCase("Level:")) {
						currentLevel = new Level();
						currentLevel.setName(secondWord);
						levels.add(currentLevel);
					} else if (firstWord.equalsIgnoreCase("Time:")) {
						int time = Integer.valueOf(secondWord);
						currentLevel.setTime(time);
					} else if (firstWord.equalsIgnoreCase("Polygon:")) {
						String polyInfo = afterFirstWord(currentLine);
						currentLevel.addPolygon(parseToPoly(polyInfo));
					} else {
						System.out
								.println("Problem in save file, bad ID found. Data may be corrupt.");
					}
				}

			}

		}

		return levels;
	}

	/**
	 * Constructs a PolygonWrapper given the string
	 * 
	 * @param polyInfo
	 * @return
	 * @Author Christian
	 */
	private PolygonWrapper parseToPoly(String polyInfo) {
		String ID = null;
		Point2D point = null;
		int rotation = 0;
		PolygonWrapper poly = null;
		if (polyInfo == null) {
			System.out.println("Error, passed an empty polyInfo index");
			System.exit(1);
		}
		while (polyInfo != null && !polyInfo.equals("")) {
			String dataID = getFirstWord(polyInfo);
			String data = getFirstWord(afterFirstWord(polyInfo));
			if (dataID.equalsIgnoreCase("ID:")) {
				ID = data;
			} else if (dataID.equalsIgnoreCase("Coordinate:")) {
				int commaIndex = data.indexOf(",");
				int spaceIndex = data.indexOf(" ");
				if (commaIndex < 0 || spaceIndex >= commaIndex) {
					System.out.println("Bad parse, file may be corrupt");
					System.exit(1);
				}
				double x = Double.parseDouble(data.substring(0, commaIndex));
				double y = Double.parseDouble(data.substring(commaIndex + 1,
						data.length()));
				point = new Coordinate(x, y);
			} else if (dataID.equalsIgnoreCase("Rotation:")) {
				rotation = Integer.parseInt(data);
			}
			polyInfo = afterFirstWord(afterFirstWord(polyInfo));
		}
		poly = new PolygonWrapper(ID, point, rotation);

		return poly;
	}

}
