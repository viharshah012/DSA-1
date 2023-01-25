package queue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{
	
	LinkedList<T> linkedQueue = new LinkedList<T>();
	private T head;
	private T tail;
	private int size;
	private Lock indexlock;
	private Condition sufConditions;
	
	/**
	 * Constructor: Initialize the inner list
	 */
	public ConcurrentQueue(){
		//TODO: Write this method	
		indexlock = new ReentrantLock();
		sufConditions = indexlock.newCondition();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		//TODO: Write this method
		return this.size;
	}
	

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		//TODO: Write this method
		indexlock.lock();
		try {
			linkedQueue.add(data);
			sufConditions.signalAll();
		}
		finally {
			indexlock.unlock();
		}
		this.size++;
		
	}
	
	/**
	 * Simply remove data from the head of the list
	 */
	public T dequeue(){	
		//TODO: Write this method
		T rem;
		indexlock.lock();
		try {
			while (linkedQueue.size() == 0) {
				try {
					sufConditions.await();
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			rem = linkedQueue.remove(0);
		}
		finally {
			indexlock.unlock();
		}
		this.size--;
		return rem;
	}
	
	
}
