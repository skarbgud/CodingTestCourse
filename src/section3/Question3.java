package section3;

import java.util.Scanner;

public class Question3 {

	public int solution(int n, int k, int[] array) {
		int answer = 0;
		
		int sum = 0;
		
		for (int i = 0; i < k; i++)		// 맨처음에 연속된 일의 틀을 구해서 합을 구해서 다음날을 더하고 전날을 뺀다.
		{
			sum += array[i];	// 맨처음 연속된 일의 합을 구해서 초기화 해놓는다.
		}
		
		answer = sum; // 첫 최대값은 처음 구한 연속된 k일
		
		for (int i = k ; i < n; i++)
		{
			sum += array[i] - array[i-k];	// 뒤의값은 더해주고 앞의값은 빼준다.
			if (sum > answer)
			{
				answer = sum;
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int [] array = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			array[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, k, array));	
	}
}