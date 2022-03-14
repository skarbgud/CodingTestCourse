package section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Question12 {
	// 방향값
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] board, dis;
	static int n, m;
	static Queue<Point> Q = new LinkedList<>();

	public void BFS() {
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					// 방문 처리
					board[nx][ny] = 1;
					// 새로운 Point 큐에 넣어줘서 BFS
					Q.offer(new Point(nx, ny));
					// dis에 걸린 일수를 꺼낸 것의 +1일씩 더해준다.
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Question12 T = new Question12();
		Scanner kb = new Scanner(System.in);
		m = kb.nextInt();
		n = kb.nextInt();
		board = new int[n][m];
		dis = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = kb.nextInt();
				if (board[i][j] == 1) {
					// BFS의 Queue (0레벨 세팅)
					Q.offer(new Point(i, j));
				}
			}
		}
		T.BFS();
		// 익지 않을 수가 있는지 확인하기 위한 flag
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 익지 않는 토마토가 있는지 확인해서 있으면 flag를 false로 세팅
				if (board[i][j] == 0) {
					flag = false;
				}
			}
		}
		// 다 익었다면
		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 거리의 dis배열 값 중 최대값 가져오기
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}
		// 익지 않는다면
		else {
			System.out.println(-1);
		}

	}
}