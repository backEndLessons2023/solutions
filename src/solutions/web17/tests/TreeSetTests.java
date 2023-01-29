package solutions.web17.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import solutions.web17.Collection;
import solutions.web17.TreeSet;

public class TreeSetTests extends SetTests {
    TreeSet<Integer> tree;
	@Override
	protected Collection<Integer> createCollection() {
		
		return new TreeSet<Integer>();
	}
	@Override
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		tree = (TreeSet<Integer>)collection;
	}
	@Test
	@Override
	void toArrayTest() {
		Arrays.sort(expected);
		super.toArrayTest();
	}
	@Test
	void firstTest() {
		assertEquals((Integer)(-5), tree.first());
	}
	@Test
	void lastTest() {
		assertEquals((Integer)(-5), tree.first());
	}

}
