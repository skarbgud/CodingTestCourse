package section7;

public class Question6 {
	static int n;
	static int[] ch; // 부분 칩합의 체크 배열
	
	public void DFS(int L) {
		if (L == n+1) {
			String tmp = "";
			for (int i = 1; i <= n; i++) { // 1부터 n번까지의 배열 출력
				if (ch[i] == 1) { // 1로 표시된 부분만 출력
					tmp += (i+ " "); 
				}
			}
			if (tmp.length() > 0) { // 공집합 제외
				System.out.println(tmp);
			}
		}
		else {
			ch[L] = 1;
			DFS(L+1);
			ch[L] = 0;
			DFS(L+1);
		}
	}

	public static void main(String[] args) {
		Question6 T = new Question6();
		n = 3;
		ch = new int [n+1];
		T.DFS(1);
	}
}