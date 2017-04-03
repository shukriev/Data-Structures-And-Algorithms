
public class Main {
	static Node Insert(Node root,int value) {
        if(root == null){
          Node n = new Node();
          n.data = value;
          return n;
        }else {
          Node cur;

          if(value <= root.data){
            cur = Insert(root.left, value);
            root.left = cur;
          }else {
            cur = Insert(root.right, value);
            root.right = cur;
          }
        
          return root;     
        }
	}
}

class Node {
	public int data;
	public Node left;
	public Node right;
}