package Final;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OuterTest {
	
	private static void testEmptyTree() {
		System.out.println("************TESTING EMPTY TREE**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	private static void testSingleNode() {
		System.out.println("************TESTING SINGLE NODE**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 50 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 50 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}
	
	private static void testThreeNodes() {
		System.out.println("************TESTING THREE NODE TREE**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 50, 25, 75 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 50, 25, 75 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}
	
	private static void testBalancedTree7() {
		System.out.println("************TESTING BALANCED TREE 7**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 63, 22,78, 16, 28, 65, 85, 7, 21, 25, 51, 64, 72, 82, 92, 3, 13, 27, 31, 55, 69, 79, 83, 86, 33 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 63, 22, 16, 7, 3, 13, 21, 25, 27, 31, 33, 55, 64, 69, 72, 79, 83, 86, 92, 85, 78 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}
	
	private static void testBalancedTree6() {
		System.out.println("************TESTING BALANCED TREE 6**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 36, 19, 73, 8, 22, 58, 75, 23, 94 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 36, 19, 8, 22, 23, 58, 75, 94, 73});

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}
	
	private static void testBalancedTree5() {
		System.out.println("************TESTING BALANCED TREE 5**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 65, 26, 83, 15, 27, 68, 84, 21, 63, 80, 92 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 65, 26, 15, 21, 27, 63, 68, 80, 92, 84, 83 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	private static void testBalancedTree4() {
		System.out.println("************TESTING BALANCED TREE 4**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 77, 26, 78, 32, 80 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 77, 26, 32, 80, 78 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	private static void testBalancedTree3() {
		System.out.println("************TESTING BALANCED TREE 3**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 50, 25, 75, 15, 35, 70, 85, 20, 80 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 50, 25, 15, 20, 35, 70, 80, 85, 75 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	private static void testBalancedTree2() {
		System.out.println("************TESTING BALANCED TREE 2**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 15, 6, 50, 4, 7, 23, 71, 5 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 15, 6, 4, 5, 7, 23, 71, 50 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	private static void testBalancedTree1() {
		System.out.println("************TESTING BALANCED TREE 1**********");
		AVLTree<Integer> balanced = new AVLTree<>();
		Integer nums[] = { 50, 25, 75, 20, 35, 70, 85, 15, 23, 30, 37, 65, 73, 80, 90 };

		for (Integer n : nums) {
			balanced.add(n);
		}

		System.out.println("Testing tree: " + balanced);

		List<Integer> ansList = Arrays.asList(new Integer[] { 50, 25, 20, 15, 23, 30, 37, 65, 73, 80, 90, 85, 75 });

		Set<Integer> ans = new HashSet<>();

		for (Integer num : ansList) {
			ans.add(num);
		}

		System.out.println("\tExpected:\t" + ans);

		Set<Integer> outer = balanced.outer();
		System.out.println("\tYour Output:\t" + outer);

		System.out.println("\t" + (ans.equals(outer) ? "[+] PASS\n" : "[-] FAIL\n"));
	}

	public static void main(String[] args) {
		testEmptyTree();
		testSingleNode();
		testThreeNodes();
		testBalancedTree1();
		testBalancedTree2();
		testBalancedTree3();
		testBalancedTree4();
		testBalancedTree5();
		testBalancedTree6();
		testBalancedTree7();
	}
}
