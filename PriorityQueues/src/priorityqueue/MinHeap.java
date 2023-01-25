package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;
	
	public MinHeap() {
		/* TODO: IMPLEMENT THIS METHOD */
		heap = new ArrayList<T> ();
		heap.add(null);
	}
	
	public MinHeap(ArrayList<T> data) {
		/* TODO: IMPLEMENT THIS METHOD */
		heap = data;
		heap.add(0, null);
		heapify();
	}
	
	private void heapify() {
		/* TODO: IMPLEMENT THIS METHOD */
		for (int i = 1; i < heap.size() - 1; i++) {
			percolateUp(i);
		}
	}
	
	private void percolateUp(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		if (index <= 1) {
			return;
		}
		
		long pindex = (long) index/2;
		
		if (heap.get((int) pindex).compareTo(heap.get(index)) >= 0) {
			swap(heap, index, (int) pindex);
			percolateUp((int) pindex);
		}
	}
		
	private static<T> void swap(ArrayList<T> list, int i, int j) {
		/*OPTIONAL TODO: IMPLEMENT THIS METHOD*/
		T temp = list.get(i);
	    list.set(i, list.get(j));
	    list.set(j, temp);
		
	}
	
	private void percolateDown(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		if (2 * index >= heap.size()) return;
		int cindex = (int) 2 * index;
		int cindex2 = (int) 2 * index + 1;
		if (cindex2 >= heap.size()) {
			if (heap.get(index).compareTo(heap.get(cindex)) < 0) return;
			swap(heap, cindex, index);
			percolateDown(cindex);
		}
		else if (heap.get(cindex).compareTo(heap.get(cindex2)) <= 0) {
			if (heap.get(index).compareTo(heap.get(cindex)) < 0) return;
			swap(heap, cindex, index);
			percolateDown(cindex);
		}
		else {
			if (heap.get(index).compareTo(heap.get(cindex2)) < 0) return;
			swap(heap, cindex2, index);
			percolateDown(cindex2);
		}
	}
	
	@Override
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
		heap.add(data);		
		percolateUp(heap.size() - 1);
		
	}

	@Override
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
		if (heap.size() - 1 == 0)
			return null;
		
		T poll = heap.get(1);
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size()-1);
		percolateDown(1);
		return poll;
	}

	@Override
	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
		if (heap.size() == 0)
			return null;
		T peek = (T) heap.get(1);
		return peek;
	}
	
	@Override
	public int size() {
		/* TODO: IMPLEMENT THIS METHOD */
		return heap.size();
	}
	
	
}