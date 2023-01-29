package solutions.web20.tests;

import solutions.web20.ArrayList;
import solutions.web20.Collection;

public class ArrayListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {
		
		return new ArrayList<>();
	}
	

}
