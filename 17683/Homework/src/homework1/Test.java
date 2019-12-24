package homework1;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < 10; i++) {
//			list.add(i);
//		}
//		for (int i = 0; i < list.size(); i++) {
//			list.remove(i);
//		}
//		System.out.println(list);
		iter(0);
//		String [] a1 = {"1", "2"};
//		myCopy(a1);
//		System.out.println(Arrays.toString(a1));
	}
	public static void myCopy(String [] a1) {
		String [] a2 = {"3", "4"};
		a1 = Arrays.copyOf(a2, a1.length);
	}
	public static void iter(int input) {
		System.out.println(input);
		if (input > 30000)
			return;
		iter(input * 2 + 1);
	}
}
