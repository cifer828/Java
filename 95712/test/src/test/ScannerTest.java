package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
//		Scanner input = new Scanner(System.in);
		Scanner input;
		input = new Scanner(System.in);
		int a = input.nextInt();
		String b = input.next();
		String c = input.nextLine();
		String d = input.nextLine();
		input.close();

	}
}
