package solutions.web20.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solutions.web20.Collection;
import solutions.web20.LinkedList;

public class LinkedListTest extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {
		
		return new LinkedList<>();
	}
	@Test
	void reverseTest() {
		LinkedList<Integer> linkedList = (LinkedList<Integer>) collection;
		//{ 10, -5, 13, 20, 40, 15 }; - initial order 1
		//{ 15, 40, 20, 13, -5, 10, 100 }; - initial order 2 
		Integer expected1[] = {15, 40, 20, 13, -5, 10};
		Integer expected2[] = { 100, 10, -5, 13, 20, 40, 15 };
		linkedList.reverse();
		assertArrayEquals(expected1, linkedList.toArray(new Integer[0]));
		linkedList.add(100);
		linkedList.reverse();
		assertArrayEquals(expected2, linkedList.toArray(new Integer[0]));
	}

}
