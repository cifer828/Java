package goldmanSachs;

import java.util.Arrays;
import java.util.Comparator;

//class Score implements Comparable<Score>{
//	int totalScore;
//	int index;
//	public Score(int [] score, int index) {
//		// TODO Auto-generated constructor stub
//		totalScore = sum(score);
//		this.index = index;
//	}
//	@Override
//	public int compareTo(Score o) {
//		// TODO Auto-generated method stub
//		return this.totalScore - o.totalScore;
//	}
//	private int sum (int [] score) {
//		int sum = 0;
//		for (int s: score)
//			sum += s;
//		return sum;
//	}
//}

public class FindRank {
	private static int solution(int [][] performance, int rank) {
		int [][] scores = new int[performance.length][2];
		for (int i = 0; i < performance.length; i++) {
			scores[i][0] = sum(performance[i]);
			scores[i][1] = i;
		}
		Arrays.sort(scores, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}});

		return scores[rank - 1][1];
	}
	private static int sum (int [] score) {
		int sum = 0;
		for (int s: score)
			sum += s;
		return sum;
	}
	public static void main(String[] args) {
		// test
		int [][] perf = {{78, 89, 15}, {85, 89, 92}, {71, 96, 88}};
		int rank = 2;
		System.out.println(solution(perf, rank));
	}

}
