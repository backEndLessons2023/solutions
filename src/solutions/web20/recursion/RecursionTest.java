package solutions.web20.recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

;class RecursionTest {
int count = 0;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void factorialTest() {
		assertEquals(24, LineRecursion.factorial(4));
	}
	@Test
	void powTest() {
		assertEquals(1000, LineRecursion.pow(10, 3));
		assertEquals(-1000, LineRecursion.pow(-10, 3));
		assertEquals(100,LineRecursion.pow(-10, 2));
	}
	@Test
	void sumTest() {
		int ar[] = {1, 2, 3, 4};
		assertEquals(10, LineRecursion.sum(ar));
	}
	@Test
	void squareTest() {
		assertEquals(100, LineRecursion.square(10));
		assertEquals(100, LineRecursion.square(-10));
	}
	
//	private void f() {
//		
//		if(Math.random() < 0.99) {
//			f();
//			count++;
//		}
//		
//		
//	}

}

