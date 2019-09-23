package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rainbow {
	
	String[][] colorVotes;  //stores the data read from the file
	String[] votedColors;	//stores the list of unique colors voted for
	int[] voteCounts;		//stored the count the vote for each color. The count of votes for the color in votedColors[i] will be stored in voteCounts[i]
	
	
	public static void main(String[] args) {
		Rainbow rainbow = new Rainbow();
		rainbow.readFile();
		rainbow.calculateVoteCounts();
		rainbow.printVoteCounts();
	}
	
	/** readFile reads Colors.txt, and loads the data into colorVotes. 
	 * It also populates the votedColors array. 
	 */
	void readFile() {
		//write your code here
		Scanner input = null, input2 = null;
		int lineCount = 0;
		String allColors = "";
		try {
			input = new Scanner(new File("Colors.txt"));
			input2 = new Scanner(new File("Colors.txt"));
			while(input.hasNextLine()) {
				input.nextLine();
				lineCount++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lineCount == 0) return;   // no input
		colorVotes = new String[lineCount][];
		lineCount = 0; // count lines from 0
		while(input2.hasNextLine()) {
			String[] oneVote = input2.nextLine().split(",");
			for (int i=0; i < oneVote.length; i++) {
				oneVote[i] = oneVote[i].trim();
				if (! allColors.contains(oneVote[i]))
					allColors += oneVote[i] + ",";
			}
			colorVotes[lineCount] = oneVote;
			lineCount++;
		}
		votedColors = allColors.split(",");
	}
	
	/** calculateVoteCounts() counts the number of votes 
	 * for each color in the votedColors array
	 * and loads the count in voteCounts array. 
	 * The vote count for the color in votedColors[i] 
	 * is stored in voteCounts[i] 
	 */
	void calculateVoteCounts() {
		//write your code here
		Map<String, Integer> colorMap= new HashMap<>();
		for (String[] ss: colorVotes)
			for(String s: ss) {
				if (colorMap.containsKey(s))
					colorMap.put(s, colorMap.get(s) + 1); // count + 1
				else 
					colorMap.put(s, 1);
			}
		voteCounts = new int[votedColors.length];
		for (int i = 0; i < voteCounts.length; i++)
			voteCounts[i] = colorMap.get(votedColors[i]);
				
	}
	
	/** printVoteCounts[] prints the output as shown in the hand-out 
	 * using votedColors and voteCounts arrays
	 */
	void printVoteCounts() {
		for (int i = 0; i < votedColors.length; i++) {
			System.out.printf("Number of votes for %s color = %d%n", votedColors[i], voteCounts[i]);
		}
	}

}
