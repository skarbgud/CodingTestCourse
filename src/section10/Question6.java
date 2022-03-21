package section10;

import java.util.Scanner;

public class Question6 {
	public static void main(String[] args) {
		Question6 T = new Question6();
		Scanner kb = new Scanner(System.in);
		// n => 문제의 개수
		int n = kb.nextInt();
		// m => 제한시간
		int m = kb.nextInt();
		int[] dy = new int[m + 1];
		for (int i = 0; i < n; i++) {
			// 문제의 점수
			int ps = kb.nextInt();
			// 문제의 시간
			int pt = kb.nextInt();
			// 문제를 풀때마다 뒤에서부터 앞으로 점수의 값까지 pt인덱스만큼 빼고 ps를 더한다.
			for (int j = m; j >= pt; j--) {
				dy[j] = Math.max(dy[j], dy[j - pt] + ps);
			}
		}
		System.out.println(dy[m]);
	}
}