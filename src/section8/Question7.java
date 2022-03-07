package section8;

import java.util.Scanner;

public class Question7 {
	int [][] dy = new int[35][35];
	public int DFS(int n, int r) {
		// 메모이제이션
		if (dy[n][r] > 0) {
			// 이미 구한 값을 리턴
			return dy[n][r];
		}
		// n과 r이 같은경우와 r이 0인 경우는 1이다.
		if (n == r || r == 0) {
			return 1;
		} else {
			// dy[n][r]에 저장을 하고 리턴한다.
			return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
		}
	}

	public static void main(String[] args) {
		Question7 T = new Question7();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int r = kb.nextInt();
		System.out.println(T.DFS(n, r));
	}
}