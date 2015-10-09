import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class FisherYates {
	public static void shuffleSort(int[] arr) {
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			
			int tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 3 ,5 ,8, 5, 8, 5, 3, 7, 8, 21, 64, 32};
		shuffleSort(arr);
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

}
