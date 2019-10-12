// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package hw1;

import java.util.Random;
import java.util.Scanner;

public class Hangman extends Game {

	static final int MIN_WORD_LENGTH = 5;
	static final int MAX_WORD_LENGTH = 10;
	static final int HANGMAN_TRIALS = 10; 

	//codes returned by nextTry() method for printing appropriate message
	
	static final int RIGHT_MESSAGE_INDEX = 0;
	static final int WRONG_MESSAGE_INDEX = 1;
	static final int ALREADY_ENTERED_MESSAGE_INDEX = 2;
	static final int PART_OF_CLUE_MESSAGE_INDEX = 3;
	static final int CONGRATULATIONS_MESSAGE_INDEX = 4;
	static final int LOST_MESSAGE_INDEX = 5;
	
	String[] messagesArray = { ":-) You got that right!", //RIGHT_MESSAGE_INDEX
			":-( Sorry! Got it wrong!", 		//WRONG_MESSAGE_INDEX
			":-o You already entered that!", 	//ALREADY_ENTERED_MESSAGE_INDEX
			":-\\ Part of the clue!", 			//PART_OF_CLUE_MESSAGE_INDEX
			":-D Congratulations! You won!",   	//CONGRATULATIONS_MESSAGE_INDEX
			":-( Sorry! You lost this one!"}; 	//LOST_MESSAGE_INDEX


	HangmanRound hangmanRound;
	
	//create and initialize a new round, play, and then print final result
	@Override
	void startGame() {
		//write your code here
		hangmanRound = new HangmanRound();
		String puzzleWord = findPuzzleWord();
		hangmanRound.setPuzzleWord(puzzleWord);
		hangmanRound.setClueWord(makeAClue(puzzleWord));
		hangmanRound.setIsRoundComplete(false);
		hangmanRound.setHitCount(0);
		hangmanRound.setMissCount(0);
		playRound();
		System.out.printf("Your score is %.2f\n", getScore());
	}

	//return a new puzzle word randomly selected from the Game's wordsFromFile. 
	@Override
	String findPuzzleWord() {
		// write your code here
		readFile(WORDS_FILE_NAME);
		// return a random string
		Random rand = new Random();
		
		int wordLength, randInt;
		// find a random word whose length is between 5 and 10
		do {
			randInt = rand.nextInt(wordsFromFile.length);
			wordLength = wordsFromFile[randInt].length();
		}
		while (wordLength > MAX_WORD_LENGTH || wordLength < MIN_WORD_LENGTH);
		return wordsFromFile[randInt];
	}

	//Runs a complete round, invoking nextTry() for each guess to be made by the player
	//Keeps track all inputs made by the player
	//A round goes as long as player has not guessed the complete puzzleWord 
	//and the number of guesses is less than HANGMAN_TRIALS
	//Prints the message from  messagesArray[] based on the code returned by nextTry()
	@Override
	void playRound() {
		//write your code here
		Scanner input = new Scanner(System.in);
		int trialNum = 1;
		StringBuilder userInputs = new StringBuilder("");
		while(trialNum <= HANGMAN_TRIALS) {
			System.out.println("The clue is: " + hangmanRound.getClueWord());
			System.out.printf("*** Trial# %d. Enter your guess: ", trialNum);
			char guess = input.next().charAt(0); // save user guess
			int result = nextTry(guess, userInputs); // take a guess
			if (result == RIGHT_MESSAGE_INDEX || result == WRONG_MESSAGE_INDEX)
				trialNum++;
			System.out.println(messagesArray[result]); // print guess result
			if (countDashes(hangmanRound.getClueWord()) == 0) {
				// guess the complete puzzleWord
				hangmanRound.setIsRoundComplete(true);
				break;
			}
		}
		System.out.println("The word is: " + hangmanRound.getPuzzleWord());
		// print ending message
		if (hangmanRound.getIsRoundComplete())
			System.out.println(messagesArray[CONGRATULATIONS_MESSAGE_INDEX]);
		else {
			System.out.println(messagesArray[LOST_MESSAGE_INDEX]);
		}
		input.close();
	}

	//Takes next guess and prior userInputs. 
	//updates hitCount, missCount, and clueWord in hangmanRound
	//updates userInputs
	//returns code for message to be printed
	int nextTry(char guess, StringBuilder userInputs) {
		// write your code here	
		String puzzleWord = hangmanRound.getPuzzleWord();
		String clueWord = hangmanRound.getClueWord();
		boolean inPuzzleWord = puzzleWord.contains(""+guess);
		boolean inClueWord = clueWord.contains(""+guess);
		boolean inUserInputs = userInputs.toString().contains(""+guess);
		if(inClueWord)
			// part of clue
			return PART_OF_CLUE_MESSAGE_INDEX;
		else if(inUserInputs) 
			// already entered
			return ALREADY_ENTERED_MESSAGE_INDEX;
		else if(inPuzzleWord) {
			// right guess -> update hitCount, clueWord 
			userInputs.append(guess);
			hangmanRound.setHitCount(hangmanRound.getHitCount() + 1);
			String newclueWord = "";
			for (int i = 0; i < puzzleWord.length(); i++) {
				newclueWord += puzzleWord.charAt(i) == guess ? guess : clueWord.charAt(i);
			}
			hangmanRound.setClueWord(newclueWord);
			return RIGHT_MESSAGE_INDEX;
		}
		else {
			// wrong guess -> update missCount
			userInputs.append(guess);
			hangmanRound.setMissCount(hangmanRound.getMissCount() + 1);
			return WRONG_MESSAGE_INDEX;
		}
	}

	
	//Returns a clue that has at least half the number of letters 
	//in puzzleWord replaced with dashes.
	//The replacement should stop as soon as number of dashes equals or exceeds 50% of total word length. 
	//Note that repeating letters will need to be replaced together.
	//For example, in 'apple', if replacing p, then both 'p's need to be replaced to make it a--le
	@Override
	String makeAClue(String puzzleWord) {
		//write your code here
		return replaceChar(puzzleWord, puzzleWord);
	}
	
	// randomly change one char in String to dash
	// noDashWord is the clueWord without dash
	private String replaceChar(String noDashWord, String clueWord) {
		if (noDashWord.length() <= clueWord.length() / 2) {
			return clueWord;
		}
		// generate a random char from noDashWord String
		Random rand = new Random();
		int randCharIdx = rand.nextInt(noDashWord.length());
		char dashChar = noDashWord.charAt(randCharIdx);
		noDashWord = noDashWord.replace(""+dashChar, ""); // remove the char replaced by dash
		clueWord = clueWord.replace(dashChar, '-');
		return replaceChar(noDashWord, clueWord);
	}
	
	//returns the number of dashes in a clue string 
	int countDashes(String word) {
		//write your code here
		int dashNum = 0;
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == '-')
				dashNum++;
		return dashNum;
	}

	//returns score based on Hangman rules
	@Override
	float getScore() {
		//write your code here
		// If missCount = 0, return hitCount as score
		return (float)hangmanRound.getHitCount() / Math.max(hangmanRound.getMissCount(), 1);
	}
}
