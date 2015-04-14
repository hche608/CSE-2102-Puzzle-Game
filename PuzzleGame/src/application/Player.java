package application;

public class Player {
	private String playerName;
	private int score;

	public Player() {
		this.playerName = "Alex";
		this.score = 0;
	}

	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
	}

	public void setScore(int score) {
		this.score = score;
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
