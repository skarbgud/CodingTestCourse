package section2;

import java.util.Scanner;

public class Question4 {

	public int[] solution(int n) {
	
		int[] answer = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			if (i == 0 || i == 1)
			{
				answer[i] = 1;
			}
			else
			{
				answer[i] = answer[i-2] + answer[i-1];
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		
		for (int i = 0; i < n; i++)
		{
			System.out.print(T.solution(n)[i] + " ");	
		}

	}
}