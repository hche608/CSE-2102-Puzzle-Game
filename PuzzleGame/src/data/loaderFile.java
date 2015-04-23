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

public abstract class loaderFile 
{
	protected Ini _loader;
	protected String _levelFile;
	
	public loaderFile(String name)
	{
		_levelFile = name;
	}
	
	public abstract ArrayList<Level> getLevels() throws IOException;
	
	public void setFileName(String newName)
	{
		_levelFile = newName;
	}
	
	protected String getFirstWord(String string)
	{
		if (string == null | string.equals(""))
		{
			return null;
		}
		int startIndex = 0;
		int endIndex = string.indexOf(" ");
		if(endIndex == -1)
		{
			return string;
		}
		while (startIndex == endIndex && startIndex != string.length())
		{
			startIndex++;
			endIndex = string.substring(startIndex).indexOf(" ");
		}
		if (startIndex != string.length())
		{
			return null;
		}
		return string.substring(startIndex, endIndex);
	}
	
	protected String afterFirstWord(String string)
	{
		String firstWord = getFirstWord(string);
		if(firstWord == null)
			return null;
		String after = string.substring(firstWord.length() + 1);
		return after;
	}
	
	
}
