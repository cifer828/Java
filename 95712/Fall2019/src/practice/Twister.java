package practice;

public class Twister {
	public static String [] twist(String[] names) {
		System.out.println("*** Twisted names ***");
		int n = names.length;
		for (int i = 0; i < n / 2; i++) {
			StringBuilder left = new StringBuilder(names[i]);
			StringBuilder right = new StringBuilder(names[n - i - 1]);
			names[i] = right.reverse().toString();
			names[n - i - 1] = left.reverse().toString();
		}
		for (String na : names)
			System.out.println(na);
		return names;
	}
	public static int[] twist(int[] numbers) {
		System.out.println("*** Twisted numbers ***");
		int n = numbers.length;
		for (int i = 0; i < n / 2; i++) {
			StringBuilder left = new StringBuilder(String.valueOf(numbers[i]));
			StringBuilder right = new StringBuilder(String.valueOf(numbers[n - i - 1]));
//			System.out.println(right.reverse().toString());
			numbers[i] = Integer.parseInt(right.reverse().toString());
			numbers[n - i - 1] = Integer.parseInt(left.reverse().toString());
		}
		for (int nu: numbers)
			System.out.println(nu);
		return numbers;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] someNames = {"James", "Anne", "Zach", "Bob"};
		int [] someNumbers = {43, 67, 12, 90};
		twist(someNames);
		twist(someNumbers);
	}

}
