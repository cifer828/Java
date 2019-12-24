/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Super class of Hangman and Twister. Has some basic methods shared by the two games.
 */

package hw3;

public abstract class Game {
	
	/**
	 * Creates a new GameRound instance and initializes it various properties
	 * 
	 * @return a new game round
	 */
	abstract GameRound setupRound();
	
	/**
	 * Create a clue word using the puzzled word
	 * 
	 * @param puzzleWord: puzzle word used in a game round
	 * @return a clue string to be displayed as per the game rule
	 */
	abstract String makeAClue(String puzzleWord);
	
	/**
	 * calculates the score build score string
	 * 
	 * @return A string to be displayed as per the format required for the game
	 */
	abstract String getScoreString();

	/**
	 * Processes the next entry submitted made by the player. 
	 * 
	 * @param guess: user's guess
	 * @return index of the image to be displayed on smileyButton.
	 */
	abstract int nextTry(String guess);
	
}
