package test;

import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileInputParser {
public static void main(String[] args) {
Scanner input = new Scanner (System.in);   
System.out.println("Enter file name");
String filename = input.next();

Scanner fileScanner = null; 			//create a scanner reference pointing to null
File file = new File(filename);  	//create a file object for file in the project folder

try {								//try-catch block required when opening a file
fileScanner = new Scanner(file); //open the file and attach it to scanner object 
} catch (FileNotFoundException e) {
e.printStackTrace();
}

while (fileScanner.useDelimiter(";").hasNext()) { 	//parse tokens delimited by ;
	System.out.print(fileScanner.next()); 			//print the next token
}
input.close();
	fileScanner.close(); 
}
}


public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputParser f = new FileInputParser();
		f.main(null);
	}

}
