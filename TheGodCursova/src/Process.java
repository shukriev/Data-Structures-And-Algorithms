import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Process {
	private ArrayList<Edge> relations;
	private String label;

	public Process(String label) {
		this.label = label;
		this.relations = new ArrayList<Edge>();
	}

	public void addRelation(Edge edge) {
		if (this.relations.contains(edge)) {
			return;
		}

		this.relations.add(edge);
	}

	public boolean containsNeighbor(Edge other) {
		return this.relations.contains(other);
	}

	public Edge getRelation(int index) {
		return this.relations.get(index);
	}

	Edge removeRelation(int index) {
		return this.relations.remove(index);
	}

	public void removeNeighbor(Edge e) {
		this.relations.remove(e);
	}

	public int removeRelation() {
		return this.relations.size();
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
		if (!(other instanceof Process)) {
			return false;
		}

		Process v = (Process) other;
		return this.label.equals(v.label);
	}

	public ArrayList<Edge> getRelations() {
		return new ArrayList<Edge>(this.relations);
	}
	
	public List<Edge> getPendingResourceRelations() {
		return this.relations.stream().filter(r -> r.getType() == RelationType.ASK).collect(Collectors.toList());
	}
}
