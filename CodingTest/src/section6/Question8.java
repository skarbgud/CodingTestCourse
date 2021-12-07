package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Question8 {
	
	public int solution(int n, int m, int[]arr)
	{
		int answer = 0;
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		int lt = 0, rt = n-1;
		
		// lt가 rt가 커지기 전까지
		while (lt <= rt)
		{
			int mid = (lt + rt) / 2;
			if (arr[mid] == m)
			{
				answer = mid + 1;
				break;
			}
			//  ((lt   mid))  rt  m값이 괄호안에 있는 경우  
			if (arr[mid] > m)
			{
				// rt의 값을 mid의 앞에 값으로
				rt = mid - 1;
			}
			//  lt  (( mid  rt )) m값이 괄호안에 있는 경우
			else 
			{
				// lt의 값을 mid 뒤로
				lt = mid + 1;
			}
		}
		
	
		return answer;
	}

	public static void main(String[] args) {
		Question8 T = new Question8();
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