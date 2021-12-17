package section1;

import java.util.Scanner;

public class Question9 {

	public int solution(String str) {
		int answer = 0;
		
		String num = "";
		
		for (char x : str.toCharArray())
		{
			if (Character.isDigit(x))
			{
				num += x;
			}
		}
		
		answer = Integer.parseInt(num);
		
		return answer;
	}

	public static void main(String[] args) {
		Question9 T = new Question9();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();

		System.out.println(T.solution(str));
	}
}