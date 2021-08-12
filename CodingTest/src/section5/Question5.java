package section5;

import java.util.Scanner;
import java.util.Stack;

public class Question5 {

	public int solution(String str) {
		int answer = 0;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++)
		{
			// 여는 괄호이면 stack에 push
			if (str.charAt(i) == '(')
			{
				stack.push('(');
			}
			// 닫는 괄호이면 
			else{
				stack.pop();
				if(str.charAt(i-1) == '(')	//레이저가 만들어진 바로 앞에 지점이 여는 괄호이면 레이저 지점
				{
					answer+=stack.size(); // 여는 괄호의 개수만큼 stack에 담겨있을테니 answer을 stack의 게수만큼 증가
				}
				else
				{
					answer++;	// 여는 괄호가 아니라 닫는 괄호이면 막대기의 끝지점 그냥 answer의 개수 증가 
				}
				
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();

		System.out.println(T.solution(str));
	}
}