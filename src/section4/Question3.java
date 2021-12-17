package section4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Question3 {

	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		HashMap<Integer, Integer> HM = new HashMap<>();
		
		for(int i = 0; i < k-1; i++)
		{
			HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
		}
		
		int lt = 0;
		for (int rt = k-1; rt < n; rt++)
		{
			HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
			answer.add(HM.size());
			HM.put(arr[lt], HM.get(arr[lt]) - 1);
			
			// 왼쪽인덱스에 값이 없다면 사이즈를 차지하니까 키 삭제
			if(HM.get(arr[lt]) == 0)
			{
				HM.remove(arr[lt]);
			}
			lt++;
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question3 T = new Question3();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();		
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}

		
		for (int x : T.solution(n, k, arr))
		{
			System.out.print(x + " ");
		}
		
	}
}