package forfun.primes;

import java.util.*;

public class trielDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();

        // Suggest garbage collection to free unused objects before starting
        System.gc();

        // Measure memory before
        Runtime runtime = Runtime.getRuntime();
        long beforeUsedMem = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.nanoTime(); // start timer

        findPrimeInRangeTD(n);

        long endTime = System.nanoTime(); // end timer

        // Measure memory after
        long afterUsedMem = runtime.totalMemory() - runtime.freeMemory();

        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0;

        System.out.printf("Runtime: %.3f ms (%d ns)%n", durationMs, durationNs);
        System.out.printf("Approx. Memory Used: %.2f MB%n", (afterUsedMem - beforeUsedMem) / (1024.0 * 1024.0));
    }

    public static List<Integer> findPrimeInRangeTD(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n >= 2)
            primes.add(2); // handle 2

        for (int i = 3; i <= n; i += 2) { // skip evens
            boolean isPrime = true;
            int limit = (int) Math.sqrt(i);
            for (int p : primes) {
                if (p > limit)
                    break;
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primes.add(i);
        }
        return primes;
    }
}
