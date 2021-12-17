package section2;

import java.util.Scanner;

public class Question12 {
	public int solution(int n, int m, int[][] arr) {
		int answer = 0;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++) // (i,j)로 경우의 수 구하는 for문
			{
				int cnt = 0; // i,j 짝이 test개수만큼 된다면 cnt 증가
				for (int k = 0; k < m; k++)
				{
					int pi = 0; // i번 학생 등수 값을 위한 포지션값
					int pj = 0; // j번 학생 등수 값을 위한 포지션값

					for (int s = 0; s < n; s++)
					{
						if (arr[k][s] == i) 
						{
							pi = s;
						}
						if (arr[k][s] == j) 
						{
							pj = s;
						}
					}
					if (pi < pj) 
					{
						cnt++;
					}
				}
				if (cnt == m) 
				{
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Question12 T = new Question12();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, m, arr));
	}
}