import java.util.Scanner;


public class CombinationsWithoutRepetition {
	static int c = 0;
	static int[] loopCount;
	static int numberOfIterations = 2;
	static int totalPermutatin = 0;

	public static void loop(int index, int start, int iterattions, int loops) {
		if (index == loopCount.length) {
			printLoops();
			totalPermutatin++;
			return;
		}
		for (int i = start; i <= iterattions; i++) {
			loopCount[index] = i;
			loop(index + 1, i + 1, iterattions, loops - 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < loopCount.length; i++) {
			System.out.printf("%d ", loopCount[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number iterattions");
		int iterattions = sc.nextInt();
		System.out.println("Enter the number loops");
		int loops = sc.nextInt();
		loopCount = new int[loops];
		loop(0, 1, iterattions, loops);;
		System.out.println("Totatl permutaions: " + totalPermutatin);
	}
}
