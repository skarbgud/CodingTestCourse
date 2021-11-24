package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question7 {

	public String solution(String need, String plan) {
		String answer = "YES";
		Queue<Character> Q = new LinkedList<Character>();

		for (char x : need.toCharArray()) 
		{
			Q.offer(x); // Q에 필수 과목 삽입
		}

		for (char x : plan.toCharArray()) 
		{
			if (Q.contains(x)) // 큐에 포함되어있다면 
			{
				if (x != Q.poll()) // 큐를 꺼낸게 교육과정에 있지 않다면
				{
					return "NO"; // 잘못된 계획이라 NO 리턴
				}
			}
		}

		// 순서에 맞게 교육과정을 모두 잘 설계했다면 해당 queue에 남아있는게 있는지 확인
		if (!Q.isEmpty()) 
		{
			return "NO"; // 남아있다면 필수과목을 수강하지 않아서 NO 리턴
		}

		// 필수과목도 모두 순서에 맞게 수강하고 모두 수강계획에 있으면 YES 리턴
		return answer;
	}

	public static void main(String[] args) {
		Question7 T = new Question7();
		Scanner kb = new Scanner(System.in);

		String n = kb.nextLine();
		String p = kb.nextLine();

		System.out.println(T.solution(n, p));
	}
}