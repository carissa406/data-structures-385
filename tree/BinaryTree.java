package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private Node root;
	
	private int size;
	
	public BinaryTree() {
		clear();
	}
	
	public int getHeight() {
		return getHeight(root) - 1;
	}
	
	public int getHeight(T subtree) {
		Node sub = getNode(subtree);
		if(sub == null) {
			String errMsg = String.format("Element %s does not exist.", subtree);
			throw new ElementDoesNotExistException(errMsg);
		}
		return getHeight(sub) - 1;
	}
	
	private int getHeight(Node current) {
		if(current == null) {
			return 0;
		} else {
			int leftSubtree = 1 + getHeight(current.leftChild);
			int rightSubtree = 1+ getHeight(current.rightChild);
			return leftSubtree > rightSubtree ? leftSubtree : rightSubtree;
		}
	}
	
	public String postorderToString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ ");
		postorderToString(sb, root);
		sb.append(" }");
		
		return sb.toString();
	}
	
	private void postorderToString(StringBuffer sb, Node current) {
		if(current != null) {
			
			postorderToString(sb, current.leftChild);
			if(current.leftChild != null) {
				sb.append(", ");
			}
			
			postorderToString(sb, current.rightChild);
			if(current.rightChild != null) {
				sb.append(", ");
			}
			
			sb.append(current.data);
		}
		
	}

	public String inorderToString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ ");
		inorderToString(sb, root);
		sb.append(" }");
		
		return sb.toString();
	}
	
	private void inorderToString(StringBuffer sb, Node current) {
		if(current != null) {
			
			inorderToString(sb, current.leftChild);
			if(current.leftChild != null) {
				sb.append(", ");
			}
			
			sb.append(current.data);
			
			if(current.rightChild != null) {
				sb.append(", ");
			}
			inorderToString(sb, current.rightChild);
		}
		
	}

	public String preorderToString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ ");
		preorderToString(sb, root);
		sb.append(" }");
		
		return sb.toString();
	}
	
	private void preorderToString(StringBuffer sb, Node current) {
		if(current != null) {
			
			sb.append(current.data);
			if(current.leftChild != null) {
				sb.append(", ");
			}
			preorderToString(sb, current.leftChild);
			if(current.rightChild != null) {
				sb.append(", ");
			}
			preorderToString(sb, current.rightChild);
		}
	}
	
	public void add(T newItem) {
		if(isEmpty()) {
			root = new Node(newItem);
		} else {
			Node current = root;
			Queue<Node> q = new LinkedList<Node>();
			q.add(current);
			
			while(true) {
				current = q.remove();
				
				if(current.leftChild != null) {
					q.add(current.leftChild);
				} else {
					break;
				}
				
				if(current.rightChild != null) {
					q.add(current.rightChild);
				} else {
					break;
				}
			}
			
			if(current.leftChild == null) {
				current.leftChild = new Node(newItem);
			} else {
				current.rightChild = new Node(newItem);
			}
		}
		
		size+=1;
	}
	
	public void remove(T toRemove) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty tree");
		}
		
		if(root.data.equals(toRemove) && size == 1) {
			clear();
//		} else if (size ==1) {
//			String errMsg = String.format("The item to remove %s does not exist.", toRemove);
//			throw new ElementDoesNotExistException(errMsg);			
		} else {
			Node nodeToRemove = getNode(toRemove);
			if(nodeToRemove == null) {
				String errMsg = String.format("The item to remove %s does not exist.", toRemove);
				throw new ElementDoesNotExistException(errMsg);
			}
			
			if(isLeafNode(nodeToRemove)) {
				removeLeafNode(nodeToRemove);
			} else {
				Node deepestLeafNode = deepest(nodeToRemove);
				T temp = deepestLeafNode.data;
				deepestLeafNode.data = nodeToRemove.data;
				nodeToRemove.data = temp;
				removeLeafNode(deepestLeafNode);
				
			}
			size -= 1;
		}
	}
	
	private Node deepest(Node subtreeRoot) {
		Node current = subtreeRoot;
		Queue<Node> q = new LinkedList<>();
		
		q.add(current);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			if(current.leftChild != null) {
				q.add(current.leftChild);
			}
			
			if(current.rightChild != null) {
				q.add(current.rightChild);
			}
		}
		
		return current;
	}
	
	private void removeLeafNode(Node toRemove) {
		Node parent = getParent(toRemove);
		
		if(parent.leftChild == toRemove) {
			parent.leftChild = null;
		} else {
			parent.rightChild = null;
		}
	}
	
	private boolean isLeafNode(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
	
	private Node getParent(Node child) {
		Node current = root;
		Queue<Node> q = new LinkedList<>();
		
		q.add(current);
		
		while(true) {
			current = q.remove();
			
			if(current.leftChild == child || current.rightChild == child) {
				return current;
			}
			
			if(current.leftChild != null) {
				q.add(current.leftChild);
			}
			
			if(current.rightChild != null) {
				q.add(current.rightChild);
			}
		}
	}
	
	private Node getNode(T toGet) {
		Node current = root;
		Queue<Node> q = new LinkedList<>();
		
		q.add(current);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			if(current.data.equals(toGet)) {
				return current;
			}
			
			if(current.leftChild != null) {
				q.add(current.leftChild);
			}
			
			if(current.rightChild != null) {
				q.add(current.rightChild);
			}
		}
		
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void clear() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{ ");
		if(!isEmpty()) {
			levelOrderString(sb);
		}	
		sb.append(" }");
		return sb.toString();
	}
	
	private void levelOrderString(StringBuffer sb) {
		Node current = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(current);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			sb.append(current.data);
			
			if(current.leftChild != null | current.rightChild != null) {
				sb.append(", ");
			}
			
			if(current.leftChild != null) {
				q.add(current.leftChild);
			}
			
			if(current.rightChild != null) {
				q.add(current.rightChild);
			}
			
			if(!q.isEmpty()) {
				sb.append(", ");
			}
			
		}
		
	}
	
	private class Node{
		private Node leftChild;
		private Node rightChild;
		private T data;
		
		public Node(T data) {
			this.data = data;
		}
	}
}
