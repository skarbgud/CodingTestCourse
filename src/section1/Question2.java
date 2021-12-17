package section1;

import java.util.Scanner;

public class Question2 {

	public String solution(String str) {
	    String answer = "";

	    for (char x : str.toCharArray())
	    {
	    	if (Character.isLowerCase(x)) 
	    	{
	    		answer += Character.toUpperCase(x);
	    	}
	    	else
	    	{
	    		answer += Character.toLowerCase(x);
	    	}
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();

		System.out.print(T.solution(str));

		return;
	}
}