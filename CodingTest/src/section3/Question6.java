package section3;

import java.util.Scanner;

public class Question6 {
	public int solution(int n, int k, int[] arr) {
		int answer = 0;
		int cnt = 0; // 0->1 로 바꾼 횟수
		int lt = 0;
		
		for (int rt = 0; rt < n; rt++)
		{
			if (arr[rt] == 0)
			{
				cnt++;
			}
			while(cnt > k)	// 바꾼 횟수가 넘어버리면
			{
				if (arr[lt] == 0)	// lt가 0인 지점까지 lt값 증가
				{
					cnt--;	// lt값이 0인 지점이면 0->1로 바꾼 횟수를 감소 
				}
				
				lt++;
			}
			answer = Math.max(answer, rt-lt+1); // 연속된 1의 길이값과 비교
		}

		return answer;
	}

	public static void main(String[] args) {
		Question6 T = new Question6();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();

		int [] arr = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, k, arr));
	}
}