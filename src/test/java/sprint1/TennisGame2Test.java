package sprint1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tennis.model.TennisPlayer;
import tennis.sprint1.TennisGame2;

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
	
	//Testing equal scores
	@Test
	public void PlayersScoreEqual() {
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		assertEquals("15 all", tennisGame2.getScore());
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		assertEquals("30 all", tennisGame2.getScore());
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
		assertEquals("Deuce", tennisGame2.getScore());
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
		assertEquals("Advantage Rodrigue2", tennisGame2.getScore());

	}

	//Testing player 1 straight game win
	@Test
	public void Player1Win() {
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 wins the game", tennisGame2.getScore());
	}

	//Testing player 2 straight game win
	@Test
	public void Player2Win() {
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		assertEquals("Rodrigue2 wins the game", tennisGame2.getScore());
	}
	
	//Testing score reveal
	@Test
	public void RevealScores() {
		tennisGame2.winPoint(player2);
		assertEquals("Rodrigue1 : 0 , Rodrigue2 : 15", tennisGame2.getScore());
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 : 15 , Rodrigue2 : 30", tennisGame2.getScore());
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 : 30 , Rodrigue2 : 40", tennisGame2.getScore());
	}
	

	//Testing player 1 winning by deuce - advantage - win
	@Test
	public void Should_GetDeuce_Advantage_Win() {
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		assertEquals("Deuce", tennisGame2.getScore());
		
		tennisGame2.winPoint(player1);
		assertEquals("Advantage Rodrigue1", tennisGame2.getScore());
		
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 wins the game", tennisGame2.getScore());
	}
	
	//Testing player 1 winning by deuce - advantage - deuce - advantage - win
	@Test
	public void GetDeuce_Advantage_Deuce_Advantage_Win() {
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);

		assertEquals("Deuce", tennisGame2.getScore());
		
		tennisGame2.winPoint(player1);
		assertEquals("Advantage Rodrigue1", tennisGame2.getScore());
		
		tennisGame2.winPoint(player2);
		assertEquals("Deuce", tennisGame2.getScore());
		
		tennisGame2.winPoint(player1);
		assertEquals("Advantage Rodrigue1", tennisGame2.getScore());
		
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 wins the game", tennisGame2.getScore());
	}
	

	
}
