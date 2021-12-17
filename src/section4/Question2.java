package section4;

import java.util.HashMap;
import java.util.Scanner;

public class Question2 {

	public char solution(int n, String candidate) {
		char answer = ' ';
		int maxValue = Integer.MIN_VALUE;
		
		HashMap<Character, Integer> vote = new HashMap<>();
		
		for (char x : candidate.toCharArray())
		{
			// 값을 꺼내고 없으면 0을 세팅하고 있으면 +1씩 더한다.
			vote.put(x, vote.getOrDefault(x, 0) + 1);
		}
		
		for (char x : vote.keySet())
		{
			if (vote.get(x).intValue() > maxValue)
			{
				maxValue = vote.get(x).intValue();
				answer = x;
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		String candidate = kb.next();

		System.out.println(T.solution(n, candidate));
	}
}