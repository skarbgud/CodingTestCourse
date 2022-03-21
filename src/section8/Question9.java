package section8;

import java.util.Scanner;

public class Question9 {
	// 컴비네이션 값
	static int[] combi;
	static int n, m;
	
	public void DFS(int L, int s) {
		if (L == m) {
			for (int x : combi) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		else {
			// 넘어온 숫자부터
			for (int i = s; i <= n; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}

	public static void main(String[] args) {
		Question9 T = new Question9();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		T.DFS(0, 1);
	}
}