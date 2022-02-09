package section7;

import java.util.LinkedList;
import java.util.Queue;

class TreeBFS {
	int data;
	TreeBFS lt, rt;
	public TreeBFS(int val) {
		data = val;
		lt = rt = null;
	}
}

public class Question10 {
	TreeBFS root;
	public int BFS (TreeBFS root) {
		Queue<TreeBFS> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				TreeBFS current = Q.poll();
				if (current.lt == null && current.rt == null) {
					return L;
				}
				if (current.lt != null ) {
					Q.offer(current.lt);
				}
				if (current.rt != null) {
					Q.offer(current.rt);
				}
			}
			L++;
		}
		// 여기는 오지 않는다.
		return 0;
	}
	
	public static void main(String[] args) {
		Question10 tree = new Question10();
		tree.root = new TreeBFS(1);
		tree.root.lt = new TreeBFS(2);
		tree.root.rt = new TreeBFS(3);
		tree.root.lt.lt = new TreeBFS(4);
		tree.root.lt.rt = new TreeBFS(5);
		System.out.println(tree.BFS(tree.root));
	}
}