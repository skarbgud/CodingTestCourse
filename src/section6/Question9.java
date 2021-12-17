package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Question9 {
	
	public int count (int[] arr, int capacity) {
		// cnt => DVD 장수
		// SUM => 용량의 합
		int cnt = 1;
		int sum = 0;
		
		for (int x : arr)
		{
			if (sum + x > capacity)
			{
				cnt++;
				sum = x; // x => 곡의 용량
			}
			else
			{
				sum += x;
			}
		}
		
		return cnt;
	}
	
	public int solution(int n, int m, int[]arr)
	{
		int answer = 0;
		
		// 배열에서 최대값을 찾아서 넣어준다.(반복자 iterator) -> 스트림 -> max값 -> int값 찾기
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum(); // sum()은 int값 리턴
		
		while (lt <= rt)
		{
			int mid = (lt + rt) / 2;
			
			// 장수가 넣을수있는 총량보다 작거나 같으면 넣을수 있다.
			if (count(arr, mid) <= m)
			{
				answer = mid;
				rt = mid - 1;
			}
			else
			{
				lt = mid + 1;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question9 T = new Question9();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		System.out.println(T.solution(n, m, arr));
	}

}