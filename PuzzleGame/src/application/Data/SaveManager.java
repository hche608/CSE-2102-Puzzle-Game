package application.Data;

import java.io.File;
import java.util.ArrayList;

import jeff.ini.Ini;

public class SaveManager 
{
	public ArrayList<Save> _saves;
	public File _saveFile;
	public Ini _saveInfo;
	
	public SaveManager (String fileName)
	{
		_saveFile = new File (fileName);
		_saveInfo = new Ini (_saveFile);
	}
	
	public SaveManager()
	{
		this("Saves");
	}
	
	public void setup()
	{
		for(String saveID: _saveInfo.keys("saves"))
		{
			
		}
	}
}
