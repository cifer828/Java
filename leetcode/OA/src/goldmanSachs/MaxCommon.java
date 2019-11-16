package goldmanSachs;

public class MaxCommon {
	public static void main(String[] args) { 
		// test case
		String case1 = "aabbbbaa";
		String case2 = "";
		String case3 = "abcdedeara";
		System.out.printf("%s, %d\n", case1, solution(case1));
		System.out.printf("%s, %d\n", case2, solution(case2));
		System.out.printf("%s, %d\n", case3, solution(case3));

	}
	private static int solution(String input) {
		// char count on right and left
		int [] right = new int [26];
		int [] left = new int[26];
		int max = 0, cur = 0;
		for (char c: input.toCharArray()){
			right[c - 'a']++;
		}
		for (char c: input.toCharArray()) {
			if (left[c - 'a'] >= right[c - 'a']) {
				cur--;
			}
			// right should be 2 or more larger than left
			else if (right[c - 'a'] - left[c - 'a'] > 1) {
				cur++;
			}
			left[c - 'a']++;
			right[c - 'a']--;
			max = Math.max(max, cur);
		}
		return max;
	}
	
}
