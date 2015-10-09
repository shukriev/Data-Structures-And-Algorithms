import java.lang.reflect.Array;
import java.util.Arrays;


public class PermutationswithRepetition {
	
	private static void PrintResult(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static void Permutate(int[] arr, int start, int n) {
		PrintResult(arr);
		int temp = 0;
		
		if(start < n) {
			for(int i = n - 2; i >= start; i--) {
				for (int j = i; j < n; j++) {
					if(arr[i] != arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						
						Permutate(arr, i + 1, n);
					}
				}
				
				temp = arr[i];
				for(int k = i; k < n - 1;)
					arr[k] = arr[++k];
				arr[n - 1] = temp;
			}
		}
	}
	
	private static void PermutationWithRepetition(int[] arr) {
		Arrays.sort(arr);
		Permutate(arr, 0, arr.length);
	}
	 
	public static void main(String[] args) {
		int[] inputArray = { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
				5, 5, 5, 5, 5, 5, 5, 5 };
		PermutationWithRepetition(inputArray);
	}

}
