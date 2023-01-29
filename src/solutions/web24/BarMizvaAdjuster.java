package solutions.web24;

import java.time.temporal.*;

public class BarMizvaAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		Temporal res = temporal.plus(13, ChronoUnit.YEARS);
		return res;
	}

}
