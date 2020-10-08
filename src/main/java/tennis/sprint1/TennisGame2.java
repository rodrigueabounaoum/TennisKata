package tennis.sprint1;

import tennis.common.TennisGame;
import tennis.model.TennisPlayer;

/*
	 * tennis game with normal rule ( User Story 2 )
	 */
	public class TennisGame2 implements TennisGame {
		private TennisPlayer player1;
		private TennisPlayer player2;

		//Defining the two players
		public TennisGame2(TennisPlayer player1, TennisPlayer player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		//Scoring a point : add 1 to the game score
		public void winPoint(TennisPlayer player) {
			player.setPlayerGameScore ( player.getPlayerGameScore() + 1 ) ;
		}
		
		//Displaying the scores
		public String getScore() {

			//If the game has a winner , declare the winner by revealing the player with the highest score
			if (hasWinner()) {
				return playerWithHighestScore().getPlayerName() + " wins the game";
			}
			
			//If the game has a player with an advantage, display its name ( which will be the player with the highest score)
			if (hasAdvantage()) { 
				return "Advantage " + playerWithHighestScore().getPlayerName(); 
			}
			
			//If the game gone into deuce
			if (isDeuce())
				return "Deuce";
			
			//If the scores are even , declare the score for all
			if(player1.getPlayerGameScore() == player2.getPlayerGameScore()) {
				return translateScore(player1.getPlayerGameScore()) + " all";
			}
			
			//If non of the above reveal the scores
			return player1.getPlayerName()+ " : "+translateScore(player1.getPlayerGameScore()) + " , " + player2.getPlayerName()+ " : "+ translateScore(player2.getPlayerGameScore());
		}

		//Returns boolean to determine if the game gone to Deuce
		private boolean isDeuce() {
			return player1.getPlayerGameScore() >= 3 && player2.getPlayerGameScore() == player1.getPlayerGameScore();
		}
		
		//Reveal which player has the highest game score
		private TennisPlayer playerWithHighestScore() {
			if (player1.getPlayerGameScore() > player2.getPlayerGameScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		//Returns boolean to determine if the game has a winner
		private boolean hasWinner() {
			if(player2.getPlayerGameScore() >= 4 && player2.getPlayerGameScore() >= player1.getPlayerGameScore() + 2 )
				return true;
			if(player1.getPlayerGameScore() >= 4 && player1.getPlayerGameScore() >= player2.getPlayerGameScore() + 2)
				return true;
			return false;
		}
		
		//Returns boolean to determine if a player got the advantage in the game
		private boolean hasAdvantage() {
			if (player2.getPlayerGameScore() >= 4 && player2.getPlayerGameScore() == player1.getPlayerGameScore() + 1)
				return true;
			if (player1.getPlayerGameScore() >= 4 && player1.getPlayerGameScore() == player2.getPlayerGameScore() + 1)
				return true;
			
			return false;

		}

		//Translating number of points into tennis game scores
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
