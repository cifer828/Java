import java.util.Scanner;

public class PrimeNumbers {
	public static boolean isPrime(int n){
		// determine whether n is prime
		boolean isprime = true;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n % i == 0){
				isprime = false;
				break;
			}
		}
		return isprime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("How many primes do you want?");
		int pNumber = input.nextInt();
		int catchedPrimes = 0;
		int number = 1;
		while(catchedPrimes < pNumber){
			number++;
			if(isPrime(number)){
				System.out.println(number);
				catchedPrimes++;
			}
		}
	}
}
