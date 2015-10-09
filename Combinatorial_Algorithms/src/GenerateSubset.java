import java.util.Scanner;

public class GenerateSubset {
	private static int c = 0;
	private static String[] array;
	private static String[] elements;
	private static int numberOfLoops = 2;
	private static int permutation = 0;
	
	private static void PrintResult() {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s ", array[i]);
		}
		System.out.println();
	}
	
	private static void Loops(int index, int start, int n, int k)
	{
		if(index == array.length) {
			PrintResult();
			permutation++;
			return;
		}
		for (int i = start; i <= n; i++) {
			if(i == n) {
				break;
			}
			
			array[index] = elements[i];
			Loops(index + 1, i + 1, n, k - 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String el = sc.nextLine();
		elements = el.split(" ");

		System.out.println("Enter the number");
		int k = sc.nextInt();
		array = new String[k];
		Loops(0, 0, elements.length, k);
		System.out.println("Totatl permutaions: " + permutation);

	}

}
