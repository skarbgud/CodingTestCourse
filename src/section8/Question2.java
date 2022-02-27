package section8;

import java.util.Scanner;

public class Question2 {
	static int answer = Integer.MIN_VALUE, c, n;
	
	public void DFS(int L, int sum, int[] arr) {
		// c 무게보다 넘어가면 뻗어나가면 안된다.
		if (sum > c) return;
		if (L == n) {
			// 기존의 answer과 sum값을 비교해서 가장 최대값을 해서 담을 수 있는 최대값 도출
			answer = Math.max(answer, sum);
		}
		else {
			DFS(L+1, sum + arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	
	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);
		c = kb.nextInt();
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}
}