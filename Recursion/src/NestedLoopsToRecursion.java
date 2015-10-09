
public class NestedLoopsToRecursion {

	static int[] loopCount;
	static int n = 10;

	public static void loop(int currentLoop) {
		if (currentLoop == n) {
			printLoops();
			return;
		}
		for (int i = 1; i <= n; i++) {
			loopCount[currentLoop] = i;
			loop(currentLoop + 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", loopCount[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		loopCount = new int[n];
		loop(0);
	}
}
