package section1;

import java.util.Scanner;

public class Question10 {

	public int[] solution(String str, char c) {
		int [] answer = new int[str.length()];
		
		int flag = str.length() + 1;
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == c)
			{
				flag = 0;
				answer[i] = flag;
			}
			else
			{
				flag++;
				answer[i] = flag;
			}
		}
		
		flag = str.length() + 1;
		
		for (int i = str.length() -1 ; i >= 0; i--)
		{
			if (str.charAt(i) == c)
			{
				flag = 0;
			}
			else
			{
				flag++;
				answer[i] = answer[i] < flag ? answer[i] : flag;
			}
		}
	
		
		return answer;
	}

	public static void main(String[] args) {
		Question10 T = new Question10();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();
		
		char c = kb.next().charAt(0);
		
		for (int x : T.solution(str, c))
		{
			System.out.print(x + " ");
		}
	}
}