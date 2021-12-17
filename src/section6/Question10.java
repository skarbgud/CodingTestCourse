package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Question10 {
	
	public int count (int[] arr, int dist) {
		// cnt => 말의 마리 수
		// ep => 마구간의 위치
		// dist 거리 -> mid값
		int cnt = 1;
		int ep = arr[0];
		
		for (int i = 1; i < arr.length; i++)
		{
			// 첫번째에서는 arr[1] - arr[0] => 두개의 간격이 주어진 거리(mid)보다 크면 ep를 늘려서 좁혀나간다.
			if (arr[i] - ep >= dist)
			{
				cnt++;
				ep = arr[i];
			}
		}
		
		return cnt;
	}
	
	public int solution(int n, int c, int[]arr)
	{
		int answer = 0;
	
		// 배열 정렬
		Arrays.sort(arr);
		
		int lt = 1;
		int rt = arr[n-1];
		
		while (lt <= rt)
		{
			int mid = (lt + rt) / 2;
			
			// 마리수가 c보다 크면
			if (count(arr, mid) >= c)
			{
				answer = mid;
				lt = mid + 1;
			}
			else
			{
				rt = mid - 1;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question10 T = new Question10();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int c = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		System.out.println(T.solution(n, c, arr));
	}

}