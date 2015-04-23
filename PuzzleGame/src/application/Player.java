	/**
	 * This class uses to store players' info
	 * 
	 * @author hche608
	 * 
	 */
package application;

public class Player {
	private String playerName;
	private int score;
	private int level_num;

	public Player() {
		this.playerName = "Alex";
		this.score = 0;
		this.level_num = 1;
	}
	/**
	 * Creates player with a given name
	 * @param playerName
	 */

	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
		this.level_num = 1;
	}
	
	/**
	 * Creates player with given name, score and max level
	 * @param playerName, score, maxLevel
	 * @Author Christian
	 */
	public Player(String playerName, int score, int maxLevel)
	{
		this.playerName = playerName;
		this.score = score;
		this.level_num = maxLevel;
	}
	
	/**
	 * Increments given score to player's total.
	 * @param score
	 * @Author Christian
	 */
	
	public void updateScore(int score)
	{
		this.score += score;
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}

	public void setLevel(int level_num) {
		this.level_num = level_num;
	}

	public int getLevel() {
		return this.level_num;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return this.score;
	}

	public String getPlayerName() {
		return this.playerName;
	}
}
