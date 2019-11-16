package goldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridGame {
	private static List<List<Integer>> solution (List<List<Integer>> grid, int k, int [] rules){
		int m = grid.size();
		int n = grid.get(0).size();
		int [][] alive = new int[m][n];
		for (int i = 0; i < k; i++) {
			for (int row = 0; row < m; row++)
				for (int col = 0; col < n; col++)
					alive[row][col] = neighborAlive(grid, row, col);
			for (int row = 0; row < m; row++)
				for (int col = 0; col < n; col++)
					grid.get(row).set(col, rules[alive[row][col]]);
			for (int[] a : alive)
				System.out.println(Arrays.toString(a));
			System.out.println(grid.toString());
		}
		return grid;
	}
	private static int neighborAlive(List<List<Integer>> grid, int row, int col) {
		int m = grid.size();
		int n = grid.get(0).size();
		int ret = 0;
		for (int i = Math.max(0, row - 1); i < Math.min(m, row + 2); i++) 
			for (int j = Math.max(0, col - 1); j < Math.min(n, col + 2); j++)
				if (row != i || col != j)
					ret += grid.get(i).get(j);
		return ret;
	}
	public static void main(String[] args) {
		// test
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(new ArrayList<>(Arrays.asList(0,1,1,0)));
		grid.add(new ArrayList<>(Arrays.asList(1,1,0,0)));
		
		int k = 2;
		int[] rules = {0, 0, 0, 1, 0, 1, 0, 0, 0,};
		solution(grid, k, rules);
	}
}
