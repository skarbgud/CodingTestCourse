package section10;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
	static int n, m;
	static int[] dy;
	
	public int solution(int[] coin) {
		// 초기값으로 dy 배열에 최대값으로 세팅 => 최소개수를 찾는거니까
		Arrays.fill(dy, Integer.MAX_VALUE);
		// 제일 앞에꺼는 0으로 세팅 
		dy[0] = 0;
		for(int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= m; j++) {
				// 기존값보다 dy[j-coin[i]] + 1과 비교
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
			}
		}
		return dy[m];
	}

	public static void main(String[] args) {
		Question5 T = new Question5();
		Scanner kb = new Scanner(System.in);
		// n => 동전의 개수
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			// 동전의 단위들
			arr[i] = kb.nextInt();
		}
		// m => 거슬러줄 금액
		m = kb.nextInt();
		dy = new int[m+1];
		System.out.println(T.solution(arr));
	}
}