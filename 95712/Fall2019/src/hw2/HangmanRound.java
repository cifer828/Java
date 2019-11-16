/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 * 
 * HangmanRound: Save specific status used in one round of the game Hangman.
 *            Inherits GameRound.
 */

package hw2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class HangmanRound extends GameRound{
	
	/*
	 ***************************
	 **    Class  Members     **
	 ***************************
	 */
	
	// miss/hit counts in a single round of game
	private IntegerProperty hitCount = new SimpleIntegerProperty();
	private IntegerProperty missCount = new SimpleIntegerProperty();
	
	/*
	 ***************************
	 **     Basic  Methods    **
	 ***************************
	 */
	
	/* getHitCount(): getter for hitCount content */
	public int getHitCount() {
		return hitCount.intValue();
	}
	
	/* setHitCount(): setter for hitCount content */
	public void setHitCount(int hitCount) {
		this.hitCount.set(hitCount);
	}
	
	/* hitCountProperty(): getter for hitCount property */
	public IntegerProperty hitCountProperty() {
		return hitCount;
	}
	
	/* getMissCount(): getter for missCount content */
	public int getMissCount() {
		return missCount.intValue();
	}
	
	/* setMissCount(): setter for missCount content */
	public void setMissCount(int missCount) {
		this.missCount.set(missCount);
	}
	
	/* missCountProperty: getter for missCount property */
	public IntegerProperty missCountProperty() {
		return missCount;
	}
	
}
