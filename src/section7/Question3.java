package section7;

public class Question3 {
	public int DFS(int n) {
		if (n == 1) return 1;
		else {
			return n * DFS(n-1);
		}
	}
	
	public static void main(String[] args) {
		Question3 T = new Question3();
		System.out.println(T.DFS(5));
	}
}