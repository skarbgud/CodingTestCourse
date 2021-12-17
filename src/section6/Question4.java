package section6;

import java.util.Scanner;

public class Question4 {

	public int[] solution(int size, int n, int[] arr) {
		int [] cache = new int [size];
		
		for (int x : arr)
		{
			int pos = -1;
			for (int i = 0; i < size; i++)
			{
				// hit (모든 캐시를 돌면서 맞는게 있는지 확인)
				if (x == cache[i])
				{
					// 맞느게 있으면 해당 pos에 해당 인덱스 값 넣기
					pos = i;
				}
			}
			// miss가 되었을 때
			if (pos == -1)
			{
				// 캐시의 사이즈 만큼(size-1)부터 앞에 캐시 hit가 되는 부분 그 다음 부분까지 뒤로 땡긴다.
				for (int i = size-1; i >= 1; i--)
				{
					cache[i] = cache[i-1];
				}
			}
			// hit가 되었을 때
			else 
			{
				// pos부터 앞에 캐시 hit가 되는 부분 그 다음 부분까지b 뒤로 땡긴다.
				for (int i = pos; i >= 1; i--)
				{
					cache[i] = cache[i-1];
				}
			}
			// miss가 되나 hit가 되나 0번째에는 x값을 넣는다
			cache[0] = x;
		}
		
		
		return cache;
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		Scanner kb = new Scanner(System.in);

		int s = kb.nextInt();
		int n = kb.nextInt();
		int [] arr = new int[n];
		for (int i =0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}

		for (int x : T.solution(s, n, arr))
		{
			System.out.print(x + " ");
		}
	}
}