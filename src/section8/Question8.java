package section8;

import java.util.Scanner;

public class Question8 {
	// b => 컴비네이션 값, p => 순열 , ch => 체크배열
	static int[] b, p, ch;
	// n 숫자, f 파이널넘버
	static int n, f;
	// 답 판별수
	boolean flag = false;
	// 메모이제이션
	int[][] dy = new int[35][35];

	// combination 함수
	public int combi(int n, int r) {
		if (dy[n][r] > 0) {
			return dy[n][r];
		}
		if (n == r || r == 0) {
			return 1;
		} else {
			return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
		}
	}

	public void DFS(int L, int sum) {
		if (L == n) {
			// false인 것들이 모두 리턴되서 끝나버림
			if (flag) {
				return;
			}
			if (sum == f) {
				for (int x : p) {
					System.out.print(x + " ");
					// 값을 발견하면 true로 바꿔서 그다음 콜스택 다 없애버리기
					flag = true;
				}
			}
		} else {
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					p[L] = i;
					DFS(L + 1, sum + (p[L] * b[L]));
					ch[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Question8 T = new Question8();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		f = kb.nextInt();
		b = new int[n];
		p = new int[n];
		ch = new int[n + 1];
		for (int i = 0; i < n; i++) {
			b[i] = T.combi(n - 1, i);
		}
		T.DFS(0, 0);
	}
}