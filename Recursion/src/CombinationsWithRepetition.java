
public class CombinationsWithRepetition {
	static int c = 0;
	static int[] loopCount;
	static int numberOfIterations = 3;
	static int numberOfLoops = 3;

	public static void loop(int currentLoop) {
		if (currentLoop == numberOfLoops) {
			printLoops();
			return;
		}
		for (int i = 1; i <= numberOfIterations; i++) {
			loopCount[currentLoop] = i;
			loop(currentLoop + 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < numberOfLoops; i++) {
			System.out.printf("%d ", loopCount[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		loopCount = new int[numberOfLoops];
		loop(0);
	}
}
