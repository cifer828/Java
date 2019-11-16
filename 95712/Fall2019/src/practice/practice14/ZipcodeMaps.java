package practice.practice14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZipcodeMaps {
	private static Map<String, String> zipcodeMap = new HashMap<>();
	private static void loadFile(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			while(input.hasNextLine()) {
				String [] line = input.nextLine().split(",");
				String zipcode = line[0].trim();
				String countyAndCity = String.format("%s, %s", line[1].trim(), line[2].trim());
				if (zipcodeMap.containsKey(zipcode)) {
					String oldCountyAndCity = zipcodeMap.get(zipcode);
					// overwrite
					if (!oldCountyAndCity.equals(countyAndCity)) {
						System.out.printf("Overwrittern: %s, %s by %s, %s\n",
								zipcode, oldCountyAndCity, zipcode, countyAndCity);
						zipcodeMap.put(zipcode, countyAndCity);
					}
					// duplicate
					else {
						System.out.printf("Dupulicate found: %s, %s\n", zipcode, oldCountyAndCity);
					}
				}
				// new zipcode
				else {
					zipcodeMap.put(zipcode, countyAndCity);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void findZipcode() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter zipcode to search");
		String zipcode = input.next();
		String countyAndCity = zipcodeMap.get(zipcode);
		System.out.printf("Found county: %s. city:%s", countyAndCity.split(",")[0], countyAndCity.split(",")[1]);
		input.close();
	}
	public static void main(String[] args) {	
		loadFile("DirtyZipcodes.txt");
		findZipcode();
		
	}
	
}
