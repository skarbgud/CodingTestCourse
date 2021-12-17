package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question6 {

	public int solution(int n, int k) {
		int answer = 0;
		Queue<Integer> Q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) { // Queue에 기본값 세팅 n까지
			Q.offer(i); // Q에 삽입
		}

		while (!Q.isEmpty()) // Q가 비었을때까지
		{
			for (int i = 1; i < k; i++) { // 1부터 k번까지 앞에 k개를 빼고 뒤로 k개를 삽입
				Q.offer(Q.poll()); // 앞에 값 꺼내서 뒤로 넣기
			}
			Q.poll(); // k번 꺼내기
			if (Q.size() == 1) // 사이즈가 1이면 정답
			{
				answer = Q.poll();
			}
		}
		
/*
 
12345678
[3]4567812
[6]781245
[1]24578
[5]7824
[2]478
[8]47
[4]7
7	===> 정답

*/
		return answer;
	}

	public static void main(String[] args) {
		Question6 T = new Question6();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();

		System.out.println(T.solution(n, k));
	}
}