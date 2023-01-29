package solutions.web16.tests;

import solutions.web16.ArrayList;
import solutions.web16.Collection;

public class ArrayListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {
		
		return new ArrayList<>();
	}
	

}
