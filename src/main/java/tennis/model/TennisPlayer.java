package tennis.model;

public class TennisPlayer {

	private String playerName;
	private int playerGameScore;
	private int playerSetScore;
	private int playerTieBreakerScore;
	
	 public TennisPlayer (String playerName) {
		 this.playerName = playerName;
	 }
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerGameScore() {
		return playerGameScore;
	}
	public void setPlayerGameScore(int playerGameScore) {
		this.playerGameScore = playerGameScore;
	}
	public int getPlayerSetScore() {
		return playerSetScore;
	}
	public void setPlayerSetScore(int playerSetScore) {
		this.playerSetScore = playerSetScore;
	}
	public int getPlayerTieBreakerScore() {
		return playerTieBreakerScore;
	}
	public void setPlayerTieBreakerScore(int tieBreakerScore) {
		this.playerTieBreakerScore = tieBreakerScore;
	}
	
}
