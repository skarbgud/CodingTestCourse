package section7;

import java.util.Scanner;

public class Question10 {
	static int n, m, answer = 0;
	static int[][] graph;
	static int [] ch;
	
	public void DFS (int v) {
		if (v == n) {
			answer++;
		} else {
			// 1번 노드부터 n번 노드까지
			for (int i = 1; i <= n; i++) {
				// 점이 있어야하고 방문하지 않은 노드
				if (graph[v][i] == 1 && ch[i] == 0) {
					ch[i] = 1; // 체크 표시
					DFS(i);
					// back 한 시점이므로 체크 취소
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Question10 T = new Question10();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new int[n+1][n+1];
		ch = new int[n+1];
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = 1;
		}
		ch[1] = 1;
		T.DFS(1);
		System.out.println(answer);
	}
}