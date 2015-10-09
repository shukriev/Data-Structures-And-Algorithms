import java.util.ArrayList;
import java.util.Scanner;


public class Permutations {
	private static int countOfPermutations = 0;
	private static int[] array;
	private static boolean[] used;
	
	private static void PrintResult(int n)
	{
		for (int i = 0; i < n; i++) {
			System.out.printf("%d", array[i]);
		}
		System.out.println();
	}
	
	private static void Permutate(int i, int n) {
		if(i > n) {
			PrintResult(n);
			countOfPermutations++;
		}else {
			for (int j = 0; j < n; j++) {
				if (!used[j]) {
					used[j] = true;
					array[j] = i;
					
					Permutate(i + 1, n);
					used[j] = false;
				}
			}
		}
	}
	
	private static void Permutate(int n) {
		Permutate(1, n);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		array = new int[n];
		used = new boolean[n];
		Permutate(n);
		System.out.println("Count of permutations: " + countOfPermutations);
	}
}
