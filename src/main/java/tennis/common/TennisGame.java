package tennis.common;

import tennis.model.TennisPlayer;

public interface TennisGame {

	public String getScore (); 
	public void winPoint (TennisPlayer tennisPlayer) ;
	
}
