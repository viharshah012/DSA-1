package vector;


public class Vector<T> implements List<T> {
	
	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Vector(){
		this(INITIAL_CAPACITY);
	}
	
	public Vector(int capacity) {
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public int capacity() {
		//return this.data.length;
		return this.data.length;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(int newCapacity){
		//TODO: Implement this method
		T[] newArr = (T[])new Object[newCapacity];
		for (int i = 0; i < size-1; i++) {
			newArr[i] = this.data[i];
		}
		this.data = newArr;
	}

	@Override
	public int size() {
		return this.size;
		//TODO: Implement this method
	}

	@Override
	public void clear() {
		data = null;
		size = 0;
	}

	@Override
	public void insertAtTail(T data) {
		
		size++;
		if (capacity() == this.size) {
			resize(capacity() * 2);
		}
		this.data[this.size - 1] = data;
		
	}

	@Override
	public void insertAtHead(T data) {
		//TODO: Implement this method
		
		size++;
		if (capacity() == this.size) {
			resize(capacity() * 2);
		}
		for (int i = this.size-1; i > 0; i--) {
			this.data[i] = this.data[i-1];
		}
		this.data[0] = data;
		
		
	}

	@Override
	public void insertAt(int index, T data) {
		//TODO: Implement this method
		size++;
		for (int i = this.size-1; i > index; i--) {
			this.data[i] = this.data[i-1];
		}
		this.data[index] = data;
	}

	@Override
	public T removeAtTail() {
		//TODO: Implement this method
		
		this.size--;
		T removed = data[this.size];
		data[this.size] = null;
		return removed;
		
	}

	@Override
	public T removeAtHead() {
		//TODO: Implement this method
		
		for (int i = 0; i < size; i++) {
			this.data[i] = this.data[i+1];
		}
		T removed = this.data[0];
		this.size--;
		return removed;
		
	}

	@Override
	public int find(T data) {
		boolean exists = false;
		int existsAt = -1;
		for (int i = 0; i < size; i++) {
			if (this.data[i].equals(data)) {
				exists = true;
				existsAt = i;
				i = size;
			}
		}
		
		if (exists) {
			return existsAt;
		}
		else {
			return -1;
		}
		//TODO: Implement this method
	}

	@Override
	public T get(int index) {
		//TODO: Implement this method
		if (index >= 0 && index < this.size) {
			return this.data[index];
		}
		else {
			return null;
		}
	}

}
