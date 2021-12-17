package section1;

import java.util.Scanner;

public class Question7 {

	public String solution(String str) {
		String answer = "YES";
		
		int len = str.length();
		
		str = str.toUpperCase();
		
		for (int i = 0; i < len / 2; i++)
		{
			if (str.charAt(i) != str.charAt(len - i - 1))
				return "NO";
		}
//		String tmp = new StringBuilder(str).reverse().toString();
//		
//		if(!str.equalsIgnoreCase(tmp))
//			return "NO";
		return answer;
	}

	public static void main(String[] args) {
		Question7 T = new Question7();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();

		System.out.println(T.solution(str));
	}
}