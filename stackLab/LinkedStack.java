package stackLab;

public class LinkedStack<T> {
	
	private class Node<T> {
		T data;
		Node<T> previous;
	
	
		public Node(T data, Node<T> previous) {
			this.data = data;
			this.previous = previous;
		}
	}
	
	Node<T> top;
	int size;
	
	public void clear() {
		top = null;
		size = 0;
	}
	
	public int getsize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(T item) {
		Node<T> newTop = new Node(item, top);
		top = newTop;
		size+=1;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> temp = top;
		sb.append("TOP [");
		
		while(temp != null) {
			sb.append(temp.data);
			
			if(temp.previous != null) {
				sb.append(", ");
			}
			
			temp = temp.previous;
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot pop from an empty stack");
		}
		
	    T removed = top.data;
	    Node<T> temp = top;
	    top = top.previous;
	    temp.previous = null;
	    size -= 1;
	    return removed;
	}
	
	public T peek() {
	    if(isEmpty()) {
	        throw new EmptyCollectionException("Cannot peek in an empty stack.");
	    }
	    return top.data;
	}
	
}
