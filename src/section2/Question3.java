package section2;

import java.util.Scanner;

public class Question3 {

	public String[] solution(int n, int[] personA, int[] personB) {
	
		String[] answer = new String[n];
		
		for (int i = 0; i < n; i++)
		{
			if (personA[i] == personB[i])
			{
				answer[i] = "D";
			}
			else if (personA[i] == 1 && personB[i] == 3)
			{
				answer[i] = "A";
			}
			else if (personA[i] == 2 && personB[i] == 1)
			{
				answer[i] = "A";
			}
			else if (personA[i] == 3 && personB[i] == 2)
			{
				answer[i] = "A";
			}
			else
			{
				answer[i] = "B";
			}
		}
	
	    return answer;
	}

	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int [] personA = new int[n];
		int [] personB = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			personA[i] = kb.nextInt();
		}
		for(int i = 0; i < n; i++)
		{
			personB[i] = kb.nextInt();
		}
		
		for (int a = 0; a < n; a++)
		{
			System.out.println(T.solution(n, personA, personB)[a]);	
		}
		

		return;
	}
}