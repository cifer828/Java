package lab6;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
	public static void main(String[] args) {
		Movie m1 = new Movie("Back to the Future", "1985");
		Movie m2 = new Movie("Back to the future", "1985");
		System.out.printf("Movie1: %s, hash code: %d\n", m1.movieName, m1.hashCode());
		System.out.printf("Movie1: %s, hash code: %d\n", m2.movieName, m2.hashCode());
		List<Integer> list = new ArrayList<>();
		list.remove(1);
	}
}
