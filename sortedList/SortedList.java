package sortedList;

public class SortedList<T extends Comparable<? super T>> {

	private Node<T> head;
	private int size;
	
	public SortedList() {
		clear();
	}
	
	public void clear() {
		size = 0;
		head = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if(!isEmpty()) {
			Node<T> temp = head;
			for(int i=0; i< size-1; i++) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(int index, T item) {
		validateIndex(index);
		if(isEmpty()) {
			addToEmptyList(item);
		} else if(index == 0) {
			prepend(item);
		} else if(index == size) {
			append(item);
		} else {
			Node<T> temp = getNode(index);
			Node<T> newNode = new Node<T>(item);
			newNode.next = temp.next;
			size += 1;
		}
		
	}
	
	public void append(T obj) {
		if(isEmpty()) {
			addToEmptyList(obj);
		} else {
			Node<T> temp = getNode(size - 1);
			Node<T> newNode = new Node<T>(obj);
			temp.next = newNode;
			size += 1;
		}
		
	}

	public void prepend(T obj) {
		if(isEmpty()) {
			addToEmptyList(obj);
		} else {
			Node<T> newNode = new Node<T>(obj);
			newNode.next = head;
			head = newNode;
			size += 1;
		}
		
	}
	
	private void addToEmptyList(T obj) {
		Node<T> newNode = new Node<T>(obj);
		head = newNode;
		size += 1;
	}

//	public void add(T item) {
//		if(isEmpty()) {
//			head = new Node<T>(item);
//			size++;
//			return;
//		}
//		
//		Node<T> temp = head;
//		while(temp != null) {
//			int compare = temp.getData().compareTo(item);
//			if(temp.data.equals(item)) {
//				
//			}
//			temp = temp.getNext();
//		}
//	}
	
	public T removeAt(int index) {
		validateIndex(index);
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty collection");
		}
		if (index == 0) {
			return removeFirst();
		} else if(index == size - 1) {
			return removeLast();
		} else {
			Node<T> toRemove = head;
			Node<T> previous = null;
			for(int i = 0; i < index; i++) {
				previous = toRemove;
				toRemove = toRemove.next;
			}
			previous.next = toRemove.next;
			toRemove.next = null;
			size -= 1;
			return toRemove.data;
		}
		
	}
	
	public T removeLast() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty collection");
		}
		Node<T> temp = getNode(size - 1);
		temp.next = null;
		size -= 1;
		return temp.data;
	}
	
	public T removeFirst() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty collection");
		}
		Node<T> temp = head;
		head = head.next;
		temp.next = null;
		size -= 1;
		return temp.data;
	}
	
	public T get(int index) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot get from an empty collection");
		}
		validateIndex(index);
		Node<T> temp = getNode(index);
		return temp.data;
	}

	public int count(T item) {
		if (isEmpty()) {
			return 0;
		}
		
		int count = 0;
		Node<T> temp = head;
		while(temp != null) {
			if(temp.data.equals(item)) {
				count++;
			}
			temp = temp.getNext();
		}
		return count;
	}
	
	public int find(T item) {
		if (isEmpty()) {
			return -1;
		}
		
		int index = 0;
		Node<T> temp = head;
		while(temp != null) {
			if(temp.data.equals(item)) {
				return index;
			}
			temp = temp.getNext();
			index++;
		}
		return -1;
	}
	
	public boolean contains(T item) {
		if (isEmpty()) {
			return false;
		}
		
		Node<T> temp = head;
		while(temp != null) {
			if(temp.data.equals(item)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void removeAll() {
		
	}
	
	private void validateIndex(int index) {
		if(!(index >= 0 && index <= size - 1)) {
			throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", 0, size - 1));
		}
	}
	
	private Node<T> getNode(int index){
		Node<T> temp = head;
		for(int i = 0; i < index; i ++) {
			temp = temp.next;
		}
		return temp;
	}
	
	private class Node<E>{
		public E data;
		public Node<E> next;
		
		public Node(E data) {
			this.setData(data);
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

}
