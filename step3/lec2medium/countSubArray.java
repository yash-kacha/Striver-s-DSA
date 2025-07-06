package step3.lec2medium;

import java.util.*;

public class countSubArray {
    public static void main(String[] args) {

        int[] x = { 3, 1, 2, 4 };
        System.out.println(countSum(x, 6));

    }

    public static int countSum(int[] x, int sum) {
        Map<Integer, Integer> ans = new HashMap<>();

        ans.put(0, 1);
        int pre = 0, cnt = 0;
        for (int i = 0; i < x.length; i++) {
            pre += x[i];

            cnt += ans.getOrDefault((pre - sum), 0);

            ans.put(pre, ans.getOrDefault(pre, 0) + 1);

        }
        return cnt;
    }

}
