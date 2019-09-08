import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Type a word: ");
		String word = input.next();
		boolean isPal = true;
		for(int i=0,j=word.length()-1;i<j;i++,j--){
			if(word.charAt(i)!=word.charAt(j)){
				isPal = false;
				break;
			}
		}
		if(isPal)
			System.out.println("It's a palindrome");
		else
			System.out.println("It's not a palindrome");
	}
}
