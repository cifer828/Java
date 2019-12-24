package practice.practice15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchQ {
	String fileName; 		//stores file name input by the user
	String searchWord;		//stores search word input by user
	StringBuilder fileContent = new StringBuilder();	//stores file content
	Queue<String> searchHistory = new LinkedList<>();	//stores last 5 successful searches
	ArrayList<Integer> positions;						//stores the positions of last successful searchWord
	Scanner input = new Scanner(System.in);				//takes user input for filename and searchWord

	public static void main(String[] args) {
		SearchQ sq = new SearchQ();
		sq.readFile();
		sq.getSearchWord();
		while (sq.searchWord.length() > 0) {
			sq.printSearchHistory();
			sq.getSearchWord();
		} 
		System.out.println("Bye Bye");
	}

	/**readFile() asks the user for the filename and reads its contents into fileContent
	 */
	public void readFile()  {
		System.out.println("Enter file name");
		fileName = input.nextLine();
		try {
			Scanner fileInput = new Scanner (new File(fileName));
			while (fileInput.hasNextLine()) {
				fileContent.append(fileInput.nextLine() + "\n");
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/************************** Write your code below this line ******************************/
	
	/**getSearchWord() asks user for searchWord, initializes searchWord with the input
	 * It then invokes getWordPositions(searchWord) which returns positions arraylist
	 * If positions arraylist's size is 0, it means the word wasn't found so it prints a message accordingly
	 * else, it checks if searchHistory size is >= 5. If yes, it removes (polls) the queue. 
	 * If not, it adds (offers) the new search word
	 * 
	 */
	public void getSearchWord() {
		System.out.println("Enter search word. To quit, simply press Enter with no word");
		searchWord = input.nextLine().trim();
		getWordPositions(searchWord);
		
		if(positions.size() == 0) {
			System.out.printf("Sorry %s not found\n", searchWord);
			return;
		}
		
		System.out.printf("%s found in %d positions:", searchWord, positions.size());
		for(int pos: positions) {
			System.out.print(" " + pos);
		}
		System.out.println();
		// only save latest 5 successful searched words
		searchHistory.offer(searchWord);
		if (searchHistory.size() > 5) {
			searchHistory.poll();
		}
	}

	/** printSearchHistory() prints the output as required
	 * using the positions arrayList and the searchHistory queue
	 */
	public void printSearchHistory() {
		System.out.println("***Your search history***");
		for (String word: searchHistory) {
			System.out.println(word);
		}
	}

	/** getWordPositions() searches for the searchWord in the fileContent
	 *  It uses "[^a-zA-Z0-9']+" as the regex for parsing the words.
	 *  It stores all positions at which the word is found in the positions arrayList
	 */
	public ArrayList<Integer> getWordPositions(String searchWord) {
		String[] wordArray = fileContent.toString().split("[^a-zA-Z0-9']+");
		positions = new ArrayList<>();
		for (int i = 0; i < wordArray.length; i++) {
//			System.out.println(wordArray[i]);
			if (searchWord.equalsIgnoreCase(wordArray[i])) {
				positions.add(i);
			}
		}
		return positions;
	}

}