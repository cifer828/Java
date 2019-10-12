// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Game {
	public static final String WORDS_FILE_NAME = "wordsFile.txt";  //use this constant wherever file name is used. 
	public static String[] wordsFromFile;		//stores words read from the word file in this array

	Game() {
		wordsFromFile = readFile(WORDS_FILE_NAME);
	}

	//readfile() returns an array of words read from the file
	public static String[] readFile(String filename) {
		//write your code here
		try {
			String fileContent = "";
			Scanner fileInput = new Scanner(new File(filename));
			while(fileInput.hasNextLine()) 
				fileContent += fileInput.nextLine() + "\n";
			wordsFromFile = fileContent.split("\n");
			fileInput.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return wordsFromFile;
	}

	abstract void startGame();
	abstract String findPuzzleWord();
	abstract void playRound();
	abstract String makeAClue(String puzzleWord);
	abstract float getScore();
}
