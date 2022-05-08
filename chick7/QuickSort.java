package sortingLab;
public class QuickSort {
	
	private static int MIN_SIZE = 10;
	private int test = 629;
	
	public static void sort(Object arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(Object arr[], int first, int last) {
		if (last - first + 1 < MIN_SIZE) {
			insertionSort(arr, first, last);
		} else {
			int pivotIndex = partition(arr, first, last);
			quickSort(arr, first, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, last);
		}
	}
	
	private static int partition(Object arr[], int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMiddleLast(arr, first, mid, last);
		swap(arr, mid, last - 1);
		int pivotIndex = last - 1;
		
		int indexFromLeft = first +1;
		int indexFromRight = last -2;
		boolean done = false;
		
		while (!done) {
			while (((Comparable) arr[indexFromLeft]).compareTo(arr[pivotIndex]) < 0) {
				indexFromLeft++;
			}
			
			while (((Comparable) arr[indexFromRight]).compareTo(arr[pivotIndex]) > 0) {
				indexFromRight--;
			}
			
			if (indexFromLeft < indexFromRight) {
				swap(arr, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			} else {
				done = true;
			}
		}
		
		swap(arr, pivotIndex, indexFromLeft);
		return indexFromLeft;
	}
	
	private static void sortFirstMiddleLast(Object arr[], int first, int mid, int last) {
		if(((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
			swap(arr, first, mid);
		}
		if(((Comparable) arr[mid]).compareTo(arr[last]) > 0) {
			swap(arr, mid, last);
		}
		if(((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
			swap(arr, first, mid);
		}	
	}

	private static void swap(Object arr[], int idx1, int idx2) {
		Object temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	private static void insertionSort(Object arr[], int first, int last) {
		for(int i = first; i < last; i++) {
			for(int j = i + 1; j > first; j--) {
				int res = ((Comparable) arr[j]).compareTo(arr[j-1]);
				if(res < 0) {
					swap(arr, j, j-1);
				} else {
					break;
				}
			}
		}
	}

	
	
}
