package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	int id;
	int priority;
	public Person(int id, int priority) 
	{
		this.id = id;
		this.priority = priority;
	}
}

public class Question8 {

	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		Queue<Person> Q = new LinkedList<>();

		for (int i = 0; i < n; i++) 
		{
			// 환자번호, 우선순위값
			Q.offer(new Person(i, arr[i]));
		}
		
		while(!Q.isEmpty())
		{
			// 큐에서 제일 앞에 있는 환자를 꺼낸 다음 for문으로 비교한다.
			Person tmp = Q.poll();
			
			for (Person x : Q)
			{
				// 뒤에 있는 환자의 우선순위가 높으면
				if (x.priority > tmp.priority)
				{
					// Q의 맨뒤로 다시 배치 (우선순위가 높은 환자가 있으니까 뒤로 보낸다)
					Q.offer(tmp);
					// tmp(Person) 객체 null로 세팅하고 for문을 더 돌지 않고 break;
					tmp = null;
					break;
				}
			}
			
			// tmp가 null이면 우선순위가  우선순위가 제일 높은 사람이니까 해당 사람은 진료를 받는다
			if(tmp != null)
			{
				// 아니라면 카운트 추가 후 다시 위의 for문을 시작
				answer++;
				// 원하는 순번인가 확인
				if(tmp.id == m)
				{
					return answer;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Question8 T = new Question8();
		Scanner kb = new Scanner(System.in);

		// 환자 수
		int n = kb.nextInt();
		// 몇번째 환자인지
		int m = kb.nextInt();
		
		// 위험도 우선순위
		int[] arr = new int [n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}

		System.out.println(T.solution(n, m, arr));
	}
}