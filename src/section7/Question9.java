package section7;

class TreeDFS {
	int data;
	TreeDFS lt, rt;
	public TreeDFS(int val) {
		data = val;
		lt = rt = null;
	}
}

public class Question9 {
	TreeDFS root;
	public int DFS (int L, TreeDFS root) {
		if (root.lt == null && root.rt == null) {
			return L;
		} else {
			return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
		}
	}
	
	public static void main(String[] args) {
		Question9 tree = new Question9();
		tree.root = new TreeDFS(1);
		tree.root.lt = new TreeDFS(2);
		tree.root.rt = new TreeDFS(3);
		tree.root.lt.lt = new TreeDFS(4);
		tree.root.lt.rt = new TreeDFS(5);
		System.out.println(tree.DFS(0, tree.root));
	}
}