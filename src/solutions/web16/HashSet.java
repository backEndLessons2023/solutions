package solutions.web16;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSet<T> implements Set<T> {
	private static final double DEFAULT_FACTOR = 0.75;
	private static final int DEFAULT_HASH_TABLE_CAPACITY = 16;
	private List<T>[] hashTable;
	private int size;
	private double loadFactor;

	@SuppressWarnings("unchecked")
	public HashSet(int hashTableCapacity, double loadFactor) {
		this.loadFactor = loadFactor;
		hashTable = new List[hashTableCapacity];
	}

	public HashSet(int hashTableCapacity) {
		this(hashTableCapacity, DEFAULT_FACTOR);
	}

	public HashSet() {
		this(DEFAULT_HASH_TABLE_CAPACITY, DEFAULT_FACTOR);
	}

	private class HashSetIterator implements Iterator<T> {
		private int tableIndex = -1;
		private Iterator<T> bucketIterator;
		T curElement; // for removal
		
		public HashSetIterator(){
			nextBucketIterator();
		}
		
		@Override
		public boolean hasNext() {
			return bucketIterator != null && bucketIterator.hasNext();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			curElement = bucketIterator.next();
			if (! bucketIterator.hasNext()) {
				nextBucketIterator();
			}
			return curElement;
		}

		private void nextBucketIterator() {
			while (++tableIndex < hashTable.length) {
				List<T> curBucket = hashTable[tableIndex];
				if (curBucket != null && curBucket.size() > 0) {
					bucketIterator = curBucket.iterator();
					return;
				}
			}
		}
		
		@Override
		public void remove() {
			if (curElement == null) {
				throw new IllegalStateException();
			}
			HashSet.this.remove(curElement);
			curElement=null;
		}
	}

	@Override
	public boolean add(T obj) {
		// set can not have two equal objects
		// that's why the method returns false at adding an object that already exists
		if (!contains(obj)) {
			if (size >= hashTable.length * loadFactor) {
				recreateHashTable();
			}
			int index = getHashTableIndex(obj);
			if (hashTable[index] == null) {
				hashTable[index] = new LinkedList<T>();
			}
			hashTable[index].add(obj);
			size++;
			return true;
		}
		return false;
	}

	private void recreateHashTable() {
		HashSet<T> tmp = new HashSet<>(hashTable.length * 2); // tmp hashset has table with twice capacity
		for (List<T> list : hashTable) {
			if (list != null) {
				for (T obj : list) {
					tmp.add(obj);
				}
			}
		}
		hashTable = tmp.hashTable;
	}

	private int getHashTableIndex(Object object) {
		return Math.abs(object.hashCode()) % hashTable.length;
	}

	@Override
	public boolean remove(Object pattern) {
		int index = getHashTableIndex(pattern);
		var bucket = hashTable[index];
		if (bucket != null &&  bucket.remove(pattern)) {
			if (bucket.size() == 0) {
				hashTable[index] = null;				
			}
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object pattern) {
		int index = getHashTableIndex(pattern);
		var bucket = hashTable[index];
		return (bucket != null &&  bucket.contains(pattern));
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new HashSetIterator();
	}

}