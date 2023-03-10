package solutions.web17;


import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T> {
	
	/**
	 * adds object of type T in collection
	 * @param obj
	 * @return true if added
	 */
	boolean add(T obj);
	
	/***************************************/
	/** 
	 * removes object equaled to the given pattern 
	 * @param pattern any object
	 * @return true if removed 
	 */
	boolean remove(Object pattern);
	
	/******************************************/
	/**
	 * removes all objects matching the given predicate
	 * @param predicate
	 * @return true if a collection has been updated
	 */
	default boolean removeIf(Predicate<T> predicate) {
		int sizeOld = size();
		Iterator<T> it = iterator();
		while(it.hasNext()) {
			T obj = it.next();
			if(predicate.test(obj)) {
				it.remove();
			}
		}
		return sizeOld > size();		
	}
	
	/*************************************************/
	/**
	 * 
	 * @param pattern
	 * @return true if there is an object equaled to the given pattern
	 */
	boolean contains(Object pattern);
	
	/********************************************************/
	/**
	 * 
	 * @return amount of the objects
	 */
	int size();
	
	/******************************************************/
	/**
	 * 
	 * @param ar
	 * @return regular Java array containing all the collection object
	 */
	default T[] toArray(T[] ar) {
		int i = 0;
		Iterator<T> it = iterator();
		if(ar.length < size()) {
			ar = Arrays.copyOf(ar, size());
		}
		while(it.hasNext()) {
			ar[i++] = it.next();
		}
		return ar;
	}
}