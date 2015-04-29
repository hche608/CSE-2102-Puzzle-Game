package data;
/**
 * Used to create and describe player saves
 * @Author Christian Kuntz
 */


import application.Data.Player;

class PlayerSave implements Save
{
	private String _playerName;
	private int _score, _maxLevel, _currentLevel;
	
	public PlayerSave( String playerName, int score, int levelMax, int currentLevel)
	{
		_playerName = playerName;
		_score = score;
		_maxLevel = levelMax;
		_currentLevel = currentLevel;
	}
	
	public PlayerSave(String playerName)
	{
		_playerName = playerName;
		_score = 0;
		_maxLevel = 1;
		_currentLevel = 1;
	}
	
	public PlayerSave()
	{
		
	}

	@Override
	public int getLevel() {

		return _currentLevel;
	}

	@Override
	public int getScore() {

		return _score;
	}

	@Override
	public void updateSave(int score, int level) {
		_score = score;
		_maxLevel = level;
		
	}

	@Override
	public Player getPlayer() {
		Player p = new Player(_playerName, _score, _currentLevel);
		p.setHighestLevel(_maxLevel);
		return p;
	}

	@Override
	public String getPlayerName() {
		return _playerName;
	}

	public void setName(String name) 
	{
		_playerName = name;		
	}
	
	public void setMaxLevel(int level)
	{
		_maxLevel = level;
	}

	public void setCurrentLevel(int level)
	{
		_currentLevel = level;
	}

	public void setScore(int score) 
	{
		_score = score;		
	}
	
	
}
