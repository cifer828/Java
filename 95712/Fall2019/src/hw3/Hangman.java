/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Implement back-end logic of the game Hangman.
 * 
 */

package hw3;

import java.util.Random;

public class Hangman extends Game{
	
	/* Class Members */
	
	static final int MIN_WORD_LENGTH = 5; //minimum length of puzzle word
	static final int MAX_WORD_LENGTH = 10; //maximum length of puzzle word
	static final int HANGMAN_TRIALS = 10;  // max number of trials in a game
	static final int HANGMAN_GAME_TIME = 30; // max time in seconds for one round of game
	
	HangmanRound hangmanRound;


	/**
	 * Initializes puzzleWord randomly drawn from wordsFromFile.
	 * The puzzleWord must be a word between HANGMAN_MIN_WORD_LENGTH and HANGMAN_MAX_WORD_LEGTH. 
	 * other properties of Hangmanround are also initialized here. 
	 * 
	 * @return A new HangmanRound instance.
	 */
	@Override
	HangmanRound setupRound() {
		// Create a puzzle word from data file
		String puzzleWord = findPuzzleWord();
		// Initialize hangmanRound
		hangmanRound = new HangmanRound();
		hangmanRound.setPuzzleWord(puzzleWord);
		hangmanRound.setClueWord(makeAClue(puzzleWord));
		hangmanRound.setIsRoundComplete(false);
		hangmanRound.setHitCount(0);
		hangmanRound.setMissCount(0);
		return hangmanRound;
	}
	
	/**
	 * Create a clue that has at least half the number of letters in puzzleWord replaced with dashes.
	 * The replacement should stop as soon as number of dashes equals or exceeds 50% of total word length. 
	 * Note that repeating letters will need to be replaced together.
	 * For example, in 'apple', if replacing p, then both 'p's need to be replaced to make it a--le 
	 * 
	 * @param puzzleWord: given puzzleWord
	 * @return A clue word generated from puzzleWord
	 */
	@Override
	String makeAClue(String puzzleWord) {
		return replaceChar(puzzleWord, puzzleWord);
	}
	
	/**
	 * @param word: clue word
	 * @return: number of dashes in the clue word
	 */
	int countDashes(String word) {
		//write your code here
		int dashNum = 0;
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == '_')
				dashNum++;
		return dashNum;
	}
	
	/* 
	 * getScoreString(): Returns a formatted String with calculated score to be displayed after
	 * 					 each trial in Hangman. See the handout and the video clips for specific format of the string. 
	 */
	@Override
	String getScoreString() {
		int hitCount = hangmanRound.getHitCount();
		int missCount = hangmanRound.getMissCount();
		// If missCount = 0, report hitCount as score
		float score = (float)hitCount / Math.max(missCount, 1);
		return String.format("Hit: %d Miss: %d.Score: %.2f", hitCount, missCount, score);
	}

	/**
	 * Takes user's guess and updates hitCount, missCount, and clueWord in hangmanRound. 
	 * 
	 * @param guess: user's guess word
	 * @return index of images defined in GameView (SMILEY_INDEX, THUMBS_UP_INDEX...etc. 
	 */
	@Override
	int nextTry(String guess) {  
		String puzzleWord = hangmanRound.getPuzzleWord();
		String clueWord = hangmanRound.getClueWord();
		
		// Save the return index
		int returnIndex;
		
		// Guess is in the puzzle word, hit :)
		if(puzzleWord.contains(guess)) {
			// Update hitCount
			hangmanRound.setHitCount(hangmanRound.getHitCount() + 1);
			// Update clueWord
			String newclueWord = "";
			for (int i = 0; i < puzzleWord.length(); i++) {
				newclueWord += puzzleWord.charAt(i) == guess.charAt(0) ? guess : clueWord.charAt(i);
			}
			hangmanRound.setClueWord(newclueWord);
			returnIndex = GameView.THUMBS_UP_INDEX;
		}
		// Guess isn't in the puzzle word, miss :(
		else {
			// Update missCount
			hangmanRound.setMissCount(hangmanRound.getMissCount() + 1);
			returnIndex = GameView.THUMBS_DOWN_INDEX;
		}
		
		// Wins !
		if (win())
			returnIndex = GameView.SMILEY_INDEX;
		// Used up all trails, failed
		else if (usedAllTrials())
			returnIndex = GameView.SADLY_INDEX;
		
		return returnIndex;
		
	}
	
	
	/* Helper Methods */
	
	/**
	 * Recursively replace characters in a clueWord by dash until its length meet requirement
	 * 
	 * @param clueWord: clueWord to be updated
	 * @param noDashWord: a copy of clueWord but without dashes in it
	 * @return a new clue word after replacing one kind of character by dash (_)
	 */
	private String replaceChar(String clueWord, String noDashWord) {
		// If half of clueWord has been replaced, return the final clueWord
		if (noDashWord.length() <= clueWord.length() / 2) {
			return clueWord;
		}
		// Generate a random char from noDashWord String
		Random rand = new Random();
		int randCharIdx = rand.nextInt(noDashWord.length());
		char dashChar = noDashWord.charAt(randCharIdx);
		// Remove all that chars in the noDashWord and replace all that chars with dash in the clueWord
		noDashWord = noDashWord.replace(""+dashChar, ""); 
		clueWord = clueWord.replace(dashChar, '_');
		// Do next replacement
		return replaceChar(clueWord, noDashWord);
	}

	/**
	 * @return A new puzzle word randomly selected from the data file
	 */
	private String findPuzzleWord() {
		// Read all words from file
		String [] words = WordNerdModel.wordsFromFile;
		// Return a random string
		Random rand = new Random();
		
		int wordLength, randInt;
		// Find a random word whose length is between 5 and 10
		do {
			randInt = rand.nextInt(words.length);
			wordLength = words[randInt].length();
		} while (wordLength > MAX_WORD_LENGTH || wordLength < MIN_WORD_LENGTH);
		// Return that random word as puzzle word
		return words[randInt];
	}
	
	/**
	 * @return true if trials are used up, false if not 
	 */
	private boolean usedAllTrials() {
		return (hangmanRound.getHitCount() + hangmanRound.getMissCount()) >= HANGMAN_TRIALS;
	}
	
	/**
	 * @return true if there's no dash in the clueWord, which means user wins, and false if not 
	 */
	private boolean win() {
		return countDashes(hangmanRound.getClueWord()) == 0;
	}
}
