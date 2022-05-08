package listi;

public class SinglyLinkedList<T> implements IList<T>{

	private Node<T> head;
	private int size;
	
	public SinglyLinkedList() {
		clear();
	}
	
	public void clear() {
		size = 0;
		head = null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public T get(int index) {
		validateIndex(index, 0, size - 1);
		Node<T> temp = getNode(index);
		return temp.data;
	}

	@Override
	public void set(int index, T obj) {
		validateIndex(index, 0, size - 1);
		Node<T> temp = getNode(index);
		temp.data = obj;
	}
	
	private void addToEmptyList(T obj) {
		Node<T> newNode = new Node<T>(obj);
		head = newNode;
		size += 1;
	}

	@Override
	public void add(int index, T obj) {
		validateIndex(index, 0, size);
		if(isEmpty()) {
			addToEmptyList(obj);
		} else if(index == 0) {
			prepend(obj);
		} else if(index == size) {
			append(obj);
		} else {
			Node<T> temp = getNode(index);
			Node<T> newNode = new Node<T>(obj);
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

	@Override
	public int indexOf(T obj) {
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			if(temp.data.equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		validateIndex(index, 0, size -1);
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

	@Override
	public boolean remove(T obj) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty collection");
		}
		int indexToRemove = indexOf(obj);
		if(indexToRemove != -1) {
			remove(indexToRemove);
			return true;
		}
		return false;
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
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if(!isEmpty()) {
			Node<T> temp = head;
			for(int i=0; i< size-1; i++) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append(")");
		return sb.toString();
	}
	
	private void validateIndex(int index, int lowerBound, int upperBound) {
		if(!(index >= lowerBound && index <= upperBound)) {
			throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", lowerBound, upperBound));
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
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
		}
	}
}
