package solutions.web17.tests;

import solutions.web17.ArrayList;
import solutions.web17.Collection;

public class ArrayListTests extends ListTests {

	@Override
	protected Collection<Integer> createCollection() {		
		return new ArrayList<>();
	}

}
