package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zipcoder {
	Map<String, Zipcode> zipcodes = new HashMap<>();
	public void readZipcodes() {
		String[] fields = null;
		try (Scanner input = new Scanner(new File("zipcodes.txt"))) {
			while (input.hasNextLine()) {
				fields = input.nextLine().split(",");
				Zipcode z = new Zipcode(fields[0].trim(), fields[1].trim(), fields[2].trim());
				zipcodes.put(fields[0], z); //fields[0] is the key
			}
		} catch (FileNotFoundException e) { e.printStackTrace(); }
	}

	public Zipcode findZipcode(String zipcode) {
		return zipcodes.get(zipcode);  //returns null, if not found
	}
	public void printZipcodes() {
		int count = 1;
		System.out.println("    Zip         County                  City");
		System.out.println("--------------------------------------------");
		for (Map.Entry<String, Zipcode> z: zipcodes.entrySet()) {
			System.out.printf("%2d. %s\t%-20s\t%s%n", 
					count++, z.getKey(), z.getValue().county, z.getValue().city);
			if (count > 10) {
				System.out.println("... breaking at 10");  //to stop printing as there are too many.
				break;
			}
		} System.out.println("--------------------------------------------");
	}
	public static void main(String[] args) {
		Zipcoder zc = new Zipcoder();
		zc.readZipcodes();
		zc.printZipcodes();
		System.out.printf("Zipcode count: %,d%n", zc.zipcodes.size());
		System.out.println("Enter zipcode to search");
		Zipcode z = zc.findZipcode(new Scanner(System.in).nextLine());
		if (z != null) System.out.printf("Zip: %s%nCounty: %s%nCity: %s%n", z.zip, z.county, z.city);
		else System.out.println("Zipcode not found!");
		
	}}


