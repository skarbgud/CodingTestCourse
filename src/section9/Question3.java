package section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
	public int time;
	public char state;
	Time(int time, char state) {
		this.time = time;
		this.state = state;
	}
	
	@Override
	public int compareTo(Time o) {
		if (this.time == o.time) {
			return this.state - o.state;
		} else {
			return this.time - o.time;
		}
	}
	
}

public class Question3 {

	public int solution(ArrayList<Time> arr) {
		int answer = Integer.MIN_VALUE;
		Collections.sort(arr);
		int cnt = 0;
		for (Time ob: arr) 
		{
			if (ob.state == 's') {
				// 들어온거니까 +1
				cnt++;
			} else {
				// 나갈때는 빠지니까 -1
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Time> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int startTime = kb.nextInt();
			int endTime = kb.nextInt();
			arr.add(new Time(startTime, 's'));
			arr.add(new Time(endTime, 'e'));
		}
		System.out.println(T.solution(arr));
	}
}