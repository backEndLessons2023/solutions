package solutions.web32;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Solution example
 * @author Daniel Zinchin
 */
class OneSwapForSorted {

	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: {1, 2, 3, 10, -1, 5, 6} -> false
	 * {1, 2, 3, 5, 6, 10} -> false
	 * {1,3,2,4, 3, 10} -> false
	 * {10, 2, 3, 4, 1} -> true
	 * {1, 2, 4, 3, 5, 10} -> true
	 * {1, 5, 3, 4, 2, 10} -> true
	 * {"lmn", "ab", "bc", "cd", "a"} -> true
	 * An Array should contain Comparable elements
	 */
	<T extends Comparable<T>> boolean isOneSwapForSorted(T [] array) {
		if (array.length < 2) {
			return false;
		}
		
		// find 1st swap candidate
		int firstSwapFromIndex = -1;
		for (int i = 0; i < array.length - 1; i++) {
			if(array[i].compareTo(array[i+1]) > 0) {
				firstSwapFromIndex = i;
				break;
			}
		}
		if (firstSwapFromIndex < 0) {
			return false;
		}
		
		// find rightmost swap "partner" of found 1st swap candidate (always exists)
		int firstSwapToIndex = array.length - 1;
		while (array[firstSwapFromIndex].compareTo(array[firstSwapToIndex]) < 0) {
			firstSwapToIndex--;
		}
		
		// look for 2nd swap candidate, taking in consideration "virtual" result of 1st swap
		for (int i = 0; i < array.length - 1; i++) {
			int indFrom = translate(i, firstSwapFromIndex, firstSwapToIndex); 
			int indTo = translate(i+1, firstSwapFromIndex, firstSwapToIndex); 
			if(array[indFrom].compareTo(array[indTo]) > 0) {
				return false;
			}
		}
		
		// 2nd swap is not required
		return true;
	}
	
	/**
	 * Translates array index, taking in consideration  "virtual" result of 1st swap
	 */
	private static int translate(int i, int firstSwapFromIndex,int firstSwapToIndex ) {
		return (i == firstSwapFromIndex) ? firstSwapToIndex 
										 : (i == firstSwapToIndex) ? firstSwapFromIndex : i;
	}
	
	@Test
	void isOneSwapTest() {
		Integer ar21[] = {1, 3, 20, 4, 5, 11, 2};
		Integer ar31[] = {1, 3, 20, 4, 5, 6, 10};
		Integer ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		Integer ar2[] = { 1, 2, 3, 4, 5, 10 };
		Integer ar20[] = { 5, 1, 2, 4, 6, 10 };
		Integer ar3[] = { 1, 5, 2, 4, 3, 10 };
		Integer ar4[] = { 1, 3, 2, 5, 4, 10, 8 };
		Integer ar5[] = { 10, 2, 3, 4, 1 };
		Integer ar6[] = { 1, 2, 4, 3, 5, 10 };
		Integer ar7[] = { 1, 2, 3, 10, 5, 4 };
		Integer ar8[] = { 1, 5, 3, 4, 2, 10 };
		Integer ar9[] = { 1, 2, 3, 4, 10, 5 };
		Integer ar10[] = { 2, 1, -3, 4, 5, 10 };
		Integer ar100[] = { 1, 2, 4, 3, 5, 10 };
		Integer ar11[] = { 1, 2, 3, 10, 5, 4 };
		Integer ar12[] = { 3, 2, 1, 4, 5, 6 };
		String ar13[] = { "lmn", "ab", "bc", "cd", "a" };

		assertFalse(isOneSwapForSorted(ar1));
		assertFalse(isOneSwapForSorted(ar21));
		assertFalse(isOneSwapForSorted(ar31));
		assertFalse(isOneSwapForSorted(ar2));
		assertFalse(isOneSwapForSorted(ar20));
		assertFalse(isOneSwapForSorted(ar3));
		assertFalse(isOneSwapForSorted(ar4));
		assertTrue(isOneSwapForSorted(ar5));
		assertTrue(isOneSwapForSorted(ar6));
		assertTrue(isOneSwapForSorted(ar7));
		assertTrue(isOneSwapForSorted(ar8));
		assertTrue(isOneSwapForSorted(ar9));
		assertTrue(isOneSwapForSorted(ar10));
		assertTrue(isOneSwapForSorted(ar100));
		assertTrue(isOneSwapForSorted(ar11));
		assertTrue(isOneSwapForSorted(ar12));
		assertTrue(isOneSwapForSorted(ar13));
	}

}
