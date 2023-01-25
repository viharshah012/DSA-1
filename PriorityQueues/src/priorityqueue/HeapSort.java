package priorityqueue;

import java.util.ArrayList;

public class HeapSort {
	
	/*
	 * Accepts a list of type T and updates that list to be in sorted order.
	 * */
	public static <T extends Comparable<T>> void heapSort(T[] list) {
		/* TODO: IMPLEMENT THIS METHOD */ 
		
		MinHeap<T> sort = new MinHeap<T>();
		ArrayList<T> sort2 = new ArrayList<T>();
		
		//minheap test
		long pt1 = System.currentTimeMillis();
		for (int i = 0; i < list.length; i++) {
			sort.push(list[i]);
		}
		long pt2 = System.currentTimeMillis();
		System.out.println("MinHeap Push Runtime: " + (pt2 - pt1));
	  	
		long pt3 = System.currentTimeMillis();
		for (int i = 0; i < list.length; i++) {
			list[i] = sort.poll();
		}
		long pt4 = System.currentTimeMillis();
		System.out.println("MinHeap Poll Runtime: " + (pt4 - pt3));
		
		long pt5 = System.currentTimeMillis();
		for (int i = 0; i < list.length; i ++) {
			list[i] = sort.peek();
		}
		long pt6 = System.currentTimeMillis();
		System.out.println("MinHeap Peek Runtime: " + (pt6 - pt5));
		
		//arraylist test
//		for (int i = 0; i < list.length; i++) {
//			sort.push(list[i]);
//		}
//	  	
//		
//		for (int i = 0; i < list.length; i++) {
//			list[i] = sort.poll();
//		}
//		
//		for (int i = 0; i < list.length; i ++) {
//			list[i] = sort.peek();
//		}
	}

}
