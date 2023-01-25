package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */
		this.head = new ListNode<T>(null);
		this.tail = new ListNode<T>(null);
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		this.size = 0;
		
	}
	
	public int size() {
		/* TODO: Implement this method */  
		return this.size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */ 
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		this.size = 0;
		
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		
		this.size++;
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		
		this.size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = head;
		
		for (int i = 0; i < index; i++) {
			newNode.prev = newNode.prev.next;
		}
		newNode.next = newNode.prev.next;
		newNode.prev.next.prev = newNode;
		newNode.prev.next = newNode;
		
		this.size++;
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */  
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = it.curNode;
		newNode.next = it.curNode.next;
		it.curNode.next.prev = newNode;
		it.curNode.next = newNode;
		
		this.size++;
	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */  
		T removed = tail.prev.getData();
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		this.size--;
		return removed;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */  
		T removed = head.next.getData();
		head.next = head.next.next;
		head.next.prev = head;
		this.size--;
		return removed;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */  
		it.moveForward();
		it.curNode.prev.prev.next = it.curNode;
		it.curNode.prev = it.curNode.prev.prev;
		this.size--;
		
		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		/* TODO: Implement this method */  
		ListIterator<T> it = new ListIterator<T>(head.next);
		
		for (int i = 0; i < this.size; i++) {
			if (it.value().equals(data))
				return i;
			it.moveForward();
		}
		
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */  
		ListIterator<T> it = new ListIterator<T>(head.next);
		for (int i = 0; i < index; i++) {
			it.moveForward();
		}
		return it.value();
		
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */  
		ListIterator<T> it = new ListIterator<T>(head.next);
		return it;
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */ 
//		ListIterator<T> it = 
		return new ListIterator<T>(tail.prev);
	}
	
	
}
