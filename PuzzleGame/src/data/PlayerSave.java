package data;
/**
 * Used to create and describe player saves
 * @Author Christian Kuntz
 */


import application.Player;

public class PlayerSave implements Save
{
	private String _saveName, _playerName;
	private int _score, _level;
	
	public PlayerSave(String saveName, String playerName, int score, int level)
	{
		_saveName = saveName;
		_playerName = playerName;
		_score = score;
		_level = level;
	}
	
	public PlayerSave(String saveName, String playerName)
	{
		_saveName = saveName;
		_playerName = playerName;
		_score = 0;
		_level = 1;
	}

	@Override
	public int getLevel() {

		return _level;
	}

	@Override
	public int getScore() {

		return _score;
	}

	@Override
	public void updateSave(int score, int level) {
		_score = score;
		_level = level;
		
	}

	@Override
	public Player getPlayer() {
		return new Player(_playerName, _score, _level);
	}

	@Override
	public String getPlayerName() {
		return _playerName;
	}

	@Override
	public String getSaveName() {
		return _saveName;
	}
	
}
