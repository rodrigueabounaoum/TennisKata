package sprint2;

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
	
	@Test
	public void Should_GetDeuce_Advantage_Deuce() {
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
		
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 0 all | Game Score -> Advantage Rodrigue1", tennisGame1.getScore());
		
		tennisGame1.winPoint(player2);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
	}
	


	@Test
	public void GetDeuce_Advantage_Win_NewGame() {
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 0 all | Game Score -> Deuce", tennisGame1.getScore());
		
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 0 all | Game Score -> Advantage Rodrigue1", tennisGame1.getScore());
		
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> Rodrigue1 : 1 , Rodrigue2 : 0 | Game Score -> 0 all", tennisGame1.getScore());
	}
	
	@Test
	public void Player1_Win_Set() {
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);
		gameWin(player1);

		System.out.println(tennisGame1.getScore());
		assertEquals("Set Score -> Rodrigue1 wins the set", tennisGame1.getScore());
	}
	
	@Test
	public void Reveal_Scores() {
		gameWin(player1);
		gameWin(player1);
		gameWin(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player2);
		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> Rodrigue1 : 2 , Rodrigue2 : 1 | Game Score -> Rodrigue1 : 15 , Rodrigue2 : 30", tennisGame1.getScore());
	}
	
	@Test
	public void Reveal_Equal_Scores() {
		gameWin(player1);
		gameWin(player2);
		tennisGame1.winPoint(player2);

		tennisGame1.winPoint(player1);
		System.out.println(tennisGame1.getScore()); 
		assertEquals("Set Score -> 1 all | Game Score -> 15 all", tennisGame1.getScore());
	}

	
	
	public void gameWin(TennisPlayer player) {
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
		tennisGame1.winPoint(player);
	}
}
