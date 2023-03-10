package solutions.web20.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public abstract class SetTests extends CollectionTests {

	@Test
	@Override
	void addTest() {
		assertTrue(collection.add(100)); // adding not existing number
		assertFalse(collection.add(10)); // adding existing number
		int size = collection.size();
		for (int i = 0; i < N_NUMBERS; i++) {
			collection.add(101 + i);
		}
		assertEquals(size + N_NUMBERS, collection.size());
	}

}
