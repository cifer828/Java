import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordInFile {
	public static int wordAppear(String word, String line){
		int num = 0;
		Pattern pattern = Pattern.compile(word);
		Matcher matcher = pattern.matcher(line);
		while(matcher.find()){
			num++;
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		Scanner input = new Scanner(System.in);
		System.out.print("Type the filename:");
		String filename = input.next();
		int wordCount = 0;
		try{
			br = new BufferedReader(new FileReader(filename));
			System.out.print("Type a word for searching: ");
			String word = input.next();
			String line;
			while((line = br.readLine()) != null){
				wordCount += wordAppear(word, line);
			}
			System.out.printf("The word '%s' appears %d times in the file.", word, wordCount);
		}
		catch (IOException e){
			System.out.println("File doesn't exist.");
		}
	}

}
