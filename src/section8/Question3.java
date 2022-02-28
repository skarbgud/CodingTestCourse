package section8;

import java.util.Scanner;

public class Question3 {
	static int answer = Integer.MIN_VALUE, n, m;
	boolean flag = false;
	
	public void DFS(int L, int sum, int time, int ps[], int[] pt) {
		// 시간이 최대 시간 m 보다 크면 리턴
		if (time > m) return;
		// L이 문제의 개수랑 같으면 최대값이랑 sum 중에 큰값 취하기
		if (L == n) {
			answer = Math.max(answer, sum);
		}
		else {
			DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
			DFS(L+1, sum, time, ps, pt);
		}
	}
	
	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);
		// 문제의 개수
		n = kb.nextInt();
		// 제한 시간
		m = kb.nextInt();
		// 점수
		int [] a = new int[n];
		// 제한시간
		int [] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = kb.nextInt();
			b[i] = kb.nextInt();
		}
		T.DFS(0, 0, 0, a, b);
		System.out.println(answer);
	}
}