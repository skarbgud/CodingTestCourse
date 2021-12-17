package section3;

import java.util.Scanner;

public class Question5 {
	public int solution(int n) {
		int answer = 0;

		int lt = 1;

		int sum = 0;

		for (int rt = 1; rt < n; rt++) 
		{
			sum += rt;
			if (sum == n) 
			{
				answer++;
			}
			while (sum > n) 
			{
				sum -= lt;
				lt++;
				if (sum == n) 
				{
					answer++;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		System.out.print(T.solution(n));
	}
}