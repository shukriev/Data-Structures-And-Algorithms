public class Application {
	public static void main(String[] args) {
		RAG rag = new RAG();
		
		//Create process Java JRE
		Process process1 = rag.createProcess("Java JRE");
		rag.processAskResource(process1, "1");
		
		//Create process Slack
		Process process2 = rag.createProcess("Slack");
		rag.processAskResource(process2, "2");
		
		//Meanwhile process1 needs Resource 2
		rag.processAskResource(process1, "2");
		
		//Create process Skype
		Process process3 = rag.createProcess("Skype");
		rag.processAskResource(process3, "1");
		
		rag.findDeadlock();
	}

}
