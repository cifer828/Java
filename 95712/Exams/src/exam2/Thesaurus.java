// Qiuchen Zhang
// qiuchenz

package exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thesaurus extends WordReference{
	public Thesaurus(String filename) {
		// TODO Auto-generated constructor stub
		StringBuilder content = new StringBuilder();
		try {
			Scanner input = new Scanner(new File(filename));
			while(input.hasNextLine()) {
				content.append(input.nextLine() + "\n");
			}
			input.close();
			String [] contentArray = content.toString().split("\n");
			wordData = new String [contentArray.length][];
			for (int i = 0; i < wordData.length; i++) {
				wordData[i] = contentArray[i].split(",");

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	String[] lookup(String word) {
		String output = "";
		for (int i = 0; i < wordData.length; i++) {
			if(wordData[i][0].trim().equalsIgnoreCase(word.trim())) {
				for(int j = 1; j < wordData[i].length; j++) {
					output += wordData[i][j] + "\n";
				}
			}
		}
		if(output.length() == 0)
			return null;
		else {
			return output.split("\n");
		} 
	}
}
