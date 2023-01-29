package solutions.web17.tests;

import java.util.function.Predicate;

public class AllFalsePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return false;
	}

}
