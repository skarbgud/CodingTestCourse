package section1;

import java.util.Scanner;

public class Question1 {

	public int solution(String str, char t) {
	    int answer = 0;
	
	    str = str.toUpperCase();
	    t = Character.toUpperCase(t);
	    
//	    System.out.println(str + "" + t);
	    for (int i = 0; i < str.length(); i++)
	    {
	    	if (str.charAt(i) == t)
	    	{
	    		answer++;
	    	}
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();
		char c = kb.next().charAt(0);

		System.out.print(T.solution(str, c));

		return;
	}
}