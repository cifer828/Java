package practice.practice8;

import java.util.Scanner;

/** This is a dinner simulation program to illustrate several OO concepts 
 * such as abstract classes, interfaces, static variables, static final constants, and polymorphism.
 * The Dinner class starts the program.
 * */


public class Dinner {
	
	/** main method prints the menu and takes user input in the variable 'choice'.
	 * It then invokes the getFood() method and passes the choice to it.
	 * After getFood() method returns the appropriate Food object, the main method  
	 * invokes the eatFood() method and passes that Food object to it. 
	 * It then prints how many calories have been consumed.
	 * The above is repeated in a loop till the user enters 'n' to the 
	 * question, 'Want some more?'
	 */
	public static void main(String[] args) {
		Dinner dinner = new Dinner();
		int choice = 0;
		// enter your code here
		Scanner input = new Scanner(System.in);
		char more = 'y';
		while(more != 'n') {
			// ask for choices
			System.out.println("What would you like to eat?");
			System.out.println("1. Pizza\n2. Chips\n3. Ice cream");
			choice = input.nextInt();
			// eat food
			Food food = dinner.getFood(choice);
			dinner.eatFood(food);
			System.out.printf("You have consumed %d calories\n", Food.calories);
			// eat more ?
			System.out.println("Want some more (y/n)?");
			more = input.next().charAt(0);
		}
		input.close();
		System.out.println("Good night!");
	}

	/**getFood() takes choice and returns Pizza object, Chips object, or IceCream object
	 * for choices 1, 2, and 3 respectively.  
	 */
	public Food getFood(int choice) {
		// enter your code here
		switch (choice) {
		case 1:
			return new Pizza();
		case 2:
			return new Chips();
		case 3:
			return new IceCream();
		default:
			return null;
		}
	}
	
	/**eatFood() method takes Food object as an argument. 
	 * It checks if the object is Pizza. If yes, then 
	 * it invokes its heatIt() method
	 * Then it invokes the eat() method of the Food object. 
	 */
	
	public void eatFood(Food f) {
		if (f instanceof Pizza)
			((Pizza) f).heatIt();
		System.out.println(f.eat());
	}
}
