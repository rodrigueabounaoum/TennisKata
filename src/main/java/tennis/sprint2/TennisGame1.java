package tennis.sprint2;

import tennis.common.TennisGame;
import tennis.model.TennisPlayer;

/*
	 * tennis game with normal rule ( User Story 2 )
	 */
	public class TennisGame1 implements TennisGame {
		private TennisPlayer player1;
		private TennisPlayer player2;

		//Defining the two players
		public TennisGame1(TennisPlayer player1, TennisPlayer player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		//Scoring a point
		public void winPoint(TennisPlayer player) {
			//Add a game point to the player
			player.setPlayerGameScore ( player.getPlayerGameScore() + 1 ) ;
			
			//If the game has a winner, increment his set score by 1
			//Reset the game scores for both players to 0
			if (hasGameWinner()) {
				playerWithHighestGameScore().setPlayerSetScore(playerWithHighestGameScore().getPlayerSetScore() +1 );
				player1.setPlayerGameScore(0);
				player2.setPlayerGameScore(0);
			}
			
		}
		
		//Displaying the whole Scores
		public String getScore() {
			String scoreString = "" ; 
			scoreString +=  "Set Score -> " +getSetScore();
			
			//If the set already has winner , no need to display the game score
			if (!hasSetWinner()) { 
				scoreString += " | " +"Game Score -> " + getGameScore(); 
			}
			return scoreString ; 
		}
		
		//Displaying the game scores
		public String getGameScore() {
			
			//If the game has a player with an advantage, display its name ( which will be the player with the highest score)
			if (hasAdvantage()) 
				return "Advantage " + playerWithHighestGameScore().getPlayerName(); 
			
			//If the game gone into deuce
			if (isDeuce())
				return "Deuce";
			
			//If the game scores are even , declare the score for all
			if(player1.getPlayerGameScore() == player2.getPlayerGameScore()) 
				return translateScore(player1.getPlayerGameScore()) + " all";
			
			//If non of the above reveal the game scores
			return player1.getPlayerName()+ " : "+translateScore(player1.getPlayerGameScore()) + " , " + player2.getPlayerName()+ " : "+ translateScore(player2.getPlayerGameScore());
		}
		
		//Displaying the set scores
		public String getSetScore() {

			//If the set has a winner , declare the winner by revealing the player with the highest set score
			if (hasSetWinner()) {
				return playerWithHighestSetScore().getPlayerName() + " wins the set";
			}
			
			//If the set scores are even , declare the set score for all
			if(player1.getPlayerSetScore() == player2.getPlayerSetScore()) {
				return player1.getPlayerSetScore() + " all";
			}
			
			//If non of the above reveal the set scores
			return player1.getPlayerName()+ " : "+player1.getPlayerSetScore() + " , " + player2.getPlayerName()+ " : "+ player2.getPlayerSetScore();
		}

		//Reveal which player has the highest set score
		private TennisPlayer playerWithHighestSetScore() {
			if (player1.getPlayerSetScore() > player2.getPlayerSetScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		//Reveal which player has the highest game score
		private TennisPlayer playerWithHighestGameScore() {
			if (player1.getPlayerGameScore() > player2.getPlayerGameScore()) {
				return player1;
			} else {
				return player2;
			}
		}
		
		//Returns boolean to determine if the set has a winner
		private boolean hasSetWinner() {
			if(player2.getPlayerSetScore() >= 6 && player2.getPlayerSetScore() >= player1.getPlayerSetScore() + 2 )
				return true;
			if(player1.getPlayerSetScore() >= 6 && player1.getPlayerSetScore() >= player2.getPlayerSetScore() + 2 )
				return true;
			return false;
		}
		
		//Returns boolean to determine if the game has a winner
		private boolean hasGameWinner() {
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

		//Returns boolean to determine if the game gone to Deuce
		private boolean isDeuce() {
			return player1.getPlayerGameScore() >= 3 && player2.getPlayerGameScore() == player1.getPlayerGameScore();
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
