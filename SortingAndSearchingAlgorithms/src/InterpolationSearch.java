
public class InterpolationSearch {
	public static int search(int arr[], int elementForSearch) {
		int low = 0;
		int high = arr.length - 1;
		int mid = -1;
		
		while(arr[low] <= elementForSearch && arr[high] >= elementForSearch) {
			mid = low + ((elementForSearch - arr[low]) 
					* (high - low) / (arr[high] - arr[low]));
			
			if(arr[mid] < elementForSearch) {
				low = mid + 1;
			}else if (arr[mid] > elementForSearch) {
				high = mid - 1 ;
			}else {
				return mid;
			}
		}
		
		if(arr[low] == elementForSearch) {
			return low;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 3, 67877, 7, 5, 6, 10, 14, 20, 44 };
		System.out.println(search(arr, 20));
	}

}
