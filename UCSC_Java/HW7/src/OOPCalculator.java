import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class OOPCalculator {
	private Scanner readInput = new Scanner(System.in);
	char userInput;
	int userChoice;
	float [] myFloats = new float[2];
	public int askCalcChoice(){
		/**
		* @param readInput
		* : Scanner passed from main method
		* ask the user to select a choice and detect input error
		*/
		System.out.println("Welcome to  Qiuchen Zhang's Handy Calculator \n\n\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n" +
				 "\t4. Division\n\t5. Exit\n");
		do{
//			try{
				System.out.printf("\nWhat would you like to do?");
				this.userInput = this.readInput.next().charAt(0);
				userChoice = OOPCalculator.input2Choice(this.userInput);
				if (OOPCalculator.input2Choice(this.userInput) != 0) {
					break; // Got it, done
					} 
				else { 
					// wrong input
					System.out.println("You have entered an invalid choice. Try again¡£");
					this.readInput.nextLine();
				}
//			}
//			catch(final InputMismatchException e)	// input wrong data type
//			{
//				System.out.println("You have entered an invalid choice. Try again.");
//				this.readInput.nextLine(); // gobble up the wrong input
//			}
		} while(true);	
		return this.userChoice;
	}
	
	private static int input2Choice(char input){
//		convert user input to user choice (1 2 3 4 5)
		if (input == '1' || input == 'A' || input == 'a')
			return 1;
		else if (input == '2' || input == 'S' || input == 's')
			return 2;
		else if (input == '3' || input == 'M' || input == 'm')
			return 3;
		else if (input == '4' || input == 'D' || input == 'd')
			return 4;
		else if (input == '5' || input == 'X' || input == 'x')
			return 5;
		else
			return 0;
	}
	
	public void askTwoValues(){
		/**
		* @param myFloats
		* : assigns two floats from user into the array elements
		* @param readInput
		* : Scanner passed from main method
		* ask the user to input two floats for calculation and detect input error
		*/
		do { // Loop until we have correct input
			// ask user to input 2 floats based on calculation method
			if (this.userChoice == 1)
				System.out.print("\nPlease enter two floats to add, seperated by a space:");
			else if (this.userChoice == 2)
				System.out.print("\nPlease enter two floats to subtract, seperated by a space:");
			else if (this.userChoice == 3)
				System.out.print("\nPlease enter two floats to multiply, seperated by a space:");
			else if (this.userChoice == 4)
				System.out.print("\nPlease enter two floats to divide seperated by a space:");
			try {
				this.myFloats[0] = this.readInput.nextFloat();
				this.myFloats[1] = this.readInput.nextFloat();
				break;
			} 
			catch (final InputMismatchException e) {
				System.out.print("You have entered an invalid floats please re-enter:");
				this.readInput.nextLine();
				// discard non-float input
				continue;
				// keep looping until you found right one
			}
		} while (true);
		//clear the input buffer for next read
		this.readInput.nextLine();
	}

	private void add(){
		/**
		* add two floats
		*/
		System.out.printf("Result of adding %.2f and %.2f is %.2f.\n\n", this.myFloats[0], this.myFloats[1],  this.myFloats[0] + this.myFloats[1]);
	}
	
	private void subtract(){
		/**
		* minus two floats
		*/
		System.out.printf("Result of subtracting %.2f from %.2f is %.2f.\n\n", this.myFloats[1], this.myFloats[0],  this.myFloats[0] - this.myFloats[1]);
	}
	
	private void multiply(){
		/**
		* multiply two floats
		*/
		System.out.printf("Result of multiplying %.2f and %.2f is %.2f.\n\n", this.myFloats[0], this.myFloats[1],  this.myFloats[0] * this.myFloats[1]);
	}
	
	private void divide(){
		/**
		* divide two floats
		*/
		do{
//			divide by zero issue
			if (myFloats[1] == 0){
				System.out.print("You can't divide by zero please re-enter both floats:");
				this.readInput.nextLine();
				this.askTwoValues();
			}
			else
				break;
		} while(true);
		System.out.printf("Result of dividing %.2f by %.2f is %.2f.\n\n", this.myFloats[0], this.myFloats[1],  this.myFloats[0] / this.myFloats[1]);
	}
	
	public void displayResults() {
//		do	calculation, display result
		switch (this.userChoice){
		case 1:
			add();
			break;
		case 2:
			subtract();
			break;
		case 3:
			multiply();
			break;
		case 4:
			divide();
			break;
		}
		System.out.println("Please enter any key to continue ....");
		this.readInput.next();
	}
	public void displayBye(){
		System.out.println("\nThank you for using Qiuchen Zhang's Handy Calculator");	
		return;
	}
}
