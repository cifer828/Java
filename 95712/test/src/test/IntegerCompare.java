package test;

import java.util.ArrayList;
import java.util.List;

public class IntegerCompare {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(13330);
		list.add(13330);
		System.out.println(list.get(0) == list.get(1));
	}
}
