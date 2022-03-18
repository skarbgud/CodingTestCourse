package section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {

	public int start, end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting m) {
		if (m.end == this.end) {
			// 오름차순 - 음수
			return this.start - m.start;
		} else {
			return this.end - m.end;
		}
	}

}

public class Question2 {

	public int solution(ArrayList<Meeting> arr, int n) {
		int cnt = 0;
		Collections.sort(arr);
		int endTime = 0;
		for (Meeting m : arr) {
			if (m.start >= endTime) {
				cnt++;
				endTime = m.end;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Meeting> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int start = kb.nextInt();
			int end = kb.nextInt();
			arr.add(new Meeting(start, end));
		}
		System.out.println(T.solution(arr, n));
	}
}