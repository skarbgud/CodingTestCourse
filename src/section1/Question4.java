package section1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

	public ArrayList<String> solution(int n, String[] str) {
		ArrayList<String> answer = new ArrayList<>();

		// case1. StringBuilder를 이용한 뒤집기 StringBuilder().reverse() 이용
		for (String x : str) 
		{
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		
		// case2. 처음 인덱스와 끝 인덱스를 tmp에 집어넣어서 교환하는 방식
		
		for (String x : str)
		{
			char[] s = x.toCharArray();
			int lt = 0;
			int rt = x.length() - 1;
			while (lt < rt)
			{
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = s[lt];
				lt++;
				rt--;
			}
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}

		return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		String str[] = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = kb.next();
		}

		for (String x : T.solution(n, str)) {
			System.out.println(x);
		}

	}
}