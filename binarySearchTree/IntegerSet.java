package binarySearchTree;

import java.util.Arrays;
import java.util.LinkedList;

public class IntegerSet {

	private Node root;
    private int size;
    
    public IntegerSet() {
    	clear();
    }
    
    public IntegerSet(int array[]) {
    	clear();
    	for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
    }
    
    public int magnitude() {
        return size;
    }
    
    public void clear() {
    	root = null;
    	size = 0;
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    //adds a new integer to the set, no duplicates
    public boolean add(int newItem) {
    	boolean added = false;
		if(isEmpty()) {
			root = new Node(newItem);
			size += 1;
			added = true;
		} else {
			added = add(null, root, newItem);
		}
		
		return added;
    }
    
    private boolean add(Node parent, Node current, int data) {
		boolean added = false;
		if(current == null) {
			if(data < parent.data) {
				parent.leftChild = new Node(data);
			} else {
				parent.rightChild = new Node(data);
			}
			size += 1;
			return true;
		} else if(data < current.data) {
			added = add(current, current.leftChild, data);
		} else if(data > current.data) {
			added = add(current, current.rightChild, data);
		} else {
			return false;
		}
		
		fixHeight(current);
		
		if(added) {
			rebalance(parent, current);
		}
		
		return added;
	}
    
    //removes an integer from the set
    public boolean remove(int itemToRemove) {
		if(isEmpty()) {
			return false;
		} else if(size == 1 && root.data == itemToRemove) {
			clear();
			return true;
		} else if(removeTraversal(null, root, itemToRemove)){
			size -= 1;
			return true;
		} else {
			return false;
		}
    }

    private boolean removeTraversal(Node parent, Node current, int data) {
		boolean removed = true;
		if(current == null) {
			return false;
		} else if(data < current.data) {
			removed = removeTraversal(current, current.leftChild, data);
		} else if(data > current.data) {
			removed = removeTraversal(current, current.rightChild, data);
		} else {
			removeNode(parent, current);
		}
		
		fixHeight(current);
		
		if(removed) {
			rebalance(parent, current);
		}
		
		return removed;
	}
	
	private void removeNode(Node parent, Node current) {
		if(current.leftChild == null && current.rightChild == null) {
			//Remove leaf node
			removeCase1(parent, current);
		} else if(current.leftChild != null && current.rightChild == null) {
			//Remove node with no right child
			removeCase2(parent, current);
		} else if(current.leftChild == null && current.rightChild != null) {
			//Remove node with no left child
			removeCase3(parent, current);
		} else {
			//Remove node with both children
			removeCase4(parent, current);
		}
		
		fixHeight(parent);
		
	}
	
	private void removeCase1(Node parent, Node current) {
		if(parent == null) {
			root = null;
		} else if(parent.leftChild == current) {
			parent.leftChild = null;
		} else {
			parent.rightChild = null;
		}
	}
	
	private void removeCase2(Node parent, Node current) {
		if(parent == null) {
			root = root.leftChild;
		} else if(parent.leftChild == current) {
			parent.leftChild = current.leftChild;
		} else {
			parent.rightChild = current.leftChild;
		}
		current.leftChild = null;
	}
	
	private void removeCase3(Node parent, Node current) {
		if(parent == null) {
			root = root.rightChild;
		} else if(parent.leftChild == current) {
			parent.leftChild = current.rightChild;
		} else {
			parent.rightChild = current.rightChild;
		}
		current.rightChild = null;
	}
	
	private void removeCase4(Node parent, Node current) {
		Node leftMost = current.rightChild;
		Node leftMostParent = current;
		
		while(leftMost.leftChild != null) {
			leftMostParent = leftMost;
			leftMost = leftMost.leftChild;
		}
		
		current.data = leftMost.data;
		
		removeNode(leftMostParent, leftMost);
		rebalance(current, current.rightChild);
	}
    
    //returns whether a value is in the set, T/F
    public boolean contains(int itemToFind) {
    	return contains(itemToFind, root);
    }
    
    private boolean contains(int itemToFind, Node currentNode) {
    	if(itemToFind == currentNode.data) {
    		return true;
    	}
    	if(itemToFind < currentNode.data && currentNode.leftChild != null && contains(itemToFind, currentNode.leftChild)) {
    		return true;
    	}
    	if(itemToFind > currentNode.data && currentNode.rightChild != null && contains(itemToFind, currentNode.rightChild)) {
    		return true;
    	}
    	
    	return false;
    }
    
    //the mathematical union of two sets which creates a new set that contains all the elements from both sets
    public IntegerSet union(IntegerSet other) {
    	int arr1[] = inOrderToArray();
    	int arr2[] = other.inOrderToArray();
    	int[] unionSet = new int[arr1.length + arr2.length];
    	
    	for (int i = 0; i < arr1.length; i++) {
			unionSet[i] = arr1[i];
		}
    	
    	for (int i = 0; i < arr2.length; i++) {
			unionSet[arr1.length + i] = arr2[i];
		}
    	
		return new IntegerSet(unionSet);
    }

    //the mathematical intersection operation on two sets that returns a new set that contains elements that belong to both sets
    public IntegerSet intersection(IntegerSet other) {
    	int arr1[] = inOrderToArray();
    	int arr2[] = other.inOrderToArray();
    	int[] intersectionSet;
    	int index = 0;
    	
    	if(arr1.length < arr2.length) {
    		intersectionSet = new int[arr1.length];
    		for (int i = 0; i < arr1.length; i++) {
				if (other.contains(arr1[i])) {
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
    	
    	int[] truncatedIntersectionSet = truncateArray(intersectionSet, index);
		return new IntegerSet(truncatedIntersectionSet);
    }
    
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
    
    //the difference of one set from another are the elements in the set on the left hand side that are not in the set on the right hand side
    public IntegerSet difference(IntegerSet other) {
    	int arr1[] = inOrderToArray();
    	int arr2[] = other.inOrderToArray();
    	int arrdiff[] = new int[arr1.length];
    	int index = 0;
    	
    	for (int i = 0; i < arr1.length; i++) {
    		boolean contains = false;
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					contains = true;
				}
			}
			if(contains == false) {
				arrdiff[index] = arr1[i];
				index++;
			}
		}
    	int[] truncatedArrDiff = truncateArray(arrdiff, index);
		return new IntegerSet(truncatedArrDiff);
    }
    
    //the symmetric difference between two sets are the elements in either set not found in the other set, just the elements they don't have in common
    public IntegerSet symmetricDifference(IntegerSet other) {
    	IntegerSet diff1 = difference(other);
    	IntegerSet diff2 = other.difference(this);
		return diff1.union(diff2);
    }
    
    //returns the smallest number in the set
    public int getMin() {
    	if(isEmpty()) {
    		throw new EmptyCollectionException("Cannot find min from an empty tree");
    	}
    	Node currentNode = root;
    	while(currentNode.leftChild != null) {
    		currentNode = currentNode.leftChild;
    	}
    	
    	return currentNode.data;
    }
    
    //returns the largest number in the set
    public int getMax() {
    	if(isEmpty()) {
    		throw new EmptyCollectionException("Cannot find max from an empty tree");
    	}
    	Node currentNode = root;
    	while(currentNode.rightChild != null) {
    		currentNode = currentNode.rightChild;
    	}
    	return currentNode.data;
    }

    // use in order traversal to create the string
    public String toString() {
    	StringBuffer sb = new StringBuffer();
		sb.append("{ ");
		inOrderToString(root, sb);
		sb.append(" }");
		return sb.toString();
	}
	
	private void inOrderToString(Node current, StringBuffer sb) {
		if (current!= null) {
			inOrderToString(current.leftChild, sb);
			if(current.leftChild != null) {
				sb.append(". ");
			}
			
			sb.append(current.data);
			
			if(current.rightChild != null) {
				sb.append(", ");
			}
			inOrderToString(current.rightChild, sb);
		}
    }
	
	public int[] inOrderToArray() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		inOrderToList(root, list);
		return list.stream().mapToInt(i->i).toArray();
	}
	
	private void inOrderToList(Node current, LinkedList<Integer> list) {
		if (current != null) {
			inOrderToList(current.leftChild, list);
			list.add(current.data);
			inOrderToList(current.rightChild, list);
		}
	}
	
	private int balance(Node node) {
		return node.leftHeight - node.rightHeight;
	}
	
	private void rebalance(Node parent, Node node) {
		if(node == null) {
			return;
		}
		//imbalance in left child
		if (balance(node) > 1) {
			//handles case 3
			if(balance(node.leftChild) < 0) {
				//left rotation
				node.leftChild = leftRotation(node.leftChild);
			}
			
			if(parent == null) {
				root = rightRotation(node);
			} else if(parent.leftChild == node) {
				parent.leftChild = rightRotation(node);
			} else {
				parent.rightChild = rightRotation(node);
			}
		//imbalance in right child	
		} else if(balance(node) < -1) {
			//handling case 4
			if(balance(node.rightChild) > 0) {
				node.rightChild = rightRotation(node.rightChild);
			}
			
			if (parent == null) {
				root = leftRotation(node);
			} else if(parent.leftChild == node) {
				parent.leftChild = leftRotation(node);
			} else {
				parent.rightChild = leftRotation(node);
			}
		}
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(Node node) {
		 if(node == null) {
			 return -1;
		 }
		 
		 return Math.max(node.leftHeight, node.rightHeight);
	}
	
	private void fixHeight(Node node) {
		if(node != null) {
			node.leftHeight = getHeight(node.leftChild)+1;
			node.rightHeight = getHeight(node.rightChild)+1;
		}
	}
	
	private Node rightRotation(Node n) {
		Node c = n.leftChild;
		Node t2 = c.rightChild;
		
		c.rightChild = n;
		n.leftChild = t2;
		
		fixHeight(n);
		fixHeight(c);
		
		return c;
	}
	
	private Node leftRotation(Node n) {
		Node c = n.rightChild;
		Node t2 = c.leftChild;
		
		c.leftChild = n;
		n.rightChild = t2;
		
		fixHeight(n);
		fixHeight(c);
		
		return c;
	}
	

    private class Node {
    	private int data;
		private Node leftChild;
    	private Node rightChild;
    	
		private int leftHeight;
		private int rightHeight;
    	
    	private Node(int data, Node leftChild, Node rightChild) {
    		this.data = data;
    		this.leftChild = leftChild;
    		this.rightChild = rightChild;
    	}
    	
    	private Node(int data) {
    		this.data = data;
    		this.leftChild = null;
    		this.rightChild = null;
    	}
    }
    
}