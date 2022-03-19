package section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
	public int money;
	public int time;

	public Lecture(int money, int time) {
		this.money = money;
		this.time = time;
	}

	@Override
	public int compareTo(Lecture ob) {
		// time 순으로 내림차순
		return ob.time - this.time;
	}
}

public class Question4 {
	static int n, max = Integer.MIN_VALUE;

	public int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		// Collections.reverseOrder() => 큰값을 우선순위
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		Collections.sort(arr);
		int j = 0;
		// 최대일부터 날짜가 하루씩 작아진다
		for (int i = max; i >=1; i--) {
			for (; j < n; j++) {
				if (arr.get(j).time < i) {
					// 날짜보다 작으면 break
					break;
				}
				pQ.offer(arr.get(j).money);
			}
			if (!pQ.isEmpty()) {
				answer += pQ.poll();
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = kb.nextInt();
			int d = kb.nextInt();
			arr.add(new Lecture(m, d));
			if (d > max) {
				max = d;
			}
		}
		System.out.println(T.solution(arr));
	}
}