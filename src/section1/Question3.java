package section1;

import java.util.Scanner;

public class Question3 {

	public String solution(String str) {
	    String answer = "";
	    int m = Integer.MIN_VALUE;

	    String [] s = str.split(" ");
	    
	    for (String x : s)
	    {
	    	int len = x.length();
	    	if (len > m)
	    	{
	    		m = len;
	    		answer = x;
	    	}
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);

		String str = kb.nextLine();

		System.out.print(T.solution(str));
	}
}