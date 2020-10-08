package sprint2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tennis.model.TennisPlayer;
import tennis.sprint2.TennisGame2;

public class TennisGame2Test {

	private TennisGame2 tennisGame2;
	private TennisPlayer player1;
	private TennisPlayer player2;
	
	@Before
	public void Initialise_Each_Test() {
		player1 = new TennisPlayer ("Rodrigue1") ;
		player2 = new TennisPlayer ("Rodrigue2") ;
		tennisGame2 = new TennisGame2(player1 , player2) ;
	}
	
	
	@Test
	public void GetTieBreaker_Scores() {
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);

		assertEquals("Set Score -> 6 all | Tie Breaker Score -> Rodrigue1 : 3 , Rodrigue2 : 1", tennisGame2.getScore());
	}
	
	@Test
	public void Win_Via_TieBreaker() {
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
 
		assertEquals("Set Score -> Rodrigue1 wins the set", tennisGame2.getScore());
	}
	
	@Test
	public void Win_Via_Extended_TieBreaker() {
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		gameWin(player2);
		
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);

		assertEquals("Set Score -> 6 all | Tie Breaker Score -> Rodrigue1 : 7 , Rodrigue2 : 6", tennisGame2.getScore());
	    
		tennisGame2.winPoint(player1);
		assertEquals("Set Score -> Rodrigue1 wins the set", tennisGame2.getScore());
	}
	

	
	//Testing equal scores
		@Test
		public void PlayersScoreEqual() {
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> 15 all", tennisGame2.getScore());
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> 30 all", tennisGame2.getScore());
		}
		
		//Testing deuce
		@Test
		public void Deuce() {
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame2.getScore());
		}
		
		//Testing advantage player 2
		@Test
		public void Player2Advantage() {
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player2.getPlayerName() +"", tennisGame2.getScore());

		}
		
		//Testing player 1 straight first game win
		@Test
		public void Player1WinFirstGame() {
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame2.getScore());
		}
		
		//Testing player 1 third game straight win
		@Test
		public void Player1WinThirdGame() {
			gameWin(player1);
			gameWin(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 2 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame2.getScore());
		}

		//Testing player 2 straight first game win
		@Test
		public void Player2WinFirstGame() {
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame2.getScore());
		}
		
		//Testing player 2 third game straight win
		@Test
		public void Player2WinThirdGame() {
			gameWin(player1);
			gameWin(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 2 | Game Score -> 0 all", tennisGame2.getScore());
		}
		
		//Testing score reveal of a simulated match
		@Test
		public void TestGameSimulationScores() {
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 15", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 15 , "+ player2.getPlayerName() +" : 30", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 30 , "+ player2.getPlayerName() +" : 40", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> "+ player1.getPlayerName() +" : 15 , "+ player2.getPlayerName() +" : 30", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Deuce", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Deuce", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 1 all | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player2);
			gameWin(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 3 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" wins the set", tennisGame2.getScore());
		}
		
		//Testing score reveal of a extended simulated match
		@Test
		public void TestExtendedGameSimulationScores() {
			
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 5 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> 5 all | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player2);

			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 6 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);

			assertEquals("Set Score -> 6 all | Tie Breaker Score -> 0 all", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);

			assertEquals("Set Score -> 6 all | Tie Breaker Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);

			
			
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 6 all | Tie Breaker Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 2", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			
			assertEquals("Set Score -> "+ player1.getPlayerName() +" wins the set", tennisGame2.getScore());
		}
		
		//Testing score reveal of a extended simulated match
		@Test
		public void TestExtendedGameTieBreakSimulationScores() {
			
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 5 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> 5 all | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player2);

			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 6 | Game Score -> 0 all", tennisGame2.getScore());
			
			gameWin(player1);

			assertEquals("Set Score -> 6 all | Tie Breaker Score -> 0 all", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);

			assertEquals("Set Score -> 6 all | Tie Breaker Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 6 all | Tie Breaker Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 0", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 6 all | Tie Breaker Score -> "+ player1.getPlayerName() +" : 7 , "+ player2.getPlayerName() +" : 6", tennisGame2.getScore());
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" wins the set", tennisGame2.getScore());
		}
		
		

		//Testing player 1 winning game by deuce - advantage - win
		@Test
		public void GetDeuceAdvantageWin() {
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame2.getScore());
		}
		
		
		
		//Testing player 1 winning game by deuce - advantage - deuce - advantage - win
		@Test
		public void GetDeuce_Advantage_Deuce_Advantage_Win() {
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player2);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);
			tennisGame2.winPoint(player1);

			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame2.getScore());
			
			tennisGame2.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame2.getScore());
			
			tennisGame2.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame2.getScore());
		}
		
		//Simulating a game win
		public void gameWin(TennisPlayer player) {
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
	}
	
}
