/**
 * @author Qiuchen Zhang
 * @andrewID qiuchenz
 * 
 * Read and save data in file.
 */

package hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class WordNerdModel {
	
	/* Class Members */
	static String [] wordsFromFile;
	static final String WORDS_FILE_NAME = "data\\wordsFile.txt";
	static final String SCORE_FILE_NAME = "data\\scores.csv";
	ObservableList<Score> scoreList;
	
	/**
	 * Read puzzle words from the given file, 
	 * display an alert window if the given file include any invalid word 
	 * 
	 * @param wordFilename: file which saves a list of puzzle word
	 * @return an array of puzzle words
	 */
	static String[] readWordsFile(String wordFilename) {
		// deal with path issue on MacOS
		wordFilename = wordFilename.replace('\\', '/');
		
		StringBuilder fileContent = new StringBuilder();
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(wordFilename));){
			while((line = br.readLine()) != null) {
				// if a word has an invalid char, display an alert window
				if (!line.matches("[a-zA-Z]+")) {
					throw new InvalidWordSourceException("Check word source format!");
				}
				fileContent.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidWordSourceException e) {
			e.showAlert();
			return null;
		}
				
		wordsFromFile = fileContent.toString().split("\n");
		return wordsFromFile;
	}
	
	/**
	 * Append a new score record to the end of score file
	 * @param scoreString: a score record in the format "gameId,puzzleWord,time,score"
	 */
	void writeScore(String scoreString) {
		// deal with path issue on MacOS
		String scoreFilename = SCORE_FILE_NAME.replace('\\', '/');
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(scoreFilename, true))){
			bw.write(scoreString + '\n');
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read score from file, and update scoreList
	 */
	void readScore() {
		// deal with path issue on MacOS
		String scoreFilename = SCORE_FILE_NAME.replace('\\', '/');
		
		scoreList = FXCollections.observableArrayList();
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(scoreFilename))) {
			
			while ((line = br.readLine()) != null) {
				String[] items = line.split(",");
				Score score = new Score(Integer.parseInt(items[0].trim()), items[1].trim(), Integer.parseInt(items[2].trim()), Float.parseFloat(items[3].trim()));
				scoreList.add(score);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
