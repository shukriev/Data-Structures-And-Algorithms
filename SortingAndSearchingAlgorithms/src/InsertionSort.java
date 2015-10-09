
public class InsertionSort {
	
	public static void swapElements(int currentElement, int nextElement) {
		int temp = currentElement;
		currentElement = nextElement;
		nextElement = currentElement;
	}
	
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 0) {
			System.out.println("Function is require a valid array");
		}
		
		int rightIndex = 0;
		int leftIndex = -1;
		
		while(rightIndex < arr.length) {
			for (int i = 1; i < arr.length; i++) {
				leftIndex = i;
				
				for (int j = leftIndex; j >= 0; j--) {
					if(i == j) {
						continue;
					}else {
						if(arr[i] > arr[j]) {
							continue;
						}else {
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			rightIndex++;
		}
		
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] f = { 2, 3, 4, 1, 5, 1, 1, 5, 7, 3, 1, 2, 6, 8, 15 };
		
		insertionSort(f);
	}

}
