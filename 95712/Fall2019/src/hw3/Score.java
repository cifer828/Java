/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Record of a single round of game. 
 * Stores four values in the scores.csv, ie.e gameId, puzzleWord, timestamp, and score.
 */

package hw3;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Score {
	
	/* Class Members */
	private IntegerProperty gameId; // 0 for Hangman, 1 for Twister
	private StringProperty puzzleWord; // puzzled word used in a round of game
	private IntegerProperty timeStamp; // time consumed in a round of game
	private FloatProperty score; // score of a round of game
	
	
	/**
	 * Default constructor.
	 */
	public Score() {
		gameId = new SimpleIntegerProperty();
		puzzleWord = new SimpleStringProperty();
		timeStamp = new SimpleIntegerProperty();
		score = new SimpleFloatProperty();
	}
	
	/**
	 * Constructor with initial values.
	 * @param initial values used to create a new Score object
	 */
	public Score(int gameId, String puzzleWord, int timeStamp, float score) {
		this();
		setGameId(gameId);
		setPuzzleWord(puzzleWord);
		setTimeStamp(timeStamp);
		setScore(score);
	}
	
	/* Setters */
	public final void setGameId(int gameID) { this.gameId.set(gameID); }
	public final void setPuzzleWord(String puzzleWord) { this.puzzleWord.set(puzzleWord); }
	public final void setTimeStamp(int timeStamp) { this.timeStamp.set(timeStamp); }
	public final void setScore(float score) { this.score.set(score); }
	
	/* Getters */
	public final int getGameId() { return gameId.get(); }
	public final String getPuzzleWord() { return puzzleWord.get(); }
	public final int getTimeStamp() {return timeStamp.get(); }
	public final float getScore() {return score.get(); }
	
	
	/**
	 * @return game name, gameId 0 for "Hangman", 1 for "Twister"
	 */
	public String getName() {
		if (getGameId() == 0)
			return SearchView.GAME_NAME[1];
		else if (getGameId() == 1)
			return SearchView.GAME_NAME[2];
		return "";
	}
	
}
