package tennis.sprint2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tennis.model.TennisPlayer;
import tennis.sprint2.TennisGame1;

public class TennisGame1Test {

	private TennisGame1 tennisGame1;
	private TennisPlayer player1;
	private TennisPlayer player2;
	
	@Before
	public void Initialise_Each_Test() {
		player1 = new TennisPlayer ("Rodrigue1") ;
		player2 = new TennisPlayer ("Rodrigue2") ;
		tennisGame1 = new TennisGame1(player1 , player2) ;
	}
	
	//Testing equal scores
		@Test
		public void PlayersScoreEqual() {
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> 15 all", tennisGame1.getScore());
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> 30 all", tennisGame1.getScore());
		}
		
		//Testing deuce
		@Test
		public void Deuce() {
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
		}
		
		//Testing advantage player 2
		@Test
		public void Player2Advantage() {
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player2.getPlayerName() +"", tennisGame1.getScore());

		}
		
		//Testing player 1 straight first game win
		@Test
		public void Player1WinFirstGame() {
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame1.getScore());
		}
		
		//Testing player 1 third game straight win
		@Test
		public void Player1WinThirdGame() {
			gameWin(player1);
			gameWin(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 2 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame1.getScore());
		}

		//Testing player 2 straight first game win
		@Test
		public void Player2WinFirstGame() {
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame1.getScore());
		}
		
		//Testing player 2 third game straight win
		@Test
		public void Player2WinThirdGame() {
			gameWin(player1);
			gameWin(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 2 | Game Score -> 0 all", tennisGame1.getScore());
		}
		
		//Testing score reveal of a simulated match
		@Test
		public void TestGameSimulationScores() {
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 15", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 15 , "+ player2.getPlayerName() +" : 30", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> "+ player1.getPlayerName() +" : 30 , "+ player2.getPlayerName() +" : 40", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> "+ player1.getPlayerName() +" : 15 , "+ player2.getPlayerName() +" : 30", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Deuce", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Deuce", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 0 , "+ player2.getPlayerName() +" : 1 | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 1 all | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 1 | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player2);
			gameWin(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 3 | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" wins the set", tennisGame1.getScore());
		}
		
		//Testing score reveal of a simulated match
		@Test
		public void TestExtendedGameSimulationScores() {
			
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			gameWin(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			gameWin(player2);
			
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 4 , "+ player2.getPlayerName() +" : 5 | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> 5 all | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player2);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 5 , "+ player2.getPlayerName() +" : 6 | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player1);
			assertEquals("Set Score -> 6 all | Game Score -> 0 all", tennisGame1.getScore());
			
			gameWin(player2);
			assertEquals("Set Score -> "+ player2.getPlayerName() +" wins the set", tennisGame1.getScore());


		}
		
		

		//Testing player 1 winning game by deuce - advantage - win
		@Test
		public void GetDeuceAdvantageWin() {
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame1.getScore());
		}
		
		//Testing player 1 winning game by deuce - advantage - deuce - advantage - win
		@Test
		public void GetDeuce_Advantage_Deuce_Advantage_Win() {
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player2);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);
			tennisGame1.winPoint(player1);

			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame1.getScore());
			
			tennisGame1.winPoint(player2);
			assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> 0 all | Game Score -> Advantage "+ player1.getPlayerName() +"", tennisGame1.getScore());
			
			tennisGame1.winPoint(player1);
			assertEquals("Set Score -> "+ player1.getPlayerName() +" : 1 , "+ player2.getPlayerName() +" : 0 | Game Score -> 0 all", tennisGame1.getScore());
		}
		
	public void gameWin(TennisPlayer player) {
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
	}
}
