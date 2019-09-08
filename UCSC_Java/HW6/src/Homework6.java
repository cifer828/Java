import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework6 {

	public static int getUserChoice(){
		Scanner readInput = new Scanner(System.in);
		do{
			try{
				System.out.printf("Enter your choice between 1 and 5 only:");
				int yourChoice = readInput.nextInt();
				if(yourChoice < 6 && yourChoice > 0){
					return yourChoice;
				}
				else	// input out of range
				{
					System.out.println("You have not entered a number between 1 and 5. Try again.");
					readInput.nextLine();
				}
			}
			catch(InputMismatchException e)	// input wrong data type
			{
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // gobble up the wrong input
			}
			
		}while(true);
		
	}
	
	public static void exercise6_1(){
		// serve as the main method in homework 6.1
		System.out.println("Welcome to sorting program\n");
		System.out.println("\t1. Title");
		System.out.println("\t2. Rank");
		System.out.println("\t3. Date");
		System.out.println("\t4. Stars");
		System.out.println("\t5. Like\n");
		int yourChoice = getUserChoice();
		System.out.printf("\nYou entered valid choice %d\nThank you for giving your choice\n", yourChoice);
	}
	
	public static float[] getTwoFloats(){
		Scanner readInput = new Scanner(System.in);

		do{
			try{
				System.out.printf("Enter two floats separated by a space:");
				float firstFloat = readInput.nextFloat();
				float secondFloat = readInput.nextFloat();
				float twoFloats[] = {firstFloat, secondFloat};  
				return twoFloats;  
			}
			catch(InputMismatchException e)	// input wrong data type
			{
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // gobble up the wrong input
			}
			
		}while(true);
	}
	
	public static void exercise6_2(){
		// serve as the main method in homework 6.2
		System.out.println("Welcome to get two floats program\n");
		float [] twoFloats = getTwoFloats();
		System.out.printf("\nYou entered two valid floats %f and %f \nThank you for giving two floats\n", twoFloats[0], twoFloats[1]);
	}
	
	
	public static void main(String[] args) {
		System.out.println("----------Homework 6.1-----------");
		exercise6_1();
		System.out.println("----------Homework 6.2-----------");
		exercise6_2();
	}

}
