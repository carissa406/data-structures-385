package ds.heap;

public class MinHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {
	@Override
	protected void reheapUp(int idx) {
		int parentIdx = idx / 2;
		T currentObj = heap.get(idx);
		while(idx > 1) {
			T parentObj = heap.get(parentIdx);
			int res = currentObj.compareTo(parentObj);
			if(res < 0) {
				swap(idx, parentIdx);
			} else {
				break;
			}
			idx = parentIdx;
			parentIdx = idx / 2;
		}
		
	}

	@Override
	protected void reheapDown(int idx) {
		int size = getSize();
		T currentObj = null;
		if(!isEmpty()) {
			currentObj = heap.get(idx);
		}
		while(idx <= size) {
			T leftChild = getLeftChild(idx);
			T rightChild = getRightChild(idx);
			int swapIdx = -1;
			//if has left and right child
			if(leftChild != null && rightChild != null) {
				int result = leftChild.compareTo(rightChild);
				if(result <= 0) {
					result = leftChild.compareTo(currentObj);
					if(result < 0) {
						swapIdx = idx * 2;
					}
				} else {
					result = rightChild.compareTo(currentObj);
					if(result < 0) {
						swapIdx = idx * 2 + 1;
					}
				}
			} else if(leftChild != null) {
				int result = leftChild.compareTo(currentObj);
				if(result < 0) {
					swapIdx = idx * 2;
				}
			}
			
			if(swapIdx != -1) {
				swap(idx, swapIdx);
				idx = swapIdx;
			} else {
				break;
			}
		}
		
	}

}
