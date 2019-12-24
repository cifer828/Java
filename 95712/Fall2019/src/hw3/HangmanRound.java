/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Save specific status used in one round of the game Hangman.
 * Inherits GameRound.
 */

package hw3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class HangmanRound extends GameRound{
	
	/* Class Members */
	
	// miss/hit counts in a single round of game
	private IntegerProperty hitCount = new SimpleIntegerProperty();
	private IntegerProperty missCount = new SimpleIntegerProperty();
	
	/* Getters */
	public int getHitCount() { return hitCount.intValue(); }
	public int getMissCount() { return missCount.intValue(); }
	
	/* Setters */
	public void setHitCount(int hitCount) { this.hitCount.set(hitCount); }
	public void setMissCount(int missCount) { this.missCount.set(missCount); }
	
	/* Getters for property */
	public IntegerProperty hitCountProperty() { return hitCount; }
	public IntegerProperty missCountProperty() { return missCount; }
	
}
