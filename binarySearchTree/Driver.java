package binarySearchTree;

import AVLLab.AVLTree;

public class Driver {

	public static void main(String[] args) {
		IntegerSet integerSet = new IntegerSet();
		IntegerSet integerSet2 = new IntegerSet();
		
		for(int i = 1; i <= 32; i++) {
			integerSet.add(i);
		}
		
		for(int i = -1; i <= 10; i++) {
			integerSet2.add(i);
		}
		
		integerSet.remove(12);
		
		System.out.println(integerSet);
		System.out.println(integerSet2);
		System.out.println(" \n");
		System.out.println(integerSet.union(integerSet2));
		System.out.println(integerSet.intersection(integerSet2));
		System.out.println(integerSet.difference(integerSet2));
		System.out.println(integerSet.symmetricDifference(integerSet2));
		System.out.println(" \n");
		System.out.println(integerSet.getMin());
		System.out.println(integerSet.getMax());
		System.out.println(" \n");
		System.out.println(integerSet.contains(12));
		System.out.println(integerSet.contains(13));
		

	}

}
