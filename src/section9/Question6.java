package section9;

import java.util.*;

public class Question6 {
	static int[] unf;

	// find는 해당 집합에 집합의 번호를 리턴
	public static int Find(int v) {
		if (v == unf[v]) {
			return v;
		} else {
			return unf[v] = Find(unf[v]);
		}
	}

	// 집합이 같도록 묶는 함수
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb)
			unf[fa] = fb;
	}

	public static void main(String[] args) {
		Question6 T = new Question6();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		unf = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			unf[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			// a와 b는 친구관계이다.
			Union(a, b);
		}
		int a = kb.nextInt();
		int b = kb.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if (fa == fb) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}