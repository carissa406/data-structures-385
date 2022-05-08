package listi;

public class DoublyLinkedList<T> implements IList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	private int size;
	
	public DoublyLinkedList() {
		clear();
	}

	private void clear() {
		head = null;
		tail = null;
		size = 0;
		
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
		head = new Node<T>(obj);
		tail = head;
		size += 1;
	}

	@Override
	public void add(int index, T obj) {
		validateIndex(index, 0, size);
		if(isEmpty()) {
			addToEmptyList(obj);
		} else if (index == 0) {
			prepend(obj);
		} else if(index == size) {
			append(obj);
		} else {
			//add to middle
			Node<T> temp = getNode(index);
			Node<T> newNode = new Node<T>(obj);
			temp.prev.next = newNode;
			newNode.prev = temp.prev;
			temp.prev = newNode;
			newNode.next = temp;
			size += 1;
		}
		
	}

	public void append(T obj) {
		if (isEmpty()) {
			addToEmptyList(obj);
		}
		Node<T> newNode = new Node<T>(obj);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size += 1;
		
	}

	public void prepend(T obj) {
		if (isEmpty()) {
			addToEmptyList(obj);
		} else {
			Node<T> newNode = new Node<T>(obj);
			head.prev = newNode;
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
			temp = temp.next;
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection");
		}
		validateIndex(index, 0, size - 1);
		if(index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<T> toRemove = getNode(index);
			toRemove.prev.next = toRemove.next;
			toRemove.next.prev = toRemove.prev;
			toRemove.next = null;
			toRemove.prev = null;
			size -= 1;
			return toRemove.data;
		}
	}

	public T removeLast() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection");
		}
		Node<T> temp = tail;
		if(size == 1) {
			clear();
		} else {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			size -= 1;
		}
		return temp.data;
	}

	public T removeFirst() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection");
		}
		Node<T> temp = head;
		if(size == 1) {
			clear();
		} else {
			head = head.next;
			head.prev.next = null;
			head.prev = null;
			size -= 1;
		}
		return temp.data;
	}

	@Override
	public boolean remove(T obj) {
		int indexToRemove = indexOf(obj);
		if(indexToRemove != -1) {
			remove(indexToRemove);
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("((");
		if(!isEmpty()) {
			Node<T> temp = head;
			while (temp.next != null) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append("))");
		return sb.toString();
	}
	
	private void validateIndex(int index, int lowerBound, int upperBound) {
		if(!(index >= lowerBound && index <= upperBound)) {
			throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", lowerBound, upperBound));
		}
	}
	
	private Node<T> getNode(int index){
		Node<T> temp = index <= size / 2 ? head : tail;
		if(temp == head) {
			//go forward
			for( int i = 0; i < index; i ++) {
				temp = temp.next;
			}
			return temp;
		} else {
			//go backwards
			for(int i = size - 1; i > index; i --) {
				temp = temp.prev;
			}
			return temp;
		}
	}
	
	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
		
		public Node(E data) {
			this.data = data;
		}
	}
}
