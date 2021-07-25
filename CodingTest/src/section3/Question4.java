package section3;

import java.util.Scanner;

public class Question4 {
	public int solution(int n, int m, int[] array) {
		int answer = 0;

		int sum = 0;

		int lt = 0;

		for (int rt = 0; rt < n; rt++)	// lt와 rt 인덱스 설정 rt가 증가 
		{
			sum += array[rt];	// rt값을 계속 더해준다

			if (sum == m) 	// sum 이 m이랑 같으면 증가
			{
				answer++;
			}
			while (sum >= m)	// 만약 sum값이 m보다 커지면  
			{
				sum -= array[lt++];		//왼쪽 인덱스를 증가시켜 sum값에 감소
				if (sum == m) 		//만약 값이 같다면 증가
				{
					answer++;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = kb.nextInt();
		}

		System.out.print(T.solution(n, m, array));
	}
}