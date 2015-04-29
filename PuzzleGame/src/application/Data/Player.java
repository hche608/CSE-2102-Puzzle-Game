/**
 * This class uses to store players' info
 * 
 * @author hche608
 * 
 */
package application.Data;

public class Player {
	private String playerName;
	private int score;
	private int current_level_num;
	private int highest_level_num;

	public Player() {
		this.playerName = "Alex";
		this.score = 0;
		this.current_level_num = 1;
		this.highest_level_num = 1;
	}

	public Player(String playerName) {
		if (playerName.length() >= 6)
			playerName = playerName.substring(0, 5);
		this.playerName = playerName;
		this.score = 0;
		this.current_level_num = 1;
		this.highest_level_num = 1;
	}
	
	public Player(String playerName, int score, int current_level_num) {
		this.playerName = playerName;
		this.score = score;
		this.current_level_num = current_level_num;
		this.highest_level_num = current_level_num;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public void setCurrentLevel(int current_level_num) {
		this.current_level_num = current_level_num;
	}

	public int getCurrentLevel() {
		return current_level_num;
	}

	public void setHighestLevel(int highest_level_num) {
		this.highest_level_num = highest_level_num;
	}

	public int getHighestLevel() {
		return highest_level_num;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public String getPlayerName() {
		return playerName;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", score=" + score
				+ ", current_level_num=" + current_level_num
				+ ", highest_level_num=" + highest_level_num + "]";
	}
}
