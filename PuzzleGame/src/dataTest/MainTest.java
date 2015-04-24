package dataTest;

import java.io.IOException;

import data.LevelLoader;

public class MainTest 
{
	public static void main(String[] args) throws IOException
	{
		LevelLoader load = new LevelLoader("C:\\Users\\Chris_000\\Desktop\\LevelInfo.ini");
	//	String parseThis = "  FirstWord   Rest  of   phrase";
	//	System.out.println(load.getFirstWord(parseThis));
		//System.out.println(load.afterFirstWord(parseThis));
	//	System.out.println(load.getFirstWord(load.afterFirstWord(parseThis)));
		System.out.println(load.getLevels());
	}

}
