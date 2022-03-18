package section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{

	public int h,w;
	public Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	public int compareTo(Body o) {
		// 키 기준으로 내림차순
		return o.h - this.h;
	}

}

public class Question1 {

	public int solution(ArrayList<Body> arr, int n) {
		int cnt = 0;
		Collections.sort(arr);
		int max = Integer.MIN_VALUE;
		for (Body ob : arr) {
			if (ob.w > max) {
				max = ob.w;
				cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Body> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int h = kb.nextInt();
			int w = kb.nextInt();
			arr.add(new Body(h, w));
		}
		System.out.println(T.solution(arr, n));
	}
}