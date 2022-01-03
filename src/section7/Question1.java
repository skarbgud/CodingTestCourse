package section7;

public class Question1 {

	/*
	 * 스택 프레임
	   구성 : [매개변수 정보, 지역변수 정보, 복귀주소 정보]
	 */
	public void DFS(int n) {
		if (n == 0) return;
		else {
			DFS(n-1);
			System.out.print(n+ " ");
		}
	}
	
	public static void main(String[] args) {
		Question1 T = new Question1();
		T.DFS(3);
	}
}