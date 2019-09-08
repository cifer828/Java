import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortInput {
	public static void main(String args[]){
		int [] intArray;
		Scanner input = new Scanner(System.in);
		System.out.print("Type integer number, n = ");
		int n = input.nextInt();
		System.out.println("Type integers, splited by space");
		intArray = new int [n]; 
		for(int i=0;i<n;i++)
			intArray[i] = input.nextInt();
		Arrays.sort(intArray);
		for(int i:intArray)
			System.out.print(i + " ");
	}
}
