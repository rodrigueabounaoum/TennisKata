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
	
	@Test
	public void Should_Players_Score_Be_Equal() {
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2); 
		assertEquals("15 all", tennisGame2.getScore());
	}

	@Test
	public void Should_Player1_Win() {
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		assertEquals("Rodrigue1 wins the game", tennisGame2.getScore());
	}

	@Test
	public void Should_Player2Win() {
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player1);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);

		assertEquals("Rodrigue2 wins the game", tennisGame2.getScore());
	}
	
	@Test
	public void Should_Reveal_Scores() {
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player2);
		tennisGame2.winPoint(player1);

		assertEquals("Rodrigue1 : 15 , Rodrigue2 : 30", tennisGame2.getScore());
	}
	
	@Test
	public void Should_GetDeuce_Advantage_Deuce() {
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
	}
	

	
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
	
}
