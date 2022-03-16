package section8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Question15 {
	static int n, m, len, answer = Integer.MAX_VALUE;
	static int[] combi;
	// hs 집들의 좌표, pz 피자집들의 좌표
	static ArrayList<Position> hs, pz;

	public void DFS(int L, int s) {
		if (L == m) {
			// 도시의 피자 배달 거리의 합
			int sum = 0;
			for (Position h : hs) {
				int dis = Integer.MAX_VALUE;
				for (int i : combi) {
					// dis => 해당 집의 피자 배달 거리
					dis = Math.min(dis,
							// h.x 는 combi에서 구한 집의 좌표, 피자집의 좌표는 get(i)를 통해 좌표값 얻기
							// 절대값으로 x좌표, y좌표의 값을 더해줘서 거리를 계산한다.
							Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
				}
				// 각 집들마다 거리를 합산한다.
				sum += dis;
			}
			// 기존의 값이랑 비교해서 답에는 거리의 합중에 가장 작은 값으로 넣기
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				// 조합수 구하기
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) {
		Question15 T = new Question15();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		pz = new ArrayList<>();
		hs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = kb.nextInt();
				// 집일때
				if (tmp == 1) {
					hs.add(new Position(i, j));
				}
				// 피자집일때
				else if (tmp == 2) {
					pz.add(new Position(i, j));
				}
			}
		}
		// 피자집의 개수
		len = pz.size();
		// len C m
		combi = new int[m];
		// 조합
		T.DFS(0, 0);
		System.out.println(answer);
	}
}