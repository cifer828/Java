package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesOnFlight {
	public static void main(String[] args) {
		int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
		int d1 = 250;
		int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
		int d2 = 250;
		int[] movie_duration3 = {90, 85, 75, 60, 120,110,110, 150, 125};
		int d3 = 250;
		System.out.println(Arrays.toString(myMethod(movie_duration1, d1-30)));
		System.out.println(Arrays.toString(myMethod(movie_duration2, d2-30)));
		System.out.println(Arrays.toString(myMethod(movie_duration3, d3-30)));
	}

	private static int[] get2SumClosest(int[] movie_duration, int d) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<movie_duration.length;i++) {
			map.putIfAbsent(movie_duration[i], new ArrayList<>());
			map.get(movie_duration[i]).add(i);
		}
		Arrays.sort(movie_duration); 
		int l = 0, r = movie_duration.length - 1;
		int max = 0;
		int[] res = new int[]{-1, -1};
		while(l < r) {
			int sum = movie_duration[l] + movie_duration[r];
			if((sum > max || (sum == max && Math.max(movie_duration[l] , movie_duration[r]) > Math.max(res[0],  res[1]))) && sum <= d) {
				max = sum;
				res[0] = movie_duration[l];
				res[1] = movie_duration[r];
			}
			if(sum > d)
				r--;
			else
				l++;
		}
		if(map.get(res[0]) == map.get(res[1])) {
			res[0] = map.get(res[0]).get(0);
			res[1] = map.get(res[1]).get(1);
		}else {
			res[0] = map.get(res[0]).get(0);
			res[1] = map.get(res[1]).get(0);
		}
		return res;
	}
	
	public static int[] myMethod(int [] moviDuration, int d) {
		List<Integer> index = new ArrayList<Integer>();
		
		for (int i = 0; i < moviDuration.length; i++) {
			index.add(i);
		}
		// sort index list by the value at it, thus it's consistent with sorted movieDuration
		// index of same value may not be strictly corresponded to the array, but it should be fine
		Collections.sort(index, (idx1, idx2) -> moviDuration[idx1] - moviDuration[idx2]);
		Arrays.sort(moviDuration);
		
		int left = 0, right = moviDuration.length - 1;
		int maxDuation = 0;
		int[] retPair = {-1, -1};
		while(left < right) {
			int sumDuration = moviDuration[left] + moviDuration[right];
			if (sumDuration <= d) {
				// save the pair if 
				// 1. their sum > max sum
				// 2. their sum == max sum, and they hold a longer movie than the current result pair
				if ((sumDuration > maxDuation) || 
				(maxDuation == sumDuration && Math.max(moviDuration[left], moviDuration[right]) > Math.max(moviDuration[retPair[0]], moviDuration[retPair[1]]))) {
					retPair[0] = left;
					retPair[1] = right;
					maxDuation = sumDuration;
				}
				left++;
			}
			else {
				right--;
			}
		}
		return new int[] {index.get(retPair[0]), index.get(retPair[1])};
	}
}
