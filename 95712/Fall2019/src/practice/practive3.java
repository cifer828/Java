package practice;

import java.util.Scanner;

public class practive3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double timeBefore = System.currentTimeMillis();
		String example ="This is a test sentence to test your typing proficiency. Type this as fast as you can!";
		System.out.println(example);
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine();
		double timeAfter = System.currentTimeMillis();
		if (sentence.equals(example))
			System.out.println("Your typing is accurate!");
		else if (sentence.equalsIgnoreCase(example))
			System.out.println("Your typing is good but you made some case-errors!");
		else 
			System.out.println("Your typing has errors!");
		System.out.printf("Your speed is %f words per min", sentence.length() / (timeAfter - timeBefore) * 60000);
	}

}
