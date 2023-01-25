package test;

import java.util.ArrayList;
import java.util.HashMap;

import priorityqueue.HeapSort;
import priorityqueue.MinHeap;
import java.util.LinkedList;
public class PriorityQueueTester2 {
	

	public static <T extends Comparable<T>> boolean checkSorted(LinkedList<T> data) {
		for(int i=1; i<data.size(); i++) {
			if(data.get(i-1).compareTo(data.get(i)) > 0) return false;
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean checkSameElements(LinkedList<T> l1, LinkedList<T> l2) {
		if(l1.size() != l2.size()) return false;
		
		HashMap<T, Integer> count = new HashMap<T, Integer>();
		for(T key : l1) {
			if(!count.containsKey(key)) count.put(key, 1);
			else count.put(key, count.get(key)+1);
		}
		for(T key: l2) {
			if(!count.containsKey(key)) return false;
			else count.put(key, count.get(key)-1);
		}
		for(T key : count.keySet()) {
			if(count.get(key) != 0) return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int NUM_TESTS = 50000;
		
		//TEST 1: TESTING PUSH AND POLL
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		System.out.print("Adding new elements to a list...");
		
		for(int i=0; i<NUM_TESTS; i++) {
			Integer r = (int)(Math.random()*NUM_TESTS);
			list.add(r);
		}
		
		System.out.println("DONE");
		
		LinkedList<Integer> list2 = (LinkedList<Integer>)list.clone();
		int t1 = (int) System.currentTimeMillis();
		int pushTime = 0;
		int peakTime = 0;
		
		System.out.print("Pushing elements to a heap...");
		MinHeap<Integer> mh = new MinHeap<Integer>();
		
		for(int i=0; i<NUM_TESTS; i++) {
			mh.push(list.get(i));
			pushTime += (int) System.currentTimeMillis() - t1;
			t1 = (int) System.currentTimeMillis();
			list.peek();
			peakTime += (int) System.currentTimeMillis() - t1;
		}
		System.out.println("DONE");
		
		System.out.println("Finished pushing in: "+pushTime+" ms");
		System.out.println("Finished peaking in: "+peakTime+" ms");
		System.out.print("Removing elements...");
		
		int pollTime = 0;
		
		for(int i=0; i<NUM_TESTS; i++) {
			t1 = (int) System.currentTimeMillis();
			list.set(i, mh.poll());
			pollTime += (int) System.currentTimeMillis() - t1;
			
		}
		
		
		System.out.println("DONE");
		System.out.println("Finished polling in: "+pollTime+" ms");
		
		
		System.out.print("Checking if removal seemed to work...");
		if(list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
			System.out.println("LOOKS GOOD");
		}
		else {
			System.out.println("ERROR...Something went wrong");
			if(list.size() == NUM_TESTS) System.out.println("size is fine");
			if(checkSorted(list)) System.out.println("sorted is fine");
			if(checkSameElements(list, list2)) System.out.println("Same elements in there");
		}
		
		
		//TEST 2: TESTING HEAPIFY
//		list = new LinkedList<Integer>();
//		System.out.print("Adding new elements to a list...");
//		for(int i=0; i<NUM_TESTS; i++) {
//			Integer r = (int)(Math.random()*NUM_TESTS);
//			list.add(r);
//		}
//		System.out.println("DONE");
//		
//		list2 = (LinkedList<Integer>)list.clone();
//		
//		System.out.print("Creating heap from list...");
//		mh = new FakeMinHeap<Integer>((LinkedList<Integer>)list.clone());
//		System.out.println("DONE");
//		
//		System.out.print("Removing elements...");
//		for(int i=0; i<NUM_TESTS; i++) {
//			list.set(i, mh.poll());
//		}
//		System.out.println("DONE");
//		
//		System.out.print("Checking if removal seemed to work...");
//		if(list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
//			System.out.println("LOOKS GOOD");
//		}
//		else
//			System.out.println("ERROR...Something went wrong");
//				
//		list = new LinkedList<Integer>();
//		
//		System.out.print("Adding elements to list...");
//		for(int i=0; i<NUM_TESTS; i++) {
//			Integer r = (int)(Math.random()*NUM_TESTS);
//			list.add(r);
//		}
//		System.out.println("DONE");
//		
//		list2 = (LinkedList<Integer>)list.clone();
//		
//		System.out.print("Calling heapSort...");
//		Integer[] toSort = new Integer[list.size()];
//		for(int i=0; i<list.size(); i++) toSort[i] = list.get(i);
//			
//		HeapSort.heapSort(toSort);
//		
//		list.clear();
//		for(Integer i : toSort) list.add(i);
//		System.out.println("DONE");
		
		
		
//		System.out.print("Checking if same elements came out sorted...");
//		if(list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
//			System.out.println("LOOKS GOOD");
//		}
//		else
//			System.out.println("ERROR...Something went wrong");
		
		
		
	}
}
