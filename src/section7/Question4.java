package section7;

public class Question4 {
	
	static int[] fibo;
	
	public int DFS(int n) {
		if (n == 1)
			return fibo[n] = 1;
		else if (n == 2)
			return fibo[n] = 1;
		else {
			return fibo[n] = DFS(n - 2) + DFS(n - 1);
		}
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		int n = 10;
		// 인덱스를 위한 int 배열(n=1부터 시작이니까 +1)
		fibo = new int[n+1];
		
		T.DFS(n);
		
		for (int i = 1; i <= n; i++) {
			System.out.print(fibo[i] + " ");
		}
	}
}