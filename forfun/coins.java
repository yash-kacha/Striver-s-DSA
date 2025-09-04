package forfun;

import java.util.*;

public class coins {
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 10));
        int sum = 12;

        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println("min coins : " + minimumCoins(sum, coins, memo));

    }

    public static int minimumCoins(int sum, List<Integer> coins, Map<Integer, Integer> memo) {
        if (sum == 0)
            return 0;

        if (memo.containsKey(sum))
            return memo.get(sum);

        int ans = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            if (sum - coin >= 0) {
                int subResult = minimumCoins(sum - coin, coins, memo);
                if (subResult != Integer.MAX_VALUE) {
                    ans = Math.min(ans, subResult + 1);
                }
            }
        }
        memo.put(sum, ans);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
