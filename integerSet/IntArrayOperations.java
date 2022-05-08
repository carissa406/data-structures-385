package integerSet;
/**
 * This class gives some common operations for a basic
 * int array.
 * @author Brian Rogers
 *
 */
public class IntArrayOperations {
    /**
     * This method takes an int array and the number of elements to truncate up to.
     * The result is a new int array with elements up to, but not including, count.
     * An example: 
     * <pre>
     * 		arr[] = [1,2,3,4,5,6]
     * 		truncateArray(arr, 3);
     * 		result: [1,2,3]
     * </pre>
     * 
     * @param arr
     *            The array to truncate.
     * @param count
     *            The number of elements to keep.
     * @return An integer array that is the truncated version of arr.
     */
    public static int[] truncateArray(int arr[], int count) {
		if (arr == null) {
			throw new IllegalArgumentException("Truncate Array: The integer array must not be null");
		}
		if (count > arr.length && count < 0) {
			throw new IllegalArgumentException("Count must be between 0 and the array length (inclusive).");
		}
		int result[] = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = arr[i];
		}
		return result;
    }

    /**
     * Returns a copy of an integer array. The new copy will be a new array on the
     * heap so your original array is never touched.
     * 
     * @param arr
     *            The array to be copied.
     * @return A new array that is a copy of arr.
     */
    public static int[] getCopy(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("Get Copy: The integer array must not be null");
		}
		int newArray[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		return newArray;
    }

    /**
     * Prints the array in a nice to read format.
     * 
     * @param arr
     *            An integer array to print to console.
     */
    public static void printArray(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("Print Array: The integer array must not be null");
		}
		System.out.print("[");
		int i = 0;
		for (; i < arr.length - 1; i++) {
			System.out.printf(" %d,", arr[i]);
		}
		if(i < arr.length)  {
			System.out.printf(" %d", arr[i]);
		}
		System.out.println(" ]");
    }

    /**
     * Swaps two elements in an integer array.
     * 
     * @param arr
     *            The array in which the elements will be switched.
     * @param idx1
     *            The first index of an element in the array.
     * @param idx2
     *            The second index of an element in the array.
     */
    public static void swap(int arr[], int idx1, int idx2) {
		if (arr == null) {
			throw new IllegalArgumentException("Swap: The integer array must not be null");
		}
		if (idx1 >= arr.length || idx1 < 0) {
			throw new IllegalArgumentException("Swap: idx1 must be between 0 and arr.length - 1");
		}
		if (idx2 >= arr.length || idx2 < 0) {
			throw new IllegalArgumentException("Swap: idx2 must be between 0 and arr.length - 1");
		}
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
    }

    /**
     * Fills the integer array with numbers 1 to arr.length.
     * @param arr The array to fill.
     */
    public static void fillArray(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("Fill Array: The integer array must not be null");
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) i + 1;
		}
    }

    /**
     * Randomly fills the array with elements between min and max.
     * Example:
     * <pre>
     * 		arr[] = new int[5];
     * 		randomFillArray(arr, 5, 10);
     * 		Possible Result: arr[5, 6, 5, 7, 10]
     * </pre>
     * @param arr The array to fill with random values.
     * @param min The minimum random integer (inclusive)
     * @param max The maximum random integer (inclusive)
     */
    public static void randomFillArray(int arr[], int min, int max) {
		if (arr == null) {
			throw new IllegalArgumentException("Random Fill Array: The integer array must not be null");
		}
		int temp = min;
		min = Math.min(min, max);
		max = Math.max(max, temp);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
		}
    }

    /**
     * Shuffles an array using the Knuth shuffle or Fisher-Yates shuffle algorithm.
     * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Knuth Shuffle</a>
     * @param arr The array to be shuffled.
     */
    public static void shuffle(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("Shuffle: The integer array must not be null");
		}
		for (int j = arr.length - 1; j >= 0; j--) {
			int randomLoc = (int) (Math.random() * j);
			swap(arr, j, randomLoc);
		}
    }
}
