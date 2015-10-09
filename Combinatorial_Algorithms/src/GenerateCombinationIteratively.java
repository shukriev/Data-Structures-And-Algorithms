
public class GenerateCombinationIteratively {
	private static int[] array;
	
	private static void PrintResult() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static boolean IterateCombination(int n) {
		int index = array.length - 1;
		
		while (index >= 0) {
			int temp = array[index] + 1;
			array[index] = temp;
			if (array[index] == n) {
				array[index] = 1;
				index--;
			}else {
				break;
			}
		}
		return false;
	}
	
	private static void GenerateCombination(int n) {
		boolean iterateCombination = true;
		
		while (iterateCombination) {
			iterateCombination = IterateCombination(n);
			PrintResult();
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		array = new int[n];
		GenerateCombination(n);
	}

}
