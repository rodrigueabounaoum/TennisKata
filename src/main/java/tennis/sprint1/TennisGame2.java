package tennis.sprint1;

import tennis.common.TennisGame;
import tennis.model.TennisPlayer;

/*
	 * tennis game with normal rule ( User Story 2 )
	 */
	public class TennisGame2 implements TennisGame {
		private TennisPlayer player1;
		private TennisPlayer player2;

		public TennisGame2(TennisPlayer player1, TennisPlayer player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		public void winPoint(TennisPlayer player) {
			player.setPlayerGameScore ( player.getPlayerGameScore() + 1 ) ;
		}
		
		public String getScore() {

			if (hasWinner()) {
				return playerWithHighestScore().getPlayerName() + " wins the game";
			}
			
			if (hasAdvantage()) { 
				return "Advantage " + playerWithHighestScore().getPlayerName(); 
			}
			
			if (isDeuce())
				return "Deuce";
			
			if(player1.getPlayerGameScore() == player2.getPlayerGameScore()) {
				return translateScore(player1.getPlayerGameScore()) + " all";
			}
			
			return player1.getPlayerName()+ " : "+translateScore(player1.getPlayerGameScore()) + " , " + player2.getPlayerName()+ " : "+ translateScore(player2.getPlayerGameScore());
		}

		private boolean isDeuce() {
			return player1.getPlayerGameScore() >= 3 && player2.getPlayerGameScore() == player1.getPlayerGameScore();
		}
		
		private TennisPlayer playerWithHighestScore() {
			if (player1.getPlayerGameScore() > player2.getPlayerGameScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		private boolean hasWinner() {
			if(player2.getPlayerGameScore() >= 4 && player2.getPlayerGameScore() >= player1.getPlayerGameScore() + 2 )
				return true;
			if(player1.getPlayerGameScore() >= 4 && player1.getPlayerGameScore() >= player2.getPlayerGameScore() + 2)
				return true;
			return false;
		}
		
		private boolean hasAdvantage() {
			if (player2.getPlayerGameScore() >= 4 && player2.getPlayerGameScore() == player1.getPlayerGameScore() + 1)
				return true;
			if (player1.getPlayerGameScore() >= 4 && player1.getPlayerGameScore() == player2.getPlayerGameScore() + 1)
				return true;
			
			return false;

		}

		private String translateScore(int score) {
			switch (score) {
			case 3:
				return "40";
			case 2:
				return "30";
			case 1: 
				return "15";
			case 0:
				return "0";
			}
			throw new IllegalArgumentException("Illegal score: " + score);
		}
	}
