import java.util.Scanner;

public class IsPrime {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Type an integer: ");
		int n = input.nextInt();
		boolean isPrime;
		if(n==1)
			isPrime = false;
		else{
			isPrime = true;
			for(int i=2; i<=Math.sqrt(n);i++)
				if(n % i == 0){
					isPrime = false;
					break;
				}
		}
		if(isPrime)
			System.out.println("It's a prime");
		else
			System.out.println("It's not a prime");
	}
}
