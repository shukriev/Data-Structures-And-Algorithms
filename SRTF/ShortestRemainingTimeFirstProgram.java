import java.util.Scanner;

public class ShortestRemainingTimeFirstProgram {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		
		ProcessTable processTable = new ProcessTable();
		Frame frame = new Frame(processTable);

		processTable.setFrame(frame);
		
		processTable.load(1, 20, 0);
		processTable.load(2, 25, 15);
		processTable.load(3, 10, 30);
		processTable.load(4, 24, 50);
		processTable.load(5, 32, 45);
		processTable.load(6, 13, 80);
		processTable.load(7, 34, 13);
		processTable.load(8, 12, 4);
		processTable.load(9, 32, 5);
		processTable.load(10, 14, 66);
		processTable.load(11, 15, 44);
		processTable.load(12, 1, 22);
		processTable.load(13, 43, 23);
		processTable.load(14, 33, 43);
		processTable.load(15, 23, 312);
		processTable.load(16, 11, 123);
		processTable.process();
		
	}

}
