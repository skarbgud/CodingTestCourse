package section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> 
{
	public int x,y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Comparable의 compareTo 메소드 재정의
	@Override
	public int compareTo(Point o) {
		// x좌표를 비교해서 같다면 y를 비교한다
		if (this.x == o.x) {
			// this - o => 음수값
			// o - this => 음수값 
			// 무조건 음수값이 리턴이 되게 하자
			return this.y - o.y;
			
			// 내림차순일 경우
//			return o.y - this.y // -> 음수값
		}
		else
		{
			return this.x - o.x;
			
			// 내림차순일 경우
//			return o.x - this.x // -> 음수값
		}
	}
	
}

public class Question7 {

	public static void main(String[] args) {
		Question7 T = new Question7();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x,y));
		}
		Collections.sort(arr);
		
		for (Point o : arr)
		{
			System.out.println(o.x + " " + o.y);
		}
	}
}