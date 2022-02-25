package section7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question14 {
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int [] ch, dis;
	
	public void DFS (int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		queue.offer(v);
		while(!queue.isEmpty()) {
			// 현재 지점
			int cv = queue.poll();
			for (int nv : graph.get(cv)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					// 다음 간선의 길이는 cv+1
					dis[nv] = dis[cv] + 1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Question14 T = new Question14();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		dis = new int[n+1];
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}
		ch[1] = 1;
		T.DFS(1);
		for (int i = 2; i <=n; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}
}