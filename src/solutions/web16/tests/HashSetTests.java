package solutions.web16.tests;

import solutions.web16.Collection;
import solutions.web16.HashSet;

public class HashSetTests extends SetTests {

	@Override
	protected Collection<Integer> createCollection() {
		
		return new HashSet<>();
	}

}
