package test;

import java.util.Scanner;

public class switchNew {
	public static void main(String[] srgs) {
	String line;
	Scanner input = new Scanner(System.in);
	System.out.println("How many lines of input?");
	int n = input.nextInt();
	for (int i = 0; i < n; i++) {
	line = input.nextLine();
	System.out.println(line);
	}}


}
