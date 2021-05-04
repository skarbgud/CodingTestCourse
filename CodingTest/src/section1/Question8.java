package section1;

import java.util.Scanner;

public class Question8 {

	public String solution(String str) {
		String answer = "NO";
		
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		
		String tmp = new StringBuilder(str).reverse().toString();
	
		if (str.equalsIgnoreCase(tmp))
		{
			return "YES";
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question8 T = new Question8();
		Scanner kb = new Scanner(System.in);

		String str = kb.nextLine();

		System.out.println(T.solution(str));
	}
}