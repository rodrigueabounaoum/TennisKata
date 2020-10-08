package tennis.sprint1;

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
	
	//Testing equal scores
	@Test
	public void PlayersScoreEqual() {
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		assertEquals("15 all", tennisGame1.getScore());
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		assertEquals("30 all", tennisGame1.getScore());
	}

	//Testing player 1 game win
	@Test
	public void Player1Win() {
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		assertEquals("Rodrigue1 wins the game", tennisGame1.getScore());
	}

	//Testing player 2 game win
	@Test
	public void Player2Win() {
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player2);
		assertEquals("Rodrigue2 wins the game", tennisGame1.getScore());
	}
	
	//Testing score reveal
	@Test
	public void RevealScores() {
		tennisGame1.winPoint(player2);
		assertEquals("Rodrigue1 : 0 , Rodrigue2 : 15", tennisGame1.getScore());
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		assertEquals("Rodrigue1 : 15 , Rodrigue2 : 30", tennisGame1.getScore());
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		assertEquals("Rodrigue1 : 30 , Rodrigue2 : 40", tennisGame1.getScore());
	}
	
}
