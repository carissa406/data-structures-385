package integerSet;

import java.util.Arrays;

public class Test {
    public static void main(String args[]) {
	int arr1[] = new int[35];
	int arr2[] = new int[65];
	
	IntArrayOperations.randomFillArray(arr1, 0, 100);
	System.out.println(Arrays.toString(arr1));

	IntArrayOperations.randomFillArray(arr2, 50, 150);
	System.out.println(Arrays.toString(arr2));

	IntegerSet iS1 = new IntegerSet(arr1);
	IntegerSet iS2 = new IntegerSet(arr2);
	System.out.println("iS1: " + iS1);
	System.out.println("iS2: " + iS2);
	
	int toCheck = 15;
	System.out.println(String.format("iS1.contains(%d): ", toCheck) + iS1.contains(toCheck));
	System.out.println(iS1.intersection(iS2));
	System.out.println(iS1.union(iS2));
    }
}
