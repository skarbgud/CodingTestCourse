package section4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Question5 {

	public int solution(int[] arr, int n, int k) {

		int answer = -1;
		
		TreeSet<Integer> Tset = new TreeSet<Integer>(Collections.reverseOrder());	// 내림차순으로 정렬
		for (int i = 0; i < n; i++)
		{
			for (int j = i+1; j < n; j++)
			{
				for (int l = j+1; l < n; l++)
				{
					Tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		int cnt = 0;
		
		for (int x : Tset)
		{
			cnt++;
			if(cnt == k)
			{
				return x;
			}
//			System.out.println(cnt + "->"+x);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		System.out.println(T.solution(arr, n, k));
	}
}