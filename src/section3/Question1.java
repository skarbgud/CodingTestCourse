package section3;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

	public ArrayList<Integer> solution(int n, int m, int[] array1, int[] array2) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int pointer1 = 0;
		int pointer2 = 0;
		
		while (pointer1 < n && pointer2 < m)
		{
			if (array1[pointer1] < array2[pointer2])
			{
				answer.add(array1[pointer1++]);
			}
			else
			{
				answer.add(array2[pointer2++]);
			}
		}
		
		// array1가 아직 남았을때
		while (pointer1 < n)
		{
			answer.add(array1[pointer1++]);
		}
		// array2가 아직 남았을때
		while (pointer2 < m)
		{
			answer.add(array2[pointer2++]);
		}
	    return answer;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int [] array1 = new int[n];
		for(int i = 0; i < n; i++)
		{
			array1[i] = kb.nextInt();
		}
		int m = kb.nextInt();
		int [] array2 = new int[m];

		for(int i = 0; i < m; i++)
		{
			array2[i] = kb.nextInt();
		}
		

		for(int x : T.solution(n, m, array1,array2))
		{
			System.out.print(x+" ");	
		}
		

		return;
	}
}