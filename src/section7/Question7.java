package section7;

import java.util.LinkedList;
import java.util.Queue;

class BFSNode {
	int data;
	BFSNode lt, rt;
	public BFSNode(int val) {
		data = val;
		lt = rt = null;
	}
}

public class Question7 {
	BFSNode root;
	public void BFS(BFSNode root) {
		Queue<BFSNode> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print("Level "+ L + ": ");
			for (int i = 0; i < len; i++) {
				BFSNode currentNode = Q.poll();
				System.out.print(currentNode.data + " ");
				// 왼쪽 자식이 있으면 큐에 넣기
				if (currentNode.lt != null) {
					Q.offer(currentNode.lt);
				}
				// 오른쪽 자식이 있으면 큐에 넣기
				if (currentNode.rt != null) {
					Q.offer(currentNode.rt);
				}
			}
			// 현재 레벨이 끝났으니 레벨을 추가
			L++;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Question7 tree = new Question7();
		tree.root = new BFSNode(1);
		tree.root.lt = new BFSNode(2);
		tree.root.rt = new BFSNode(3);
		tree.root.lt.lt = new BFSNode(4);
		tree.root.lt.rt = new BFSNode(5);
		tree.root.rt.lt = new BFSNode(6);
		tree.root.rt.rt = new BFSNode(7);
		tree.BFS(tree.root);
	}
}