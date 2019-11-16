package test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Demographer {
	List<Person> persons = new ArrayList<>();
	static int inputMismatchExceptionCount, ageRangeExceptionCount, dataRangeExceptionCount;

	public static void main(String[] args) {
		Demographer dem = new Demographer();
		dem.getInputs();
		for (Person p : dem.persons) 
			System.out.printf("%s \t %d \t %f%n", p.name, p.age, p.salary);
	}
	void getInputs() {
		String name = null;
		int age =0;
		double salary = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("How many people's data?");
		int number = input.nextInt();
		input.nextLine();  //this is to absorb the new-line character from input as nextInt() doesn’t take newline character
		int count = 0;
		while (count < number) {
			System.out.println("Enter name");
			name = input.nextLine();
			System.out.println("Enter age");
			try {
				age = input.nextInt();
				input.nextLine();  // absorb the new-line character 
				if (age < 18 || age > 120) throw new InvalidDataRangeException(); 
				System.out.println("Enter salary");
				salary = input.nextDouble();
				input.nextLine(); // absorb the new-line character 
				if (salary < 0) throw new InvalidDataRangeException(); 
				persons.add(new Person(name, age, salary));
				count++;
			} catch (InputMismatchException e) {
				input.nextLine(); // absorb the new-line character 
				System.out.println("Invalid data. Entry discarded. Please re-enter");
				inputMismatchExceptionCount++;
			} catch (InvalidDataRangeException e) {
				try {
					if (age < 18 || age > 120) throw new InvalidAgeRangeException();
					if (salary < 0) System.out.println("Salary cannot be negative");
				} catch (InvalidAgeRangeException e1) {
					System.out.println("Age must be between 18 and 120");
				}
			}
		} //end while (count < number)
		System.out.println
		("Input-mismatch exceptions: " + 
				inputMismatchExceptionCount);
		System.out.println
		("Data-range exceptions: " + 
				dataRangeExceptionCount);
		System.out.println
		("Age-range exceptions: " + 
				ageRangeExceptionCount);
	} //end getInputs()


	class InvalidDataRangeException extends Exception {
		InvalidDataRangeException() {
			System.out.println
			("Entry discarded. Invalid data range!");
			dataRangeExceptionCount++;
		} 
	} //end InvalidDataRangeException

	class InvalidAgeRangeException extends RuntimeException {
		InvalidAgeRangeException() { 
			ageRangeExceptionCount++; 
		} 

	} //end InvalidAgeRangeException

} //end Demographer




class Person {
	String name;
	int age;
	double salary;

	Person (String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary; 
	}
}
