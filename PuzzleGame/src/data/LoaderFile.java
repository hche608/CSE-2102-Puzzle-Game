package data;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Used to create level data and store possible levels.
 * jeff.Ini is made by Jeff Meunier and used with his permission
 * @author Chris_000
 *
 */

public abstract class LoaderFile
{
	protected String _dataFile;
	
	public LoaderFile(String file)
	{
		_dataFile = file;
	}
	
	
	public void setFileName(String newFile)
	{
		_dataFile = newFile;
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
