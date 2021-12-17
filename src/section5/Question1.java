package section5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Question1 {

	public String solution(String str) {
		String answer = "YES";

		Stack<String> stack = new Stack<>();

		char[] charList = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			if (charList[i] == '(') 
			{
				stack.push(str);
			} 
			else if (charList[i] == ')' && !stack.empty()) 
			{
				stack.pop();
			} 
			else 
			{
				answer = "NO";
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();

		System.out.println(T.solution(str));
	}
}