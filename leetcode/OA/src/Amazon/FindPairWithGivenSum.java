package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {
	public static void main(String[] args) {
		int[] nums1 = {1, 10, 25, 35, 60};
		int target1 = 90;
		System.out.println(Arrays.toString(find2Sum(nums1, target1)));
		int[] nums2 = {20, 50, 40, 25, 30, 10};
		int target2 = 90;
		System.out.println(Arrays.toString(find2Sum(nums2, target2)));
		int[] nums3 = {50, 20, 10, 40, 25, 30};
		int target3 = 90;
		System.out.println(Arrays.toString(find2Sum(nums3, target3)));
		int[] nums4 = {1, 2};
		int target4 = 90;
		System.out.println(Arrays.toString(find2Sum(nums4, target4)));
	}

	public static int[] find2Sum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int[] res = new int[] {-1, -1};
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				if(nums[i] > max || target - 30 - nums[i] > max) {
					res[0] = map.get(nums[i]);
					res[1] = i;
					max = Math.max(nums[i], nums[map.get(nums[i])]);
				}
			}
			map.put(target - 30 - nums[i], i);
		}
		return res;
	}
}
