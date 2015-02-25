import java.util.ArrayList;
import java.util.Collections;

public class Eratosthenes {

    private static ArrayList<Long> generatePrimes(final long max) {
        final ArrayList<Long> primes = new ArrayList<Long>();
        final ArrayList<Long> composites = new ArrayList<Long>();
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

    public static void main(final String[] args) {
        final ArrayList<Long> primes = Eratosthenes.generatePrimes(100000);
        for (final long i : primes) {
            System.out.println(i);
        }
    }
}