
public class AVLTreeTest {
	
	public static void main(String args[]) {
		AVLTree<Integer> avlTree = new AVLTree<>();
		
		for(int i = 1; i <= 16; i++) {
			avlTree.add(i);
		}
		
		System.out.println(avlTree);
	}
}
