package goldmanSachs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class SrangeSort {
	private static String[] solution (int [] mapping, String [] nums) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < mapping.length; i++) {
			map.put((char) (mapping[i] + '0'), i); 
		}
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String  o1, String  o2) {
				// TODO Auto-generated method stub
				StringBuilder sb1 = new StringBuilder();
				for (char c: o1.toCharArray()) {
					sb1.append(map.get(c));
				}
				StringBuilder sb2 = new StringBuilder();
				for (char c: o2.toCharArray()) {
					sb2.append(map.get(c));
				}
				int res = Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString());
				return res;
			}
		});
		return nums;
	}
	public static void main(String[] args) {
		// test
        int mapping1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int mapping2[] = {3, 5, 4, 6, 2, 7, 9, 8, 0, 1};
        int mapping3[] = {2, 1, 4, 8, 6, 3, 0, 9, 7, 5};
        String nums1[] = {"990", "332", "2", "122"};
        String nums2[] = {};
        String nums3[] = {"12", "02", "4", "023", "65", "83", "224", "50"};
//        System.out.println(Arrays.toString(solution(mapping1, nums1)));
        System.out.println(Arrays.toString(solution(mapping2, nums1)));
        System.out.println(Arrays.toString(solution(mapping3, nums3)));
	}
}
