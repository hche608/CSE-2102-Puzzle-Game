package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.shape.Polygon;
import jeff.ini.Ini;
/**
 * Used to create level data and store possible levels.
 * jeff.Ini is made by Jeff Meunier and used with his permission
 * @author Chris_000
 *
 */

public abstract class LoaderFile 
{
	protected Ini _loader;
	protected String _levelFilePath;
	
	public LoaderFile(String name)
	{
		_levelFilePath = name;
	}
	
	public abstract ArrayList<Level> getLevels() throws IOException;
	
	public void setFileName(String newName)
	{
		_levelFilePath = newName;
	}
	
	public String getFirstWord(String string)
	{
		if (string == null || string.equals(""))
		{
			return null;
		}
		int startIndex = 0;
		int endIndex = string.indexOf(" ");
		while (startIndex == endIndex && startIndex < string.length())
		{
			startIndex++;
			endIndex = string.substring(startIndex).indexOf(" ") + startIndex;
		}
		if (startIndex >= string.length())
		{
			return null;
		}
		if (endIndex < 0)
		{
			return string;
		}
		return string.substring(startIndex, endIndex);
	}
	
	public String afterFirstWord(String string)
	{
		if (string == null || string.equals(""))
			return null;
		String firstWord = getFirstWord(string);
		if(firstWord == null || firstWord.equals("") || firstWord.equals(string))
			return null;
		int offset = string.indexOf(firstWord.charAt(0));
		String after = string.substring(firstWord.length() + offset + 1);
		return after;
	}
	
	
}
