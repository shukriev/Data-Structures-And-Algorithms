import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Node<T> {
	private T vertex;
	private List<Edge<T>> edges;
	private Node<T> parent;
	private boolean isVisited;
	
	public Node(T vertex) {
		this.vertex = vertex;
		this.edges = new ArrayList<Edge<T>>();
	}
	
	public T vertex() {
		return this.vertex;
	}
	
	public boolean addEdge(Node<T> node, int weight) {
		if(hasEdge(node)){
			return false;
		}
		
		Edge<T> newEdge = new Edge<>(this,node, weight);
		
		return edges.add(newEdge);
	}
	
	public boolean removeEdge(Node<T> node) {
		Optional<Edge<T>> optionalNode = findEdge(node); 
			if(optionalNode.isPresent()) {
				return edges.remove(optionalNode.get());
			}
			return false;
	}
	
	public boolean hasEdge(Node<T> node) {
		return findEdge(node).isPresent();
	}
	
	private Optional<Edge<T>> findEdge(Node<T> node){
		return this.edges.stream()
				.filter(edge -> edge.isBetween(this, node))
				.findFirst();
	}
	
	public List<Edge<T>> edges() {
		return edges;
	}
	
	public int getEdgeCount() {
		return edges.size();
	}
	
	public Node<T> parent() {
		return parent;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
}
