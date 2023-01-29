package solutions.web20;

public interface SortedSet<T> extends Set<T> {
	/**
	 * 
	 * @return reference to the least object
	 */
	T first();

	/**
	 * 
	 * @return reference to the most object
	 */
	T last();
}
