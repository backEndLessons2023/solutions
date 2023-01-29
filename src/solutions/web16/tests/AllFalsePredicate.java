package solutions.web16.tests;

import java.util.function.Predicate;

public class AllFalsePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		
		return false;
	}

}
