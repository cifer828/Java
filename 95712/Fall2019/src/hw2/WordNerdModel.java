/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 * 
 * WordNerdModel: Read and save data in file.
 * 
 */
package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WordNerdModel {
	
	static String [] wordsFromFile;
	public static final String WORDS_FILE_NAME = "data\\wordsFile.txt";
	
	/* readWordsFile(): read file named "wordFilename" to wordsFromFile */
	public static String[] readWordsFile(String wordFilename) {
		
		try {
			// deal with path issue on MacOS
			/*************************************************************
			 * To TA:													 *
			 * If there's any problem with reading file on Windows, 	 *
			 * Please try commenting out the following line.             *
			 * Thank you very much!                                      *
			 * ***********************************************************/
			wordFilename = wordFilename.replace('\\', '/');
			
			String fileContent = "";
			Scanner fileInput = new Scanner(new File(wordFilename));
			while(fileInput.hasNextLine()) 
				fileContent += fileInput.nextLine() + "\n";
			wordsFromFile = fileContent.split("\n");
			fileInput.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordsFromFile;
	}
}
