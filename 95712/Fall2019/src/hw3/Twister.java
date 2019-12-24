/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Implement back-end logic of the game Twister.
 */

package hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Twister extends Game{
	
	/* Class Members */
	
	final static int SOLUTION_LIST_COUNT = 5;
	final static int TWISTER_MAX_WORD_LENGTH = 7;
	final static int TWISTER_MIN_WORD_LENGTH = 3;
	final static int NEW_WORD_BUTTON_INDEX = 0;
	final static int TWISTER_BUTTON_INDEX = 1;
	final static int CLEAR_BUTTON_INDEX = 2;
	final static int SUBMIT_BUTTON_INDEX = 3;
	final static int CLUE_BUTTON_SIZE = 75;
	final static int TWISTER_GAME_TIME = 120;
	final static int MIN_SOLUTION_WORDCOUNT = 10;
	
	TwisterRound twisterRound;
	
	/**
	 * Initialize puzzleWord randomly drawn from wordsFromFile.
	 * The puzzleWord length must be between TWISTER_MIN_WORD_LENGTH and TWISTER_MAX_WORD_LENGTH. 
	 * It also must have at least MIN_SOLUTION_WORDCOUNT words twisted out of it. 
	 * Other properties of TwisterRound are also initialized here. 
	 * 
	 * @return a new TwisterRound
	 */
	@Override
	TwisterRound setupRound() {
		String puzzleWord;
		List<String> solutions;
		
		// Find a puzzle word which has at least MIN_SOLUTION_WORDCOUNT twister solutions 
		do{
			puzzleWord = findPuzzleWord();
			solutions = twisterSolution(puzzleWord, WordNerdModel.wordsFromFile);
		} while(solutions.size() < MIN_SOLUTION_WORDCOUNT);
		
		// Initialize twisterRound
		twisterRound = new TwisterRound();
		twisterRound.setPuzzleWord(puzzleWord);
		twisterRound.setClueWord(makeAClue(puzzleWord));
		twisterRound.setIsRoundComplete(false);
		
		// Initialize solution words
		twisterRound.setSolutionWordsList(solutions);
		for (String word: solutions) {
			twisterRound.setSolutionListsByWordLength(word);
		}
		
		return twisterRound;
	}
	
	
	/**
	 * Shuffles the puzzled word to make a clue
	 * 
	 * @param puzzleWord: the given puzzle word displayed in clueButtions
	 * @return clue word generated from the puzzle word
	 */
	@Override
	String makeAClue(String puzzleWord) {
		Random rand = new Random();
	    char[] characters = puzzleWord.toCharArray();
	    
	    for (int i = 0; i < characters.length; i++) {
	        int randomIndex = rand.nextInt(characters.length);
	        // randomly swap two chars in the puzzleWord
	        char temp = characters[i];
	        characters[i] = characters[randomIndex];
	        characters[randomIndex] = temp;
	    }
	    
	    return new String(characters);
	}

	/**
	 * @return a formatted String with calculated score to be displayed in the topMessageText. 
	 */
	@Override
	String getScoreString() {
		return String.format("Twist to find %d of %d words", 
				              solutionCount() - submittedCount(), solutionCount());
	}

	/**
	 * @param user's guess
	 * @return index of smileyButton which reflects guess result
	 */
	@Override
	int nextTry(String guess) {
		int wordIdx = guess.length() - TWISTER_MIN_WORD_LENGTH;
		
		// Check length of the guess word
		if (wordIdx < 0)
			return GameView.THUMBS_DOWN_INDEX;
		// Repeat Guess
		else if (twisterRound.getSubmittedListsByWordLength(wordIdx).contains(guess))
			return GameView.REPEAT_INDEX;
		// Right Guess :)
		else if (twisterRound.getSolutionListsByWordLength(wordIdx).contains(guess)) {
			twisterRound.setSubmittedListsByWordLength(guess);
			// Player wins !
			if (submittedCount() == solutionCount())
				return GameView.SMILEY_INDEX;
			else
				return GameView.THUMBS_UP_INDEX;
		}
		// Wrong Guess :(
		else
			return GameView.THUMBS_DOWN_INDEX;
	}
	
	/* Helper Methods */
	
	/**
	 * @return a new puzzle word randomly selected from the data file.
	 */
	private String findPuzzleWord() {
		// Read all words from file
		String [] words = WordNerdModel.wordsFromFile;
		// Return a random string
		Random rand = new Random();
		
		int wordLength, randInt;
		// Find a random word whose length is between TWISTER_MIN_WORD_LENGTH and TWISTER_MAX_WORD_LENGTH. 
		do {
			randInt = rand.nextInt(words.length);
			wordLength = words[randInt].length();
		} while (wordLength > TWISTER_MAX_WORD_LENGTH || wordLength < TWISTER_MIN_WORD_LENGTH);
		// Return that random word as puzzle word
		return words[randInt];
	}
	
	/**
	 * @param puzzleWord: puzzle word in this round
	 * @param wordsFromFile: words in the source file
	 * @return all possible twister words of the puzzle words from data file
	 */
	private List<String> twisterSolution(String puzzleWord, String [] wordsFromFile){
		List<String> solution = new ArrayList<>();
		Map<Character, Integer> puzzleCharCount = new HashMap<>();
		Map<Character, Integer> wordCharCount = new HashMap<>();
		
		// Count characters number in the puzzle word
		for (char c: puzzleWord.toCharArray()) {
			puzzleCharCount.put(c, puzzleCharCount.getOrDefault(c, 0) + 1);
		}
		
		for (String word: wordsFromFile) {
			boolean isATwister = true;
			// Skip words that are longer than the puzzle word 
			// or shorter than TWISTER_MIN_WORD_LENGTH
			if (word.length() > puzzleWord.length() || word.length() < TWISTER_MIN_WORD_LENGTH)
				continue;
			for (char c: word.toCharArray()) {
				if (puzzleCharCount.containsKey(c)) {
					wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
					// Not a twister. It has a character which exceed the counts in the puzzle word
					if (wordCharCount.get(c) > puzzleCharCount.get(c)) {
						isATwister = false;
						break;
					}
				}
				// Not a twister. It has a character not included by the puzzle word
				else {
					isATwister = false;
					break;
				}
			}
			// Add a valid twister
			if (isATwister)
				solution.add(word);
			wordCharCount = new HashMap<>();
		}
		
		return solution;
	}

	/**
	 * @return number of correct words submitted by player
	 */
	public int submittedCount() {
		int submittedCount = 0;
		for (List<String> submittedList: twisterRound.getSubmittedListsByWordLength()) {
			submittedCount += submittedList.size();
		}
		return submittedCount;
	}
	
	/**
	 * @return number of solution words
	 */
	public int solutionCount() {
		return twisterRound.getSolutionWordsList().size();
	}
	
}
