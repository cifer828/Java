import java.util.Scanner;
import java.util.InputMismatchException;

public class Homework5 {
	public static void exercise5_1(){
		Scanner readInput = new Scanner(System.in);
		System.out.println("Welcome to sorting program\n");
		System.out.println("\t1. Title");
		System.out.println("\t2. Rank");
		System.out.println("\t3. Date");
		System.out.println("\t4. Stars");
		System.out.println("\t5. Like\n");
		do{
			try{
				System.out.printf("Enter your choice between 1 and 5 only:");
				int yourChoice = readInput.nextInt();
				if(yourChoice < 6 && yourChoice > 0){
					System.out.printf("\nYou entered valid choice %d\nThank you for giving your choice\n", yourChoice);
					break;	// quit the loop
				}
				else	// input out of range
				{
					System.out.println("You have not entered a number between 1 and 5. Try again.");
				}
			}
			catch(InputMismatchException e)	// input wrong data type
			{
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.next(); // gobble up the wrong input
			}
			
		}while(true);
	}
	
	public static void exercise5_2(){
		Scanner readInput = new Scanner(System.in);
		System.out.println("Welcome to get two floats program\n");
		do{
			try{
				System.out.printf("Enter two floats separated by a space:");
				double firstFloat = readInput.nextDouble();
				double secondFloat = readInput.nextDouble();
				System.out.printf("\nYou entered two valid floats %f and %f \nThank you for giving two floats\n", firstFloat, secondFloat);
				break;
			}
			catch(InputMismatchException e)	// input wrong data type
			{
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // gobble up the wrong input
			}
			
		}while(true);
	}
	
	public static void exercise5_3(){
		int weeklyTemp[]	=	{	69,	70,	71,	68,	66,	71,	70	};
		int i,	max	=	0,	min	=	0;
		float total	=	0,	average;
		min = weeklyTemp[0];
		for(i=0;  i<weeklyTemp.length; i++){
			System.out.printf("The temperature on day %d was %d\n", i, weeklyTemp[i]);
			total += weeklyTemp[i];
			max = weeklyTemp[i] > max? weeklyTemp[i]: max;
			min = weeklyTemp[i] < min? weeklyTemp[i]: min;
		}
		average = total / weeklyTemp.length;
		
		System.out.printf("\nThe Minimum temperature is %d\n", min);
		System.out.printf("The Maximum temperature is %d\n", max);
		System.out.printf("The Average temperature for the week is %f\n", average);
		
		System.out.printf("\nThank you for using my homework #5 solution\n");
	}
	
	public static void main(String[] args) {
		System.out.println("----------Homework 5.1-----------");
		exercise5_1();
		System.out.println("----------Homework 5.2-----------");
		exercise5_2();
		System.out.println("----------Homework 5.3-----------");
		exercise5_3();
	}
}
