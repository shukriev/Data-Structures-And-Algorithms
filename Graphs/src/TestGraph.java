import java.util.List;


public class TestGraph {

	public static void main(String[] args) {
		Graph<Integer> gp = new Graph<Integer>();
		gp.addVertex(1);
		gp.addVertex(2);
		gp.addVertex(3);
		gp.addVertex(4);
		gp.addVertex(5);
		gp.addVertex(6);
		gp.addVertex(7);
		gp.addVertex(8);

		gp.addEdge(1, 4);
		gp.addEdge(3, 4);
		gp.addEdge(3, 5);
		gp.addEdge(4, 6);
		gp.addEdge(5, 3);
		gp.addEdge(5, 7);
		gp.addEdge(5, 8);
		gp.addEdge(7, 8);

		List<Integer> path = gp.shortestPath(1, 6);
		System.out.println("path length: " + path.size());
		path.forEach(p -> System.out.print(p + " "));
	}

}
