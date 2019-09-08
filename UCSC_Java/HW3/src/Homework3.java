import java.util.Scanner;

import javax.swing.Spring;

public class Homework3 {
	
	public static void excercise_3_1(){
		// homework 3.1
		int yourAge;
		Scanner readInput = new Scanner(System.in);
		System.out.printf("How old are you?: ");
		yourAge= readInput.nextInt();
		if (yourAge < 13)
			System.out.printf("You are a kid\n");
		else if (yourAge < 19)
			System.out.printf("You are a teenager\n");
		else
			System.out.printf("You are an adult\n");
	}
	
	public static void excercise_3_2(){
		// homework 3.2
		Scanner readInput = new Scanner(System.in);
		double firstN;
		double secondN;
		char operator;
		char cont;
		do {
			System.out.printf("Type a number, operator, number --"+ "separated by a space: ");
			firstN = readInput.nextDouble();
			operator = readInput.next().charAt(0);
			secondN = readInput.nextDouble();
			if (operator == '+')
				System.out.printf("%f + %f = %f", firstN, secondN, firstN + secondN);
			else if (operator == '-')
				System.out.printf("%f - %f = %f", firstN, secondN, firstN - secondN);
			else if (operator == '*')
				System.out.printf("%f * %f = %f", firstN, secondN, firstN * secondN);
			else if (operator == '/')
				System.out.printf("%f / %f = %f", firstN, secondN, firstN / secondN);
			else if (operator == '%')
				System.out.printf("%f %% %f = %f",firstN, secondN,firstN % secondN);
			else
				System.out.printf("Unknown operator");
				System.out.printf("\n\n");
			System.out.print("Continue? Type 'y' for yes: ");
			cont = readInput.next().charAt(0);
			}
		while(cont == 'y');
		System.out.println("Exit");
	}
	
	public static void excercise_3_3(){
		// homework 3.3
		int max, a, b, c;
		char cont;
		Scanner readInput = new Scanner(System.in);
		do {
			System.out.println("Enter three integer numbers to find max of them--separated by a space: ");
			a = readInput.nextInt();
			b = readInput.nextInt();
			c = readInput.nextInt();
			max = (a > b) ? a : b; 
			max = (max > c) ? max : c;
			System.out.printf("The Max is: %d\n", max);
			System.out.print("Continue? Type 'y' for yes: ");
			cont = readInput.next().charAt(0);
			}
		while(cont == 'y');
		System.out.println("Exit");
	}
	
	public static void main(String[] args) {
		System.out.println("----------Homework 3.1-----------");
		excercise_3_1();
		System.out.println("----------Homework 3.2-----------");
		excercise_3_2();
		System.out.println("----------Homework 3.3-----------");
		excercise_3_3();

	}

}
