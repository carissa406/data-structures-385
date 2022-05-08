package sortingLab;
public class MergeSort {
	public static void sort(Object arr[]) {
		mergeSort(arr, new Object[arr.length], 0, arr.length - 1);
	}
	
	private static void mergeSort(Object a[], Object tempArray[], int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(a, tempArray, first, mid);
			mergeSort(a, tempArray, mid+1, last);
			merge(a,tempArray,first,mid,last);
		}
	}
	
	private static void merge(Object a[], Object tempArray[], int first, int mid, int last) {
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid +1;
		int endHalf2 = last;
		int index = 0;
		
		while(beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2) {
			int res = ((Comparable) a[beginHalf1]).compareTo(a[beginHalf2]);
			if(res <= 0) {
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			} else {
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}
			index++;
		}
		
		while(beginHalf1 <= endHalf1) {
			tempArray[index] = a[beginHalf1];
			index ++;
			beginHalf1++;
		}

		while(beginHalf2 <= endHalf2) {
			tempArray[index] = a[beginHalf2];
			index++;
			beginHalf2++;
		}
		
		for(int i = 0, j = first; i <= (last - first); i++, j++) {
			a[j] = tempArray[i];
		}

	}
	
}
