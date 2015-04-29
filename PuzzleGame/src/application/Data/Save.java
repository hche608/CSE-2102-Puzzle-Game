package application.Data;




public interface Save 
{
	public int getLevel();
	public int getScore();
	public String getPlayerName();
	public void updateSave(int score, int level);
	public Player getPlayer();
}