import java.util.Arrays;

import javax.xml.stream.events.EndDocument;


public class MergeSort {
	
	public static void topDownMergeSort(int[] a, int[] b, int n) {
		topDownSplitMerge(a, 0, n, b);
	}
	
	public static void topDownSplitMerge(int[] a, int beginElement, int endElement, int[] b) {
		if(endElement - beginElement < 2) {
			return;
		}else {
			int middleElement = (endElement + beginElement) / 2;
			topDownSplitMerge(a, beginElement, middleElement, b);
			topDownSplitMerge(a, middleElement, endElement, b);
			topDownMerge(a, beginElement, middleElement, endElement, b);
			copyArray(b, beginElement, endElement, a);
		}
	}
	
	public static void topDownMerge(int[] a, int beginElement, int middleElement, int endElement, int[] b) {
		int i1 = beginElement;
		int j1 = middleElement;
		
		for (int i = beginElement; i < endElement; i++) {
			if(i1 < middleElement && (j1 >= endElement || a[i1] <= a[j1])) {
				b[i] = a[i1];
				i1 = i1 + 1;
			}else {
				b[i] = a[j1];
				j1 = j1 + 1;
			}
		}
	}
	
	public static void copyArray(int[] b, int beginIndex, int endIndex, int[] a) {
		for(int k = beginIndex; k < endIndex; k++) {
			a[k] = b[k];
		}
	}
	public static void main(String[] args) {
		int[] arr = { 7, 6, 4, 1, 5, 3, 1, 3, 2, 6 };
		int[] rs = new int[arr.length];
		topDownMergeSort(arr, rs, arr.length);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
