package tennis.sprint2;

import tennis.common.TennisGame;
import tennis.model.TennisPlayer;

/*
	 * tennis game with normal rule ( User Story 2 )
	 */
	public class TennisGame1 implements TennisGame {
		private TennisPlayer player1;
		private TennisPlayer player2;

		public TennisGame1(TennisPlayer player1, TennisPlayer player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		public void winPoint(TennisPlayer player) {
			player.setPlayerGameScore ( player.getPlayerGameScore() + 1 ) ;
			
			if (hasGameWinner()) {
				playerWithHighestGameScore().setPlayerSetScore(playerWithHighestGameScore().getPlayerSetScore() +1 );
				player1.setPlayerGameScore(0);
				player2.setPlayerGameScore(0);
			}
			
		}
		
		public String getScore() {
			String scoreString = "" ; 
			scoreString +=  "Set Score -> " +getSetScore();
			if (!hasSetWinner()) { 
				scoreString += " | " +"Game Score -> " + getGameScore(); 
			}
			return scoreString ; 
		}
		
		public String getGameScore() {
			
			if (hasAdvantage()) 
				return "Advantage " + playerWithHighestGameScore().getPlayerName(); 
			
			if (isDeuce())
				return "Deuce";
			
			if(player1.getPlayerGameScore() == player2.getPlayerGameScore()) 
				return translateScore(player1.getPlayerGameScore()) + " all";
			
			return player1.getPlayerName()+ " : "+translateScore(player1.getPlayerGameScore()) + " , " + player2.getPlayerName()+ " : "+ translateScore(player2.getPlayerGameScore());
		}
		
		public String getSetScore() {

			if (hasSetWinner()) {
				return playerWithHighestSetScore().getPlayerName() + " wins the set";
			}
			
			if(player1.getPlayerSetScore() == player2.getPlayerSetScore()) {
				return player1.getPlayerSetScore() + " all";
			}
			
			return player1.getPlayerName()+ " : "+player1.getPlayerSetScore() + " , " + player2.getPlayerName()+ " : "+ player2.getPlayerSetScore();
		}

		private TennisPlayer playerWithHighestSetScore() {
			if (player1.getPlayerSetScore() > player2.getPlayerSetScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		private TennisPlayer playerWithHighestGameScore() {
			if (player1.getPlayerGameScore() > player2.getPlayerGameScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		private boolean hasSetWinner() {
			if(player2.getPlayerSetScore() >= 6 && player2.getPlayerSetScore() >= player1.getPlayerSetScore() + 2 )
				return true;
			if(player1.getPlayerSetScore() >= 6 && player1.getPlayerSetScore() >= player2.getPlayerSetScore() + 2 )
				return true;
			return false;
		}
		
		private boolean hasGameWinner() {
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

		private boolean isDeuce() {
			return player1.getPlayerGameScore() >= 3 && player2.getPlayerGameScore() == player1.getPlayerGameScore();
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
