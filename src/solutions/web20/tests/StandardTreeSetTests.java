package solutions.web20.tests;

import solutions.web20.Collection;
import solutions.web20.StandardTreeSet;

public class StandardTreeSetTests extends SortedSetTests {

	@Override
	protected Collection<Integer> createCollection() {
		
		return new StandardTreeSet<Integer>();
	}
	

}
