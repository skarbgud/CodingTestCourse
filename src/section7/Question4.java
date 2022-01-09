package section7;

public class Question4 {
	/*
		  		   D(5)
		D(3)   		+   		D(4)
	D(1) + D(2)				 D(2) + 	D(3)
	 1    +  1 			      1     D(1) +  D(2)
	 								1    +   1
	 */
	public int DFS(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else {
			return DFS(n - 2) + DFS(n - 1);
		}
	}

	public static void main(String[] args) {
		Question4 T = new Question4();
		int n = 5;
		
		for (int i = 1; i <= n; i++) {
			System.out.print(T.DFS(i) + " ");
		}
		System.out.println("");
		System.out.println(T.DFS(n));
	}
}