package practice;

import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		System.out.println("Enter the numbers separated by a space");
		Scanner input = new Scanner(System.in);
		String numbers = input.nextLine();
		Scanner tokens = new Scanner(numbers);
		while(tokens.hasNext()) 
			sum += tokens.nextDouble();
		System.out.print("The sum is " + sum);
		input.close();
		tokens.close();
	}
}
