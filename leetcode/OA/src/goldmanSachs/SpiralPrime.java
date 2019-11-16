package goldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpiralPrime {
	private static int[] solution(int [][] grid) {
		List<Integer> ret = new ArrayList<>();
		int r1 = 0, r2 = grid.length - 1;
		int c1 = 0, c2 = grid[0].length - 1;
		while(r1 <= r2 && c1 <= c2) {
			for (int i = c1; i <= c2; i++) 
				if(isPrime(grid[r1][i]))
					ret.add(grid[r1][i]);
			for (int i = r1 + 1; i <= r2; i++) 
				if(isPrime(grid[i][c2]))
					ret.add(grid[i][c2]);
			for (int i = c2 - 1; i > c1; i--) 
				if(isPrime(grid[r2][i]))
					ret.add(grid[r2][i]);
			for (int i = r2; i > r1; i--) 
				if(isPrime(grid[i][c1]))
					ret.add(grid[i][c1]);
			r1++;
			r2--;
			c1++;
			c2--;
		}
	    int[] retArray = new int[ret.size()];
	    for (int i=0; i < retArray.length; i++)
	    {
	        retArray[i] = ret.get(i).intValue();
	    }
		return retArray;
	}
	private static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2 || num == 3) return true;
		if (num % 6 != 5 && num % 6 != 1) return false; // all primes are in format 6x+1 or 6x-1 except for 2 and 3
		for (int i = 2; i < Math.sqrt(num); i++)
			if (num % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// test
		int [][] grid = {{7, 7, 3, 8, 1},
				{13, 5, 4, 5, 2}, 
				{9, 2, 12, 3, 9},
				{6, 12, 1, 11, 41}};
		System.out.println(Arrays.toString(solution(grid)));
	}
}
