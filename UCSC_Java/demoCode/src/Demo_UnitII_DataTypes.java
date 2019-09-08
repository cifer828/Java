//To test these, just uncomment each section and then run them, and comment it back and uncomment another section and continue

/**************************************************************
Demo 1: Calculates the area for a fixed radius of 2 
***************************************************************/

public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		int    		radius = 2;
		double 		area;
		final double 	pi = 3.142;
		
		area= pi * radius * radius;

		System.out.print("The area is: ");
		System.out.println(area);
	}
}

/******************************************************************
Demo 2: Calculates the area after getting the radius from user
*******************************************************************/
/*
import java.util.Scanner;

public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		int    radius;
		double area;
		final double pi = 3.142;
		
		Scanner readInput = new Scanner(System.in);
		
		System.out.print("Enter the radius: ");
		radius = readInput.nextInt();
		
		area= pi * radius * radius;
	
		System.out.print("The area is: ");
		System.out.println(area);
	}
}

*/
/***************************************************************************
Demo 3: Data type demo along with print and println
*******************************************************************/
/*
import java.util.Scanner;

public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		byte    radius;
		double area;
		final double pi = 3.142;
		byte myChar='A';
		
		Scanner readInput = new Scanner(System.in);
		
		System.out.print("Enter the radius: ");
		radius = readInput.nextByte();
		
		area= pi * radius * radius;
	
		System.out.print("The area is: ");
		System.out.println(area);

		System.out.print("The character value is: ");
		System.out.print(myChar);
		
		System.out.println("The character value is: " + myChar);
	}
}
*/

/***************************************************************************
Demo 4: printf, format specifier and escape sequences
*******************************************************************/
/*
public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		System.out.printf("5185 is fun course");
		System.out.printf("\rHello Student");
		System.out.printf("\nHello World\n");
		System.out.printf("\n");

		System.out.printf("First Name \tLast Name\tCity\n");
		System.out.printf("----------- \t---------\t---\n");
		System.out.printf("Bill        \tClinton  \tHarlem\n");

		System.out.printf("\n\n");
		System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");
	}
}
*/

/******************************************************************
Demo 5: byte as char and number
*******************************************************************/
/*
public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		byte myChar='A';
		byte myNumber= 65;
		
        String myString = "Hello how are you";
        
		System.out.printf("The myChar with %%c is     : %c \n", myChar);
		System.out.printf("The myChar with %%d is     : %d \n", myChar);
		System.out.printf("The myNumber with %%d is   : %d \n", myNumber);
		System.out.printf("The myNumber with %%c is   : %c \n", myNumber);

		System.out.printf("myChar with %%c is: %c, myNumber with %%d is: %d\n", myChar, myNumber);
		System.out.printf("myChar with %%d is: %d, myNumber with %%c is: %c\n", myChar, myNumber);
		
		System.out.printf("%s\n", myString);
	}
}
*/

/******************************************************************
Demo 6: char and number data type.  You can't format using %d a char
        type like you did with the byte type
*******************************************************************/
/*
public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		char myChar='A';
		int myNumber= 65;
		
        String myString = "Hello how are you";
        
		System.out.printf("The character value is: %c \n", myChar);
		System.out.printf("The character value is: %c \n", myNumber);

		//this is run time error: run to check
		System.out.printf("The character value is: %d \n", myChar);

		System.out.printf("%s\n", myString);
	}
}
*/

/******************************************************************
Demo 7: different data types
*******************************************************************/
/*
import java.util.Scanner;

public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		short numberOfStudents= 11;
		int   presidentsSalaray=400000;
		long  numberOfStars=100000;
		Scanner readInput = new Scanner(System.in);
		System.out.printf("Number of starts in our Milkyway: %d\n\n", numberOfStars);
		numberOfStars = 1000000000000L; // without L is error
		System.out.printf("Number of starts in our Universe: %d\n", numberOfStars);
		System.out.printf("Please enter number of students and presidents salary\n", 
				             numberOfStars);
		numberOfStudents = readInput.nextShort();
		presidentsSalaray=readInput.nextInt();
		System.out.printf("Number of students: " + numberOfStudents);
		System.out.printf("President's Salary + Bonus: " + presidentsSalaray * 1.25);
	}
}

*/
 /******************************************************************
demo 8: Control statements if, if .. else
*******************************************************************/
/*
import java.util.Scanner;

public class Demo_UnitII_DataTypes {
	public static void main(String[] args) {
		int yourAge;
		boolean bGotAdmitted;
		
		bGotAdmitted = true;
		if (bGotAdmitted)
			System.out.printf("You will get the grade");
		
		Scanner readInput = new Scanner(System.in);
		System.out.printf("How old are you?: ");
		yourAge= readInput.nextInt();
		if (yourAge != 50)
			System.out.printf("You are golden\n");
		else
			System.out.printf("You are not so golden\n");
		System.out.printf("I told you so", args);
			
	}
}
*/
