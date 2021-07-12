package section2;

import java.util.Scanner;

public class Question11 {
	public int solution(int n, int[][] arr) {
		int answer = 0;
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++)	//n이 5라면 1~5, i학생이 j번학생과 같은반이였던적
		{
			int cnt = 0;
			for (int j = 1; j <= n; j++) //n이 5라면 1~5
			{
				for (int k = 1; k <= 5; k++)	// k는 학년 1~5학년까지 
				{
					if (arr[i][k] == arr[j][k]) //i번 학생의 k학년, j번 학생의 k학년
					{
						cnt++;
						break;	// 학생비교시 같은 학생일 경우 학년을 for문을 중지
					}
				}
			}
			if(cnt>max)
			{
				max = cnt;
				answer = i;
			}
		
		}
		return answer;
	}

	public static void main(String[] args) {
		Question11 T = new Question11();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] arr = new int[n+1][6];
		
		for(int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= 5; j++)
			{
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, arr));
	}
}