package solutions.web30;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 10_000_000;
	private static final long N_RUNS = 10_000_000;

	public static void main(String[] args) {
		displayDigitStatistics();		
		displayDigitStatisticsFastest();
		displayDigitStatisticsSuperFastest();
	}
	
	private static void displayDigitStatistics() {
		long start = System.currentTimeMillis();
		
		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE)	
		.flatMap(x -> Integer.toString(x).chars())
		.parallel()
		.boxed()
		.collect(
			Collectors.groupingBy(
				Function.identity(), //x->x
				Collectors.counting()
			)
		)
		
		.entrySet().stream()
		.sorted(
			//(e1, e2) -> Long.compare(e2.getValue(), e1.getValue())
			Map.Entry.<Integer,Long>comparingByValue().reversed()
		)
		.forEach(x -> System.out.printf("%c -> %d\n", x.getKey(), x.getValue()));		

		System.out.println(System.currentTimeMillis() - start);	
	}	
	

	private static void displayDigitStatisticsFastest() {
		long start = System.currentTimeMillis();

		long[] digCounters = new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE)	
		.flatMap(x -> Integer.toString(x).chars())		
		.parallel()
		.collect(()->new long[10], 
				(arr,i)->arr[i-'0']++, 				
				(arr1, arr2) -> {
					for (int i=0; i <10; i++) {
						arr1[i]+=arr2[i];
					}
				});
		
		Map<Integer, Long> map = new HashMap<>(10);
		for (int i=0; i <10; i++) {
			map.put(i, digCounters[i]);
		}
		map.entrySet().stream()
		.sorted(
			Map.Entry.<Integer,Long>comparingByValue().reversed()
		)
		.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));			

		System.out.println(System.currentTimeMillis() - start);			
	}
	
	
	// By Maria Disin - sequential array instead of parallel stream
	private static void displayDigitStatisticsSuperFastest() { 
		long start = System.currentTimeMillis();

		long[] digitCounts = new long[10];		
		new Random().ints(N_RUNS, MIN_VALUE, MAX_VALUE)
				// .parallel() // ERROR!
				.forEach(num -> {
					while (num > 0) {
						int digit = num % 10;
						++digitCounts[digit];
						num /= 10;
					}
				});
		
		Map<Integer, Long> map = new HashMap<>(10);
		for (int i=0; i <10; i++) {
			map.put(i, digitCounts[i]);
		}
		map.entrySet().stream()
		.sorted(
			Map.Entry.<Integer,Long>comparingByValue().reversed()
		)
		.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));			

		System.out.println(System.currentTimeMillis() - start);			
	}

}
