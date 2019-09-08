import java.util.Scanner;

public class FirstJavaHello {

	public static void excercise_2_1() {
		// Homework 2.1
		int radius = 2;
		double area;
		final double pi = 3.142;
		area= pi * radius * radius;
		System.out.print("The area is: " + area + "\n");
	}
	
	public static void excercise_2_2() {
		// Homework 2.2
		Scanner readInput = new Scanner(System.in);
		// input radius
		System.out.println();
		System.out.print("Enter the radius: ");
		int radius = readInput.nextInt();
		// input pi
		System.out.print("Enter the ¦Ð value: ");
		double pi = readInput.nextDouble();
		double area= pi * radius * radius;
		System.out.print("The area is: " + area + "\n");
	}

	public static void excercise_2_3() {
		// Homework 2.3
		Scanner readInput = new Scanner(System.in);
		System.out.println();
		System.out.print("What is your first name?: ");
		// only use the first character
		char yourInitial = readInput.next().charAt(0);
		readInput.nextLine();
		System.out.println("Hello Mr. " + yourInitial + ".");
		
		//extra line feed
		System.out.println();
		System.out.printf("5185 is fun course.\n\n");
		System.out.printf("First Name \tLast Name\tCity\n");
		System.out.printf("----------- \t---------\t---\n");
		System.out.printf("Bill \tClinton \tHarlem\n");
		System.out.printf("\n");
		//extra line feed
		System.out.println();
		System.out.printf("How do you print double quotes?\n");
		System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");
		
		// extra input
		System.out.println();
		System.out.print("Plase enter your first name: ");
		String firstName = readInput.next();
		System.out.print("Plase enter your last name: ");
		String lastName = readInput.next();
		System.out.print("Plase enter your city: ");
		String city = readInput.next();
		System.out.print("Plase enter your zip code: ");
		String zipCode = readInput.next();
		// show result 
		System.out.println();
		System.out.printf("First Name \tLast Name\tCity\t\tZip Code\n");
		System.out.printf("----------- \t---------\t---\t\t----\n");
		System.out.printf("%s     \t%s   \t%s \t%s\n", firstName, lastName, city, zipCode);
		System.out.printf("\n");
		
	}
	
	
	public static void excercise_2_3_sol() {
		// Homework 2.3
		Scanner readInput = new Scanner(System.in);
		System.out.println();
		// extra input
		System.out.println();
		System.out.print("Plase enter your first name: ");
		String firstName = readInput.next();
		System.out.print("Plase enter your last name: ");
		String lastName = readInput.next();
		System.out.print("Plase enter your city: ");
		String city = readInput.next();
		System.out.print("Plase enter your zip code: ");
		int zipCode = readInput.nextInt();
		// show result 
		System.out.println();
		System.out.printf("First Name \tLast Name\tCity\t\tZip Code\n");
		System.out.printf("----------- \t---------\t---\t\t----\n");
		// line formatting
		System.out.printf("%16s%16s%16s%5d", firstName ,lastName, city, zipCode);
		System.out.println();
		System.out.printf("%-16s%-16s%-16s%5d", firstName ,lastName, city, zipCode); 
		System.out.printf("\n");
		
	}
	
	public static void main(String[] args) {
//		System.out.println("----------Homework 2.1-----------");
//		excercise_2_1();
//		System.out.println("----------Homework 2.2-----------");
//		excercise_2_2();
//		System.out.println("----------Homework 2.3-----------");
//		excercise_2_3();
		excercise_2_3_sol();
		
	}

}
