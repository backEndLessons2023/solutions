package solutions.web17.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solutions.web17.Collection;
import solutions.web17.LinkedList;

public class LinkedListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {
		return new LinkedList<>();
	}	
	
	@Test
	void reverseTest() {
		LinkedList<Integer> linkedList = (LinkedList<Integer>) list;
		Integer [] expected1 = {15, 40, 20, 13, -5, 10};
		linkedList.reverse();
		assertArrayEquals(expected1, linkedList.toArray(new Integer[0]));
		Integer expected2[] = {100, 10, -5, 13, 20, 40, 15};
		linkedList.add(100);
		linkedList.reverse();
		assertArrayEquals(expected2, linkedList.toArray(new Integer[0]));
	}

}
