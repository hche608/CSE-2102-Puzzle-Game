package data;


import application.Player;


public interface Save 
{
	public int getLevel();
	public int getScore();
	public String getPlayerName();
	public String getSaveName();
	public void updateSave(int score, int level);
	public Player getPlayer();
}