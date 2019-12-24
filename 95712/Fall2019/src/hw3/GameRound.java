/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Save common word and status used in one round of all games.
 * Super class of HangmanRound and TwisterRound
 */


package hw3;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameRound {
	
	/* Class members */
	private StringProperty puzzleWord = new SimpleStringProperty(); // puzzle word used in a single game round
	private BooleanProperty isRoundComplete = new SimpleBooleanProperty(); // whether or not this round ends
	private StringProperty clueWord = new SimpleStringProperty(); // clue word generated from the puzzle word
	
	/* Getters */
	public String getPuzzleWord() { return puzzleWord.get(); }
	public String getClueWord() { return clueWord.get(); }
	public boolean getIsRoundComplete() { 	return isRoundComplete.get(); }
	
	/* Setters */
	public void setPuzzleWord(String puzzleWord) { this.puzzleWord.set(puzzleWord); }
	public void setClueWord(String clueWord) { this.clueWord.set(clueWord); }
	public void setIsRoundComplete(boolean isRoundComplete) { this.isRoundComplete.set(isRoundComplete); }
	
	/* Getters for property  */
	public StringProperty puzzleWordProperty() { return puzzleWord; }
	public StringProperty clueWordProperty() { return clueWord; }	
	public BooleanProperty isRoundCompleteProperty() { return isRoundComplete; }
	

	
}
