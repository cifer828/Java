// Name: Qiuchen Zhang
// Andrew ID: qiuchenz

package dayone;

import java.util.Arrays;
import java.util.Scanner;

public class Reducer {
	
	
	//DO NOT CHANGE the main method
	public static void main(String[] args) {
		String word;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word");
		word = input.next();

		Reducer reducer = new Reducer();
		System.out.println("Unique letters in the word are: " + reducer.reduce(word));
		input.close();
	} 
	
	String reduce(String word) {
		//write your code here.
		char[] words = word.toCharArray();
		String output = "";
		for(char w:words) {
			if(!output.contains(Character.toString(w)))
				output += w;
		}
		char[] wordSet = output.toCharArray();
		Arrays.sort(wordSet);
		return Arrays.toString(wordSet);
		
	}
}
