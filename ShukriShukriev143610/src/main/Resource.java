package main;
public class Resource {
	private Edge relation;
	private String label;
	
	public Resource(String label) {
		this.label = label;
	}

	public void addRelation(Edge relation) {
		if (edgeEquals(relation)) {
			return;
		}

		this.relation = relation;
	}

	public boolean edgeEquals(Edge other) {
		return this.relation == other;
	}

	public Edge getRelation() {
		return this.relation;
	}

	public Edge removeRelation() {
		return this.relation = null;
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
