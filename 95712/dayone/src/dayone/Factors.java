// Name: Qiuchen Zhang
// Andrew ID: qiuchenz

package dayone;

import java.util.ArrayList;
import java.util.Scanner;

public class Factors {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number");
		int x = input.nextInt();
		
		// write your code here
		boolean isPrime = true;
		x = Math.abs(x);
		if(x==0) {
			System.out.println("Please enter a non-zero number");
			return;
		}
		else if(x > 1) {
			for(int i=2;i<x;i++)
				if(x % i==0) {
					System.out.println(i);
					isPrime = false;
				}
		}
		if(isPrime)
			System.out.println("This is a prime number!");
		input.close();
	}
}
