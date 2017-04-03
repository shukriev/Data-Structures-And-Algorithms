
public class Main {
	Node preOrder(Node node) {
	    System.out.print(node.data + " ");
	    if(node.left != null) preOrder(node.left);
	    if(node.right != null) preOrder(node.right);	  
	    return null;
	}
	
	void postOrder(Node node) {
	    while(node != null){
	        postOrder(node.left);
	        postOrder(node.right);
	        System.out.print(node.data + " ");
	        return;
	    }
	}
	
	void inOrder(Node root) {
	    while(root != null){
	        inOrder(root.left);
	        System.out.print(root.data + " ");
	        inOrder(root.right);
	        return;
	    }
	}
	
	public static void main(String[] args) {


	}
}

class Node {
	public int data;
	public Node left;
	public Node right;
}