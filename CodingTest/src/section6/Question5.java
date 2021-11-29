package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {

	public String solution(int n, int[] arr) {
		String answer = "U";
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n-1; i++)
		{
			if (arr[i] == arr[i+1])
			{
				return "D";
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		int [] arr = new int[n];
		for (int i =0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, arr));
		
	}
}