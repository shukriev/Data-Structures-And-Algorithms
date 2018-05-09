
public class Application {
	public static void main(String[] args) {
		Resource resource1 = new Resource("CPU Core 1");
		Resource resource2 = new Resource("CPU Core 2");
		Resource resource3 = new Resource("CPU Core 3");
		Resource resource4 = new Resource("CPU Core 4");
		
		Process process1 = new Process("Java");
		process1.addNeighbor(new Edge(process1, resource1));
		
	}
}
