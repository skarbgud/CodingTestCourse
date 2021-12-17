package section4;

import java.util.HashMap;
import java.util.Scanner;

public class Question4 {

	public int solution(String a, String b) {
		
		int answer = 0;
		HashMap<Character, Integer> am = new HashMap<Character, Integer>();	// a문자열의 해쉬맵
		HashMap<Character, Integer> bm = new HashMap<Character, Integer>();	// b문자열의 해쉬맵
		
		for (char x : b.toCharArray())
		{
			bm.put(x, bm.getOrDefault(x, 0) +1);	//a,b,c 문자열을 키값으로 각 1씩 세팅
		}
		int L = b.length() - 1;
		for (int i = 0; i < L; i++)
		{
			am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) +1);	//am에는 b,a 1씩 세팅 후 rt한칸씩 밀면서 추가
		}
		
		int lt = 0;	// lt값을 0부터 시작
		
		for(int rt = L; rt < a.length(); rt++) // rt값은 L값(2)부터 시작해서 끝까지 밀면서 간다
		{
			am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);	//am에 키값은 rt번째키값에 rt에 기존의 rt인덱스의 값이 있으면 꺼내거나 0이면 +1 
			if(am.equals(bm))	// 해쉬맵이라서 같은 객채면 answer++
			{
				answer++;
			}
			am.put(a.charAt(lt), am.get(a.charAt(lt))-1);	// lt번째(0) 값을 꺼내서 -1
			if(am.get(a.charAt(lt)) == 0)	//값이 0이면 원래 있던값 제거
			{
				am.remove(a.charAt(lt));
			}
			lt++;	//lt값 증가로 슬라이딩 윈도우
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);

		String a = kb.next();
		String b = kb.next();		
		
		System.out.println(T.solution(a, b));
	}
}