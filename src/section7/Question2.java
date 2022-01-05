package section7;

public class Question2 {
	public void DFS(int n) {
		if (n == 0) return;
		else {
			DFS(n/2);
			System.out.print(n % 2+ " ");
		}
	}
	
	public static void main(String[] args) {
		Question2 T = new Question2();
		T.DFS(11);
	}
}