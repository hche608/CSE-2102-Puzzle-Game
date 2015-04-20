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

	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
		this.level_num = 1;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setLevel(int level_num) {
		this.level_num = level_num;
	}

	public int getLevel() {
		return level_num;
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
}
