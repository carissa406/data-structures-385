package stackLab;

public class ArrayStack<T> {
	private T stack[];
	private int size;
	private int top;
	
	public ArrayStack() {
		stack = (T[])new Object[50];
		top = -1;
	}
	
	public void clear() {
		stack = (T[]) new Object[50];
		size = 0;
		top = -1;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(T item){
		if (size == stack.length) {
			resizeArray();
		}
		top += 1;
		stack[top] = item;
		size += 1;
	}
	
	public void resizeArray() {
		T newArray[] = (T[])new Object[stack.length * 2 + 1];
		for (int i = 0; i < stack.length; i++) {
			newArray[i] = stack[i];
		}
		stack = newArray;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("TOP [");
		for (int i = top; i >= 0; i--) {
			sb.append(stack[i]);
			if(i != 0) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot remove from an empty Stack");
		}
		T removed = stack[top];
		stack[top] = null;
		top -= 1;
		size -= 1;
		return removed;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyCollectionException("Cannot peek in an empty stack");
		}
		return stack[top];
	}
}
