package practice.practice12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class Document {
	StringBuilder fileContent;
	void readFile(String filename) {
		fileContent = new StringBuilder();
		try {
			Scanner input = new Scanner(new File(filename));
			while(input.hasNextLine()) {
//				System.out.println(input.nextLine());
				fileContent.append(input.nextLine() + "\n");
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	abstract String getDocInfo();
}
