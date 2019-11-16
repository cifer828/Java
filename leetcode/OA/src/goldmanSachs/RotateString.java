package goldmanSachs;

public class RotateString {
	private static String solution(String origin, int [] direction, int[] amount) {
		int finalRo = 0;
		for (int i = 0; i < direction.length; i++) {
			if (direction[i] == 0)
				finalRo -= amount[i];
			else {
				finalRo += amount[i];
			}
		}
		return rotate(origin, finalRo);
	}
	private static String rotate(String origin, int finalRo) {
		StringBuilder sb = new StringBuilder();
		int len = origin.length();
		if (finalRo >= 0) {
			sb.append(origin.substring(len - finalRo));
			sb.append(origin.substring(0, len - finalRo));
		}
		else {
			sb.append(origin.substring(-finalRo));
			sb.append(origin.substring(0, - finalRo));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// test
		String s = "huart";
		int dir[] = new int[]{1,0,1,0,1};
		int amount[] = new int[]{10, 10, 10, 12, 0};
		System.out.println(solution(s, dir, amount));
	}
}
