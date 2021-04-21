package section2;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

	public ArrayList<Integer> solution(int n, int[] array) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(array[0]);
		for (int i = 0; i < n-1; i++)
		{
			if (array[i] < array[i+1])
			{
				answer.add(array[i+1]);
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int [] array = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			array[i] = kb.nextInt();
		}

		for(int x : T.solution(n, array))
		{
			System.out.print(x+" ");	
		}
		

		return;
	}
}