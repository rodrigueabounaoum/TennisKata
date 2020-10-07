package sprint1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tennis.model.TennisPlayer;
import tennis.sprint1.TennisGame1;

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
	
	@Test
	public void Should_Players_Score_Be_Equal() {
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("15 all", tennisGame1.getScore());
	}

	@Test
	public void Should_Player1_Win() {
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Rodrigue1 wins the game", tennisGame1.getScore());
	}

	@Test
	public void Should_Player2Win() {
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Rodrigue2 wins the game", tennisGame1.getScore());
	}
	
	@Test
	public void Should_Reveal_Scores() {
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Rodrigue1 : 15 , Rodrigue2 : 30", tennisGame1.getScore());
	}
	
}
