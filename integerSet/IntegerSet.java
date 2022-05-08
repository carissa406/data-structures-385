package integerSet;

public class IntegerSet {

    // The array that represents the set.
    private final int set[];
    private static int MIN_SIZE = 10;

    /**
     * The constructor for IntegerSet. When an IntegerSet is created it must be
     * initialized with an integer array. The set will then pull out the duplicated
     * items and keep the unique integers.
     * 
     * @param arr
     *            The array to create the set from.
     */
    public IntegerSet(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("The array must not be null");
		}
		set = uniqueElements(arr);
    }

    /**
     * This is the size of the set which, in this case, is just the length of the
     * array.
     * 
     * @return The length of the set.
     */
    public int magnitude() {
		return set.length;
    }
    
    public int[] getSet() {
    	return IntArrayOperations.getCopy(set);
    }

    //quick sort
    
    public static void sort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int arr[], int first, int last) {
		if (last - first + 1 < MIN_SIZE) {
			insertionSort(arr, first, last);
		} else {
			int pivotIndex = partition(arr, first, last);
			quickSort(arr, first, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, last);
		}
	}
	
	private static int partition(int arr[], int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMiddleLast(arr, first, mid, last);
		swap(arr, mid, last - 1);
		int pivotIndex = last - 1;
		
		int indexFromLeft = first +1;
		int indexFromRight = last -2;
		boolean done = false;
		
		while (!done) {
			while (arr[indexFromLeft] < arr[pivotIndex]) {
				indexFromLeft++;
			}
			
			while (arr[indexFromRight] > arr[pivotIndex]) {
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
	
	private static void sortFirstMiddleLast(int[] arr, int first, int mid, int last) {
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

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	private static void insertionSort(int[] arr, int first, int last) {
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
	
    /**
     * This method is private and is used to help set up the set array. An integer
     * set is one in which the elements are unique (no duplicates) and are sorted.
     * 
     * @param arr
     *            The array that will be used to retrieve the unique elements from.
     * @return The new integer array that contains the unique elements from arr.
     */
    
    private int[] uniqueElements(int arr[]) {
    	if(arr.length <= 1) {
    		return arr;
    	}
    	
    	int sortArr[] = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
			sortArr[i] = arr[i];
		}
    	sort(sortArr);
    	
    	Integer uniqueArr[] = new Integer[arr.length];
    	int currentVal = sortArr[0];
    	uniqueArr[0] = currentVal;
    	int size = 1;
    	for (int i = 1; i < sortArr.length; i++) {
    		if(sortArr[i] != currentVal) {
    			currentVal = sortArr[i];
    			uniqueArr[i] = currentVal;
    			size++;
    		} else {
    			uniqueArr[i] = null;
    		}
		}
    	
    	int returnArr[] = new int[size];
    	int index = 0;
    	for (int i = 0; i < uniqueArr.length; i++) {
			if(uniqueArr[i] != null) {
				returnArr[index] = uniqueArr[i];
				index++;
			}
		}
    	
    	return returnArr;
    }

    /**
     * This method returns whether or not value is located in the set. If the value
     * is in the set then return true otherwise return false. <br />
     * Example:
     * <pre>
     * 		IntegerSet iS1 = new IntegerSet([1,2,3,4]); 
     * 		iS1.contains(3); //returns true
     * 		iS2.contains(6); //returns false
     * </pre>
     * 
     * @param value
     *            The integer to look for.
     * @return True if value is located in the set otherwise false.
     */
    public boolean contains(int value) {
    	for (int i = 0; i < set.length; i++) {
			if(set[i] == value) {
				return true;
			}
		}
		return false;
    }

    /**
     * A union of two sets is a new set that contains all elements from both sets.
     * This method takes another set and unions it with the set that calls this
     * method. A new IntegerSet is returned that contains the union of both sets.<br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1, 2, 3, 4]); 
     * 		IntegerSet is2 = new IntegerSet([3, 4, 5, 6, 7, 8]);
     * 		is1.union(is2) //returns new IntegerSet([1, 2, 3, 4, 5, 6, 7, 8]);
     * </pre>
     * 
     * @param otherSet
     *            The set to be unioned with.
     * @return A new IntegerSet that is the union of the calling set with the
     *         otherSet.
     */
    public IntegerSet union(IntegerSet otherSet) {
    	int[] arr1 = this.getSet();
    	int[] arr2 = otherSet.getSet();
    	int[] unionSet = new int[arr1.length + arr2.length];
    	
    	for (int i = 0; i < arr1.length; i++) {
			unionSet[i] = arr1[i];
		}
    	
    	for (int i = 0; i < arr2.length; i++) {
			unionSet[arr1.length + i] = arr2[i];
		}
    	
		return new IntegerSet(unionSet);
    }

    /**
     * The intersection of two sets is a new set that contains elements that occur
     * in both sets. This method takes another set and intersects it with the set
     * that calls this method. A new IntegerSet is returned that contains the
     * intersection of the two sets. <br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1,2,3,4]);
     * 		IntegerSet is2 = new IntegerSet([3,4,5]);
     * 		is1.intersection(is2) //returns new IntegerSet([3, 4]);
     * </pre>
     * 
     * @param otherSet
     *            The set to be intersected with.
     * @return A new IntegerSet that is the intersection of the calling set with the
     *         otherSet.
     */
    public IntegerSet intersection(IntegerSet otherSet) {
    	int[] arr1 = this.getSet();
    	int[] arr2 = otherSet.getSet();
    	int[] intersectionSet;
    	int index = 0;
    	
    	if(arr1.length < arr2.length) {
    		intersectionSet = new int[arr1.length];
    		for (int i = 0; i < arr1.length; i++) {
				if (otherSet.contains(arr1[i])) {
					intersectionSet[index] = arr1[i];
					index++;
				}
			}
    	} else {
    		intersectionSet = new int[arr2.length];
    		for (int i = 0; i < arr2.length; i++) {
				if (this.contains(arr2[i])) {
					intersectionSet[index] = arr2[i];
					index++;
				}
			}
    	}    	
    	
    	int[] truncatedIntersectionSet = IntArrayOperations.truncateArray(intersectionSet, index);
		return new IntegerSet(truncatedIntersectionSet);
    }

    /**
     * Returns a string representation of an IntegerSet type. The returned string
     * will have the following structure.
     * 
     * set{ elements in the set separated by a comma }.
     * 
     * 
     */
    
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("set{ ");
		for (int i = 0; i < set.length; i++) {
			sb.append(set[i]);
			if (i < set.length - 1) {
			sb.append(", ");
			}
		}
		sb.append(" }");
		return sb.toString();
    }
}
