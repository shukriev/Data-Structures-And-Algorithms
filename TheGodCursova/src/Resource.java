public class Resource {
	private Edge edge;
	private String label;
	
	public Resource(String label) {
		this.label = label;
	}

	public void addEdge(Edge edge) {
		if (edgeEquals(edge)) {
			return;
		}

		this.edge = edge;
	}

	public boolean edgeEquals(Edge other) {
		return this.edge == other;
	}

	public Edge getEdge() {
		return this.edge;
	}

	public Edge removeEdge() {
		return this.edge = null;
	}

	public String getLabel() {
		return this.label;
	}

	public String toString() {
		return "Vertex " + label;
	}

	public int hashCode() {
		return this.label.hashCode();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Resource)) {
			return false;
		}

		Resource v = (Resource) other;
		return this.label.equals(v.label);
	}
}
