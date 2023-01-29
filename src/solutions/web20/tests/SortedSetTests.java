package solutions.web20.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import solutions.web20.SortedSet;

public abstract class SortedSetTests extends SetTests {
	@Test
	@Override
	void toArrayTest() {
		Arrays.sort(expected);
		super.toArrayTest();
	}
	@Test
	void firstTest() {
		assertEquals((Integer)(-5), ((SortedSet<Integer>)collection).first());
	}
	@Test
	void lastTest() {
		assertEquals((Integer)(40), ((SortedSet<Integer>)collection).last());
	}
	

}
