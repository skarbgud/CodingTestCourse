package section10;

import java.util.Scanner;

public class Question1 {
	static int[] dy;

	public int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;
		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		return dy[n];
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // 계단 수
		dy = new int[n + 1];
		System.out.println(T.solution(n));
	}
}