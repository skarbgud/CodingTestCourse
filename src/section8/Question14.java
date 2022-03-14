package section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSPoint {
	int x, y;

	public BFSPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Question14 {
	// 방향값
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int answer = 0, n;
	static Queue<BFSPoint> queue = new LinkedList<>();

	public void BFS(int x, int y, int[][] board) {
		queue.add(new BFSPoint(x, y));
		while (!queue.isEmpty()) {
			BFSPoint pos = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				// 경계면을 벗어나지 않고
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
					// 방문해서 0으로 바꾸기
					board[nx][ny] = 0;
					queue.add(new BFSPoint(nx, ny));
				}
			}
		}
	}

	public void solution(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answer++;
					// 출발점을 0으로 바꿔놓기
					board[i][j] = 0;
					BFS(i, j, board);
				}
			}
		}
	}

	public static void main(String[] args) {
		Question14 T = new Question14();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		T.solution(arr);
		System.out.println(answer);
	}
}