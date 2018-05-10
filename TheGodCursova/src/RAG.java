import java.util.ArrayList;
import java.util.List;

public class RAG {
	private List<Resource> resourceList = new ArrayList<Resource>();
	private List<Process> processList = new ArrayList<Process>();

	public RAG() {
		// Resource allocation
		resourceList.add(new Resource("1"));
		resourceList.add(new Resource("2"));
		resourceList.add(new Resource("3"));
		resourceList.add(new Resource("3"));
	}

	// Process ask for resource with label.. So we can create concrete deadlock
	public boolean processAskResource(Process process, String label) {
		// Later can add resource type based on that we can search for specific resource
		// type e.g CPU, RAM.
		System.out.println(String.format("Process %s ask resource %s", process.getLabel(), label));
		Resource resource = null;
		try {
			if (findResource(label)) {
				// Find unused resource e.g resource doesn't have relation R->P
				for (Resource r : resourceList) {

					if (r.getLabel() == label) {
						if (r.getRelation() == null) {
							// If there is available resource.. then return it we will process it later
							resource = r;
							break;

						} else {
							// If there is existing resource but it's not available then create relation ask
							Edge processAskResource = new Edge(RelationType.ASK, process, r);
							process.addRelation(processAskResource);
							System.out.println(String.format("Relation process=%s ASK resource=%s has been created!",
									process.getLabel(), r.getLabel()));

							// We don't add relation on Resource. Because resource is already in use.
							System.out.println(String.format("Resource %s already in use!", label));
							System.out.println();

							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// So we don't have available resource
		if (resource == null) {
			return false;
		}

		// If we find available resource then create Relation with type USE and add it
		// in both Process and Resource
		Edge processUseResource = new Edge(RelationType.USE, process, resource);
		process.addRelation(processUseResource);
		resource.addRelation(processUseResource);

		System.out.println(String.format("Relation process=%s USE resource=%s has been created!", process.getLabel(),
				resource.getLabel()));
		System.out.println();

		return true;
	}

	private boolean findResource(String label) throws Exception {
		// First find if resource with label exist;
		Resource filteredResource = resourceList.stream().filter(r -> r.getLabel() == label).findFirst().orElse(null);

		if (filteredResource == null) {
			throw new Exception(String.format("Resource with label %s does not exist!", label));
		}

		return true;
	}

	public Process createProcess(String processName) {
		Process process = new Process(processName);
		processList.add(process);

		System.out.println(String.format("Process %s has been created!", processName));
		return process;
	}

	public void findDeadlock() {
		// Iterate list of process
		// Find if process have resource with allocated resource
		// and in same time process have pending resource
		// if yes, check if process who is using pending resource have also pending
		// resource who is owned by first process;

		for (Process process : processList) {
			List<Edge> pendingResourceRelations = process.getPendingResourceRelations();
			for (Edge edge : pendingResourceRelations) {
				System.out.println(String.format(
						"Process with id=%s is locked because of resource with id=%s owned by=%s", process.getLabel(),
						edge.getResource().getLabel(), edge.getResource().getRelation().getProcess().getLabel()));
			}
		}
	}
}
