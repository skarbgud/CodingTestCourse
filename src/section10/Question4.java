package section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
	public int s, h, w;

	public Brick(int s, int h, int w) {
		this.s = s; // 벽돌 밑면의 넓이
		this.h = h; // 벽돌의 높이
		this.w = w; // 벽돌의 무게
	}

	@Override
	public int compareTo(Brick o) {
		// 벽돌 밑면의 넓이(내림차순)
		return o.s - this.s;
	}
}

public class Question4 {
	static int[] dy;

	public int solution(ArrayList<Brick> arr) {
		int answer = 0;
		// 넓이에 의해서 내림차순 정렬
		Collections.sort(arr);
		dy[0] = arr.get(0).h; // 제일 넓은 벽돌의 높이를 저장
		answer = dy[0];
		for (int i = 1; i < arr.size(); i++) {
			int max_h = 0;
			for (int j = i - 1; j >= 0; j--) {
				// 앞에 있는 것들보다 무게가 무거운것
				if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
					max_h = dy[j];
				}
			}
			dy[i] = max_h + arr.get(i).h;
			answer = Math.max(answer, dy[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Brick> arr = new ArrayList<>();
		dy = new int[n];
		for (int i = 0; i < n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Brick(a,b,c));
		}
		System.out.println(T.solution(arr));
	}
}