package ds.priorityqueue;

import ds.heap.AbstractHeap;
import ds.heap.MaxHeap;
import ds.heap.MinHeap;

public class HeapPQ<T> {
	
	private AbstractHeap<PriorityNode> heap;
	
	public HeapPQ(PriorityType priorityType) {
		switch(priorityType) {
		case MIN:
			heap = new MinHeap<>();
			break;
		case MAX:
			heap = new MaxHeap<>();
		}
	}
	
	public void clear() {
		heap.clear();
	}
	
	public int getSize() {
		return heap.getSize();
	}
	
	public T remove() {
		return heap.remove().data;
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public void add(T item, int priority) {
		PriorityNode pNode = new PriorityNode(item, priority);
		heap.add(pNode);
	}
	
	public String toString() {
		return heap.toString();
	}
	
	private class PriorityNode implements Comparable<PriorityNode>{
		private T data;
		private int priority;
		
		public PriorityNode(T data, int priority) {
			this.data = data;
			this.priority = priority;
		}

		@Override
		public int compareTo(PriorityNode other) {
			// TODO Auto-generated method stub
			return this.priority - other.priority;
		}
		
		public String toString() {
			return String.format("(%s, priority=%d", data.toString(), priority);
		}
	}
}
