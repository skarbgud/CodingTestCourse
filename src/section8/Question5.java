package section8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {
	static int n, m, answer = Integer.MAX_VALUE;
	
	public void DFS(int  L, int sum, Integer[] arr) {
		// sum값보다 크면 돌 필요 없이 리턴
		if (sum > m) return;
		// 동전의 개수가 이미 answer보다 크면 돌 필요가 없다.
		if (L>=answer) return;
		if (sum == m) {
			// answer와 L(동전의 개수)중 최소값을 취한다.
			answer = Math.min(answer, L);
		}
		else {
			for (int i = 0; i < n; i++) {
				DFS(L+1, sum + arr[i], arr);
			}
		}
	}
	
	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		m = kb.nextInt();
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}
}