import java.util.Scanner;
import java.util.InputMismatchException;

public class Demo_UnitII_ControlStatements {
	public static void main(String[] args) {

		// compound operators
		int N1 = 10, N2 = 3;

		// treat each assignment having the original value of N1 and N2 for
		// answering questions;
		N1 += N2; // is equivalent to N1 = N1 + N2, N1 will have a value of 13
		N1 -= N2; // N1?
		N1 *= N2; //
		N1 /= N2;
		N1 %= N2;

		N1 += N2 + 5; // is equivalent to N1 = N1 + N2 + 5, N1 will have a value
						// of 18
		N1 -= N2 + 5;// N1? is equivalent of N1 = N1 – (N2 + 5), that means N1
						// will be 2
		N1 *= N2 + 5; // N1? Looks like 80
		N1 /= N2 + 5;
		N1 %= N2 + 5;

		// increment/decrement operators

		N1 = 9;
		System.out.printf("%d\n", N1++); // post increment
		System.out.printf("%d\n\n", N1);

		N2 = 9;
		System.out.printf("%d\n", ++N2); // pre increment
		System.out.printf("%d\n\n", N2);
		// what is printed? 9, 10 : 10, 10

		// how about these?

		int count, loop;

		// what is the output
		count = 9;
		loop = ++count; /* same as count = count + 1; loop = count; */
		// (loop: 10, count:10)

		count = 9;
		loop = count++; /* same as loop = count; count = count + 1; */
		// (loop: 9, count:10)

		int Num;

		loop = 8;
		count = 15;
		Num = +loop++;
		// what is the output?
		System.out.printf("Num = %d, loop = %d\n", Num, loop);
		Num = ++Num;
		System.out.printf("Num = %d, loop = %d\n", Num, loop);
		Num = count++ + loop;
		System.out.printf("Num = %d, loop = %d\n", Num, loop);
		Num = --count + --loop;
		System.out.printf("Num = %d, loop = %d\n", Num, loop);
		Num = loop + -Num;
		System.out.printf("Num = %d, loop = %d\n", Num, loop);

		// what is going to be printed?
		int n1 = 3, n2 = 2, n3 = 2;

		if (n1 * 5 * 3 - 4 * n2 * n3 - 14 * 2 >= 0)
			System.out.printf("It is true\n");
		else
			System.out.printf("It is false\n");

		// checking if statement
		double yourSalary = 50000, yourBonus = 2500;
		double yourTakeHomePay;
		double yourTaxBracket;
		Scanner readInput = new Scanner(System.in);
		System.out.printf("What is your tax bracket?: ");
		yourTaxBracket = readInput.nextDouble();
		if (yourTaxBracket > 0) {
			yourTakeHomePay = (yourSalary + yourBonus) * (1 - yourTaxBracket);
			System.out.printf(
					"\nYour take home pay for the 2010 year 		is:  %10.2f\n\n",
					yourTakeHomePay);
		} else {
			System.out
					.printf("\nYou entered a zero tax bracket, uncle SAM will come after you\n");
		}

		// finding a teenager
		int age = 15; // get the age from user
		if (age >= 13)
			if (age <= 19)
				System.out.printf("Your are a teenager\n");

		// Can be Re-write:
		if (age > 12)
			if (age < 20)
				System.out.printf("Your are a teenager\n");

		// or like this by combining with logical operator
		if (age > 12 && age < 20)
			System.out.printf("Your are a teenager\n");

		// write a calculator program --shhhh! This is not all of your midterm I
		float firstN;
		float secondN;
		char op;

		// Scanner readInput = new Scanner(System.in);

		System.out
				.printf("Type a number, operator, number -- Separate by a space: ");
		firstN = readInput.nextInt();
		op = readInput.next().charAt(0);
		secondN = readInput.nextInt();

		if (op == '+')
			System.out.printf("%5.2f + %5.2f = %5.2f", firstN, secondN, firstN
					+ secondN);
		else if (op == '-')
			System.out.printf("%5.2f - %5.2f = %5.2f", firstN, secondN, firstN
					- secondN);
		else if (op == '*')
			System.out.printf("%5.2f * %5.2f = %5.2f", firstN, secondN, firstN
					* secondN);
		else if (op == '/')
			System.out.printf("%5.2f / %5.2f = %5.2f", firstN, secondN, firstN
					/ secondN);
		else if (op == '%')
			System.out.printf("%5.2f %% %5.2f = %d", firstN, secondN,
					(int) firstN % (int) secondN);
		else
			System.out.printf("Unknown operator");
		System.out.printf("\n\n");

		// ternary/conditional operator ?:
		int max, a = 10, b = 20; // get value for a and b from user
		if (a > b) {
			max = a;
		} else {
			max = b;
		}

		max = (a > b) ? a : b; // what is the value of max?

		// Loops
		// what does this following code do? How many times the loop is executed
		int i = 0;
		while (i++ < 10) {
			System.out.println("Hello World");
		}

		// how about this?
		i = 0;
		while (++i < 10) {
			System.out.println("Hello World");
		}

		// and this?
		while (++i < 10) {
			System.out.println("Hello World");
		}
		
		//back to our box example: how to draw a box of 10 X 20 characters using loops now?
		
		//
		// 10 x 20  
		//          ---------------
		//          |              |
		//          |              |
		//          |              |
		//          |              |
		//          |              |
		//          |              |
		//          |              |
		//          |              |
		//          ---------------
		//
		

		// start for          ---------------
		int j = 0;
		
		while (j < 20)
		{
			System.out.printf("-");
			j++;
		}
		
		System.out.println();

		int k = 0;
		while (k < 8)
		{
			//then          |              |
			j = 0;
			System.out.printf("|");
			while (j < 18)
			{
				System.out.printf(" ");
				j++;
			}
			System.out.printf("|");
			System.out.println();
			k++;
		}
		
		//finally last          ---------------
		j = 0;
		while (j < 20)
		{
			System.out.printf("-");
			j++;
		}

		// do..while example
		int loopCount = 0;
		char charResponse = ' ';
		//reuse it Scanner readInput = new Scanner(System.in);
		do {
			System.out.println("Hello World");
			System.out.println("Continue?  Press n to stop:");
			charResponse = readInput.next().charAt(0);
		} while (charResponse != 'n');
		System.out.println("Thanks for using us!");

		//change while to do while
		charResponse = 'y';
		while (charResponse == 'y'){
			System.out.println("Hello World");
			System.out.println("Continue?  Press n to stop:");
			charResponse = readInput.next().charAt(0);
		}
		System.out.println("Thanks for using us!");
		
		//change the box example with for loop
		int count1, count2;
		int  height=10, width=20;
		for (count1=1;count1 < width;count1++)
		{
			System.out.printf("_");
		}
		System.out.printf("\n");
		for(count1=1;count1< height;count1++)
		{
			System.out.printf("|");
			for (count2=1;count2 < width-2;count2++)
				System.out.printf(" ");
			System.out.printf("|\n");
		}
		for(count1=1;count1< width;count1++)
		{
			System.out.printf("-");
		}
		System.out.printf("\n\n");	

	
	} // end main
} // end calculator
