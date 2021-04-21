package section3;

import java.util.Scanner;

public class Question2 {

	public int solution(int n, int[] array) {
	
		int max = array[0];
		int answer = 1;
		
		for (int x : array)
		{
			if (max < x)
			{
				max = x;
				answer++;
			}
		}
	
	    return answer;
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int [] array = new int[n];
		for(int i = 0; i < n; i++)
		{
			array[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, array));

		return;
	}
}