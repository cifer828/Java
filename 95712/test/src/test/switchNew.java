package test;

import java.util.Scanner;

public class switchNew {
	public static void main(String[] args) {
		int[] x = {10, 20}; //original
		someMethod(x);
		System.out.println(x[0]);
		}
		public static void someMethod(int[] x) {
		x[0]++;	
		}


}
