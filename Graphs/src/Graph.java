import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.management.RuntimeErrorException;


public class Graph<T> {
	private Map<T, Node<T>> graph;
	
	public Graph() {
		graph = new HashMap<>();
	}
	
	private Node<T> getNode(T value) {
		return graph.get(value);
	}
	
	public boolean containsVertex(T vertex) {
		return graph.containsKey(vertex);
	}
	
	public boolean addEdge(T vertex1, T vertex2, int weight) {
		if(!containsVertex(vertex1) || !containsVertex(vertex2)) {
			throw new RuntimeException("vertex does not exist");
		}
		
		Node<T> node1 = getNode(vertex1);
		Node<T> node2 = getNode(vertex2);
		return node1.addEdge(node2, weight);
	}
	
	public boolean containsEdge(T vertex1, T vertex2) {
		if(!containsVertex(vertex1) || !containsVertex(vertex2)) {
			return false;
		}
		
		return getNode(vertex1).hasEdge(getNode(vertex2));
	}
	public boolean addVertex(T vertex) {
		if(graph.containsKey(vertex)){
			return false;
		}
		graph.put(vertex, new Node<>(vertex));
		return true;
	}
	
	public boolean addEdge(T vertex1, T vertex2) {
		return addEdge(vertex1, vertex2, 0);
	}
	
	private void BFS(T startVertex) {
		if(!containsVertex(startVertex)) {
			throw new RuntimeException("Vertex does not exist.");
		}
		
		resetGraph();
		
		Queue<Node<T>> qq = new LinkedList<Node<T>>();
		Node<T> start = getNode(startVertex);
		qq.add(start);
		
		while(!qq.isEmpty()) {
			Node<T> first = qq.remove();
			first.setVisited(true);
			first.edges().forEach(edge -> {
				Node<T> neighbour = edge.toNode();
				if(!neighbour.isVisited()){
					neighbour.setParent(first);
					qq.add(neighbour);
				}
			});
		}
	}
	
	public List<T> shortestPath (T startV, T endV) {
		
		if(!containsVertex(startV) || !containsVertex(endV)) {
			return null;
		}
		
		BFS(startV);
		
		List<T> path = new ArrayList<>();
		
		Node<T> end = getNode(endV);
		
		while(end != null && end != getNode(startV)) {
			path.add(end.vertex());
			end = end.parent();		
		}
		
		if(end == null) {
			return null;
		} else {
			Collections.reverse(path);
		}	
		
		return path;

	}
	
	private void resetGraph() {
		graph.keySet().forEach(key -> {
			Node<T> node = getNode(key);
			node.setParent(null);
			node.setVisited(false);
		});
	}
}
