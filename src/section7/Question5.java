package section7;

class Node {
	int data; // 1, 2, 3, 4 .... 데이터 저장값
	Node lt, rt; // lt왼쪽 노드객체 주소 저장, rt 오른쪽 노드 객체 주소 저장
	public Node(int val) {
		data = val;
		lt = rt = null;
	}
}

public class Question5 {
	Node root;
	public void DFS(Node root) {
		if (root == null) {
			return;
		}
		else {
			System.out.print(root.data + " "); // 왼쪽이 호출되기전 앞에다가 하면 전위순회이다
			DFS(root.lt); // 왼쪽의 노드 객체 호출
			System.out.print(root.data + " "); // 왼쪽자식을 방문하고 오른쪽 노드 방문전에 하면 중위순회이다
			DFS(root.rt); // 오른쪽의 노드 객체 호출
			System.out.print(root.data + " "); // 왼쪽과 오른쪽 자식을 방문하고 호출하면 후위순회이다
		}
	}

	public static void main(String[] args) {
		Question5 tree = new Question5();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.DFS(tree.root);
	}
}