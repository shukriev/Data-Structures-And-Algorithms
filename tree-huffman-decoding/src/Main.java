
public class Main {
	void decode(String str ,Node root) {
        Node n = root;
        for(int i = 0; i < str.length(); i++) {
          if(str.charAt(i) == '0'){
            n = n.left;
          }else {
            n = n.right;
          }
          
          if(n.left == null && n.right == null){
            System.out.print(n.data);
            n = root;
          }
        }
    }
}

class Node {
	public int frequancy;
	public char data;
	public Node left, right;
}