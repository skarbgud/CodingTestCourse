package section8;

import java.util.Scanner;

public class Question1 {
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false;
	public void DFS(int L, int sum, int[] arr) {
		if (flag) return; // 나머지 스택에 있는 재귀들은 날려버리기
		if (sum > total/2) return; // 합이 이미 /2보다 크면 비교할 필요도 없다
		if (L == n) {
			if ((total - sum) == sum) { // 절반이 되었을때 (or /2도 가능)
				answer ="YES";
				flag = true;
			}
		}
		else {
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	
	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}
}