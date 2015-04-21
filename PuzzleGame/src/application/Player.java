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
	private int current_level_num;
	private int highest_level_num;

	public Player() {
		this.playerName = "Alex";
		this.score = 0;
		this.current_level_num = 1;
		this.highest_level_num = 1;
	}

	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
		this.current_level_num = 1;
		this.highest_level_num = 1;
	}

	public void setScore(int score) {
		this.score = score + score;
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
