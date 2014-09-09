import java.util.ArrayList;
import java.util.Collections;

public class Eratosthenes {

	public static void main(String[] args) {
		ArrayList<Long> primes = generatePrimes(100000);
		for (long i : primes) {
			System.out.println(i);
		}
	}

	private static ArrayList<Long> generatePrimes(long max) {
		ArrayList<Long> primes = new ArrayList<Long>();
		ArrayList<Long> composites = new ArrayList<Long>();
		for (long i = 2; i * i <= max; i++) {
			if (!composites.contains(i)) {
				for (long j = i; i * j <= max; j++) {
					composites.add(i * j);
				}
			}
		}
		for (long i = 2; i <= max; i++) {
			if (!composites.contains(i)) {
				primes.add(i);
			}
		}
		Collections.sort(primes);
		return primes;
	}
}