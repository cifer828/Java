package goldmanSachs;

import java.util.Arrays;


public class matrixGame {
	private static int solution(int [][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int [] maxInRow = new int[n];
		for (int j = 0; j < n; j++) {
			int max = matrix[0][j];
			for (int i = 0; i < m; i++)
				max = Math.max(max, matrix[i][j]);
			maxInRow[j] = max;
		}
		Arrays.sort(maxInRow);
		int diff = 0;
		for (int i = n - 1; i >= 0; i--) {
			int s = maxInRow[i];
			if (i % 2 == 0)
				diff += s;
			else {
				diff -= s;
			}
		}
		return Math.abs(diff);
	}
	public static void main(String[] args) {
		// test
		int [][] matrix = {{3, 7, 5, 3, 4, 5}, {4, 5, 2, 6, 5, 4}, {7, 4, 9, 7, 8 ,3}};
      int[][] matrix2 = {
      {5,7,6,2,8,4,4,8},
      {2,5,4,5,9,8,4,2},
      {5,4,3,9,8,3,3,4},
      {4,9,3,4,6,7,4,9},
      {2,4,6,2,9,2,4,2}};
		System.out.println(solution(matrix2));
	}
}
