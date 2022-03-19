package section9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	public int vex; // 정점
	public int cost; // 비용

	public Edge(int vex, int cost) {
		this.vex= vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge ob) {
		// cost 순으로 오름차순
		// 가장 작은 값을 우선으로
		return this.cost - ob.cost;
	}
}

public class Question5 {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph; // 가중치 저장 ArrayList
	static int[] dis;

	public void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		while(!pQ.isEmpty()) {
			// PriorityQueue에서 비용이 가장 작은 순으로 poll하게 된다. 
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			// 기존의 값이 이미 더 작은 값이라 for문으로 돌 필요가 없어서 해당 정점은 비교할 필요가 없어서 패스
			if (nowCost > dis[now]) {
				continue;
			}
			// 해당 정점과 연결된 정점들에 대한 비용들을 모두 비교함
			for (Edge ob : graph.get(now)) {
				// 현재의 정점간의 거리가 현재 정점까지의 거리 + 연결된 정점들간의 거리들을 더해서 작은 값이면 적은 값으로 세팅
				if (dis[ob.vex] > nowCost + ob.cost) {
					// 정점까지의 거리를 현재까지의 거리 + 이어지는 거리로 세팅
					dis[ob.vex] = nowCost + ob.cost;
					// 우선순위 큐에 해당 정점에 다시 넣는다
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // 정점의 개수
		m = kb.nextInt(); // 간선의 개수
		// (같은 노드에 방향이 여러개인 가중치의 선이 여러개 일 수 있어서 ArrayList로 선언함)
		// 정점에 대한 정보를 담고 있는 ArrayList(위에)의 ArrayList<>
		graph = new ArrayList<ArrayList<Edge>>(); 
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			graph.get(a).add(new Edge(b,c));
		}
		T.solution(1);
		for (int i = 2; i <= n; i++) {
			if (dis[i] != Integer.MAX_VALUE) {
				System.out.println(i+ " : " + dis[i]);
			}
			else {
				System.out.println(i + ": impossible");
			}
		}
	}
}