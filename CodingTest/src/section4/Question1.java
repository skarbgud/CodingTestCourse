package section4;

import java.util.HashMap;
import java.util.Scanner;

public class Question1 {

	public String solution(String str1, String str2) {
		String answer = "YES";
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char x : str1.toCharArray())
		{
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		for (char x : str2.toCharArray())
		{
			// 같은 글자가 없는 경우거나 Map에서 count를 모두 소진한 경우
			if (!map.containsKey(x) || map.get(x) == 0)
			{
				answer = "NO";
			}
			else
			{
				map.put(x, map.get(x) - 1);	
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question1 T = new Question1();
		Scanner kb = new Scanner(System.in);

		String str1 = kb.next();
		String str2 = kb.next();
		
		System.out.println(T.solution(str1, str2));
	}
}