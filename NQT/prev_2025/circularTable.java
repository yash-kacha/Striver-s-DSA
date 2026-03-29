package NQT.prev_2025;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class circularTable {

    public static void main(String[] args) {
        int N = 4;
        int M = 2;

        System.out.println(solve(N, M));
    }

    private static BigDecimal solve(int n, int m) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(0, BigDecimal.ONE);
        return fact((n - m + 1), map).multiply(fact(m, map));
    }

    private static BigDecimal fact(int i, Map<Integer, BigDecimal> map) {
        if (map.containsKey(i)) {
            return map.get(i);
        }

        BigDecimal ans = fact(i - 1, map).multiply(BigDecimal.valueOf(i));
        map.put(i, ans);
        return map.get(i);
    }

}
