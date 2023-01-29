package solutions.web15.tests;

import solutions.web15.ArrayList;
import solutions.web15.Collection;

public class ArrayListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {		
		return new ArrayList<>();
	}

}
