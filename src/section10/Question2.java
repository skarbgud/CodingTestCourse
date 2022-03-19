package section10;

import java.util.Scanner;

public class Question2 {
	static int[] dy;

	public int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;
		for (int i = 3; i <= n+1; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		// 건넌 후의 값이기 때문에 n+1
		return dy[n+1];
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // 계단 수
		dy = new int[n + 2];
		System.out.println(T.solution(n));
	}
}