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
		System.out.println(tennisGame2.getScore()); 
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
		System.out.println(tennisGame2.getScore()); 
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
		System.out.println(tennisGame2.getScore());
		assertEquals("Set Score -> 6 all | Tie Breaker Score -> Rodrigue1 : 7 , Rodrigue2 : 6", tennisGame2.getScore());
		tennisGame2.winPoint(player1);
		System.out.println(tennisGame2.getScore()); 
		assertEquals("Set Score -> Rodrigue1 wins the set", tennisGame2.getScore());
	}
	
	
	public void gameWin(TennisPlayer player) {
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
		tennisGame2.winPoint(player);
	}
}
