package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question2 {

	public ArrayList<Integer> solution(int n, int m, int[] array1, int[] array2) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		Arrays.sort(array1);	// *** array를 오름차순으로 정리
		Arrays.sort(array2);
		
		int pointer1 = 0;
		int pointer2 = 0;
		
		while (pointer1 < n && pointer2 < m)
		{
			if (array1[pointer1] == array2[pointer2])	// 포인터의 위치가 같을때
			{
				answer.add(array1[pointer1++]);	// 해당위치의 값 ArrayList에 담고 pointer1, pointer2 증가
				pointer2++;
			}
			else if (array1[pointer1] < array2[pointer2]) // array1의 값이 array2의 값보다 작다면
			{
				pointer1++;	// pointer1의 값을 증가시켜 array1의 값을 가리키는 값을 증가시켜 그다음값과 비교하게끔 한다.
			}
			else
			{
				pointer2++; // 반대는 pointer2의 값 증가시켜 array2의 그 다음 값과 비교하게끔 한다.
			}
		}
		
	    return answer;
	}

	public static void main(String[] args) {
		Question2 T = new Question2();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int [] array1 = new int[n];
		for(int i = 0; i < n; i++)
		{
			array1[i] = kb.nextInt();
		}
		
		int m = kb.nextInt();
		int [] array2 = new int[m];

		for(int i = 0; i < m; i++)
		{
			array2[i] = kb.nextInt();
		}
		

		for(int x : T.solution(n, m, array1,array2))
		{
			System.out.print(x+" ");	
		}
		

		return;
	}
}