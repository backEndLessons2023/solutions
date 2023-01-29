package solutions.web15.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solutions.web15.Collection;
import solutions.web15.LinkedList;

public class LinkedListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {
		return new LinkedList<>();
	}	
	
	/**
	 * HW-15
	 */
	@Test
	void reverseTest() {
		LinkedList<Integer> linkedList = (LinkedList<Integer>) list;
		Integer [] expected = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		linkedList.reverse();
		assertArrayEquals(expected, linkedList.toArray(new Integer[0]));
	}

}
