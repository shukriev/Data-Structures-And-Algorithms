import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	static void edge_left(Node root) {
		array.add(root.data);
	    if(root.left!=null) edge_left(root.left);   

	}
	
	static void edge_right(Node root) {
		array.add(root.data);
	    if(root.right!=null) edge_right(root.right);   

	}
	static void top_view(Node root) {
		edge_left(root.left);
		Collections.reverse(array);
		array.add(root.data);
		edge_right(root.right);

		for (Integer integer : array) {
			System.out.print(integer + " ");
		}
	}
}

class Node {
	public int data;
	public Node left;
	public Node right;
}