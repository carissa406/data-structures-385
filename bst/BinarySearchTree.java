package datastructures.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	private int size;
	
	public BinarySearchTree() {
		clear();
	}
	
	public boolean add(T newItem) {
		if(isEmpty()) {
			root = new Node(newItem);
		} else {
			Node parent = null;
			Node temp = root;
			
			while(temp != null) {
				parent = temp;
				
				int result = newItem.compareTo(temp.data);
				
				if(result < 0) {
					temp = temp.left;
				} else if (result > 0) {
					temp = temp.right;
				} else {
					return false;
				}
			}
			
			int result = newItem.compareTo(parent.data);
			
			if (result < 0 ) {
				parent.left = new Node(newItem);
			} else {
				parent.right = new Node(newItem);
			}
		}
		
		size += 1;
		return true;
	}
	
	public boolean remove(T itemToRemove) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty tree");
		}
		if(size == 1 && root.data.equals(itemToRemove)) {
			clear();
		} else {
			Node parent = null;
			Node temp = root;
			
			while(temp != null && !temp.data.equals(itemToRemove)) {
				parent = temp;
				
				int result = itemToRemove.compareTo(temp.data);
				
				if(result < 0) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			
			if(temp == null) {
				return false;
			}
			
			removeNode(parent, temp);
			size -= 1;
		}
		return true;
	}
	
	private void removeNode(Node parent, Node toRemove) {
		if(isLeaf(toRemove)) {
			if(parent.left == toRemove) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (toRemove.left != null && toRemove.right == null) {
			if(parent.left == toRemove) {
				parent.left = toRemove.left;
			} else {
				parent.right = toRemove.right;
			}
			toRemove.left = null;
		} else if(toRemove.right != null && toRemove.left == null) {
			if(parent.left == toRemove) {
				parent.left = toRemove.right;
			} else {
				parent.right = toRemove.right;
			}
			toRemove.right = null;
		} else {
			Node parentOfLeftmost = toRemove;
			Node leftmost = toRemove.right;
			
			while(leftmost.left != null) {
				parentOfLeftmost = leftmost;
				leftmost = leftmost.left;
			}
			
			toRemove.data = leftmost.data;
			
			removeNode(parentOfLeftmost, leftmost);
		}
	}
	
	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String levelOrderToString() {
		StringBuffer sb = new StringBuffer();
		
		Node current= root;
		
		Queue<Node> q = new LinkedList<>();
		q.add(current);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			sb.append(current.data);
			
			if(current.left != null) {
				q.add(current.left);
			}
			
			if(current.right != null) {
				q.add(current.right);
			}
			
			if(!q.isEmpty()) {
				sb.append(", ");
			}
		}
		
		return sb.toString();
		
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{ ");
		inOrderToString(root, sb);
		sb.append(" }");
		return sb.toString();
	}
	
	private void inOrderToString(Node current, StringBuffer sb) {
		if (current!= null) {
			inOrderToString(current.left, sb);
			if(current.left != null) {
				sb.append(". ");
			}
			
			sb.append(current.data);
			
			if(current.right != null) {
				sb.append(", ");
			}
			inOrderToString(current.right, sb);
		}
	}
	
	private class Node{
		private Node left;
		private Node right;
		private T data;
		
		public Node(T data) {
			this.data = data;
		}
	}
}
