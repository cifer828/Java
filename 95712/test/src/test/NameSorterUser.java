package test;

import java.util.Arrays;

public class NameSorterUser {
	public static void main(String[] args) {
		String[] names = new String[5];
		NameSorter ns = new NameSorter();
		ns.sortNames(names);
//		try {
//			ns.sortNames(names);
//		}
//		catch (Exception e) {
//			System.out.println("rua");
//		}
	}
}

class NameSorter {
	void sortNames(String[] names) throws NullPointerException {
		Arrays.sort(names);
	}
}
