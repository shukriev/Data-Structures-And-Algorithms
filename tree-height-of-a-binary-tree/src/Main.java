
public class Main {
	static int height(Node root) {
		 if (root == null) return -1;
		 return 1 + Math.max(height(root.left), height(root.right));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Node {
	public int data;
	public Node left;
	public Node right;
}