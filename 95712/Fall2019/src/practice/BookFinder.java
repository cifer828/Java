package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookFinder {
	private String fileName;
	private String searchString;
	
	private void getUserInputs() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name:");
		fileName = input.nextLine();
		System.out.println("Enter what you are looking for");
		searchString = input.nextLine();
		input.close();
	}
	private StringBuilder loadRecords() {
		StringBuilder sb = new StringBuilder();
		Scanner fileInput = null;
		try {
			fileInput = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInput = fileInput.useDelimiter(";");
		while (fileInput.hasNext()) {
			sb.append(fileInput.next() + ";");
		}
		return sb;
	}
	private String[] searchRecords(StringBuilder fileContent) {
		String combinedResult = "";
		String [] records = fileContent.toString().split("\n");
		for (String r: records) {
			if (r.toLowerCase().contains(searchString.toLowerCase()))
				combinedResult += r + "\n";
		}
		if (combinedResult.length() < 1)
			return null;
		else 
			return combinedResult.split("\n");
	}
	private void printOutput(String[] fileRecords) {
		if (fileRecords == null) {
			System.out.println("Found records: 0");
			System.out.println("Sorry " + searchString + " not found in " + fileName);
		}
		else {
			System.out.println("Found records: " + fileRecords.length);
			for (String fr: fileRecords)
				System.out.println(fr);
		}
	}
	
	public static void main(String[] args) {
		BookFinder bf = new BookFinder();
		bf.getUserInputs();
		StringBuilder sb = bf.loadRecords();
		String [] sr = bf.searchRecords(sb);
		bf.printOutput(sr);

	}

}
