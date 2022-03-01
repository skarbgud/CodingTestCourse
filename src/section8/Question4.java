package section8;

import java.util.Scanner;

public class Question4 {
	static int[] pm;
	static int n, m;
	
	public void DFS(int  L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x+ " ");
			}
			System.out.println();
		} else {
			// 인덱스 마다 DFS의 레벨에 맞게 배열에 삽입
			// i가 앞자리로 잡고 DFS로 계속해서 모든 배열을 돌면서 뒤에 값 호출
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		pm = new int[m];
		T.DFS(0);
	}
}