package hash;


/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	
	private int capacity;
	private int load;
	
	public HashTable() {
		this(60000);
	}
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
		this.capacity = initialCapacity;
		table = (HashNode<K,V>[]) new HashNode [capacity];
		load = 0;		
	}
	
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
		int i = Math.abs(key.hashCode() % capacity);
		HashNode<K,V> input = new HashNode<K,V>(key, value);
		
		while (table[i] != null) {
			if (table[i].equals(input)) {
				break;
			}
			i++;
			load++;
			if (i == capacity) {
				i = 0;
			}
		}
		table[i] = input;
		
	}

	@Override
	public V retrieve(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		
		int i = Math.abs(key.hashCode() % capacity);
		
		while (table[i] != null) {
			if (table[i].getKey().equals(key)) {
				return table[i].getValue();
			}
			i++;
			if (i == capacity) {
				i = 0;
			}
		}
		
		return null;
	}

	@Override
	public boolean contains(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		int i = Math.abs(key.hashCode() % capacity);
		
		while (table[i] != null) {
			if (table[i].getKey().equals(key)) {
				return true;
			}
			i++;
			if (i == capacity) {
				i = 0;
			}
		}
		return false;
		
	}

	@Override
	public void remove(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		int i = Math.abs(key.hashCode() % capacity);
		
		while (table[i] != null) {
			if (table[i].getKey().equals(key)) {
				table[i] = null;
				break;
			}
			i++;
			if (i == capacity) {
				i = 0;
			}
		}
		
		i++;
		if (i == capacity) {
			i = 0;
		}
		
		while (table[i] != null) {
			HashNode<K,V> input = new HashNode<K,V>(table[i].getKey(), table[i].getValue());
			table[i] = null;

			insert(input.getKey(), input.getValue());
			i++;
			if (i == capacity) {
				i = 0;
			}
		}
		
	}
	
	public int getCollisions() {
		return load;
		
	}
	
	
}
