package section2;

import java.util.Scanner;

public class Question9 {

	public int solution(int n, int[][] arr) {
		int answer = Integer.MIN_VALUE;

		int sum1;	// 행의 합
		int sum2;	// 열의 합
		for (int i = 0; i < n; i++)
		{
			sum1=sum2=0;
			for (int j = 0; j < n; j++)
			{
				sum1+=arr[i][j];	//행의 합
				sum2+=arr[j][i];	//열의 합
			}
			answer=Math.max(answer, sum1);
			answer=Math.max(answer, sum2);
			// ======행과 열의 합중에서 큰값이 answer에 있음=====
		}
		sum1 = sum2 = 0;
		for (int i = 0; i < n; i++)
		{
			sum1 += arr[i][i];	//     \자의 합
			sum2 += arr[i][n-i-1];	//		/자의 합
		}
		answer=Math.max(answer, sum1);
		answer=Math.max(answer, sum2);
		
		return answer;
	}

	public static void main(String[] args) {
		Question9 T = new Question9();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] arr= new int[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(T.solution(n, arr));
	}
}