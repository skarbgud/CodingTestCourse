package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question8 {
	int answer = 0;
	int[] dis = {1, -1, 5};
	int[] ch;
	Queue<Integer> Q = new LinkedList<>();
	public int BFS(int s, int e) {
		ch = new int[10001];
		ch[s] = 1;
		Q.offer(s);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // 큐에서 꺼낸다
				for(int j = 0; j < 3; j++) { // 가지수에 따른 가지들을 하위레벨에 Q에 담는다
					int nx = x+dis[j]; // 꺼낸값(부모노드)의 값에서 가지의 방법 -1, +1, +5의 방법으로 배열에 담고 방문되지않은 배열을 체크한다.
					if (nx == e) return L + 1; // 다음에 올 자식노드와 같다면 거리가 레벨(아직 순회가 끝나기전이니까 +1)값을 리턴
					// 방문되지 않은 배열을 체크한다.
					if (nx >=1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Question8 T = new Question8();
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(T.BFS(s, e));
	}
}