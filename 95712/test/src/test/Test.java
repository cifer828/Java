package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileInputParser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file name");
		String filename = input.next();

		Scanner fileScanner = null; // create a scanner reference pointing to null
		File file = new File(filename); // create a file object for file in the project folder

		try { // try-catch block required when opening a file
			fileScanner = new Scanner(file); // open the file and attach it to scanner object
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (fileScanner.useDelimiter(";").hasNext()) { // parse tokens delimited by ;
			System.out.print(fileScanner.next()); // print the next token
		}
		input.close();
		fileScanner.close();
	}
}

1class Person1 {
	public void method1() {
		System.out.println("Person 1");
	}
	public void methods() {
		System.out.println("Person 2");
	}
}
class Student1 extends Person1 {
	public void method1() {
		System.out.println("Student 1");
		super.method1();
		method2();
	}
	public void method2() {
		System.out.println("Student 2");
	}
}
class Undergrad1 extends Student1 {
	public void methods() {
		System.out.println("Undergrad 2");
	}
}
public class Test {
	int noValue;
	String noString;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// string replace
//		String apple = "apple";
//		apple = apple.replace("p", "");
//		System.out.println(apple);
		
		// 
//		Test t = new Test();
//		System.out.println(t.noString);
//		System.out.println(t.noValue);
		
		// 2d array default value
//		int[][] array2d = new int[2][2];
//		System.out.println(array2d[0][0]);
		
		// initialize StringBuilder 
//		StringBuilder test = new StringBuilder();
//		char [] testCharArray = test.toString().toCharArray();
//		System.out.println(testCharArray.length);
		
		// inheritance and polymorphism
		Person1 u = new Undergrad1();
		u.method1();
		
	}

}
