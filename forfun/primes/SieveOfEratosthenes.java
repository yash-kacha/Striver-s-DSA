package forfun.primes;

import java.util.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();

        long startTime = System.nanoTime(); // start timer

        // System.out.println(findPrimeInRange(n).toString());
        findPrimeInRange(n);
        long endTime = System.nanoTime(); // end timer

        long durationInMs = (endTime - startTime) / 1_000_000; // convert to ms
        System.out.println("Runtime: " + durationInMs + " ms");
    }

    public static List<Integer> findPrimeInRange(int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] check = new boolean[n + 1];
        Arrays.fill(check, true);

        check[0] = false;
        if (n >= 1)
            check[1] = false;

        int limit = (int) Math.sqrt(n);

        for (int i = 2; i <= limit; i++) {
            if (check[i]) {
                for (int j = i * i; j <= n; j += i) {
                    check[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (check[i])
                ans.add(i);
        }

        return ans;
    }

}
