package step3.lec3hard;

import java.util.*;

public class largestSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] in = new int[] { 2, -2, 0, 3, -3, 5 };

        System.out.println(getLagest(in));
    }

    public static int getLagest(int[] in) {
        Map<Integer, Integer> log = new HashMap<>();
        int n = in.length;
        int sum = 0;
        int ans = 0, b = -1, e = -1;
        for (int i = 0; i < n; i++) {
            sum += in[i];

            if (sum == 0) {
                ans = i + 1;
                b = -1;
                e = i;
            } else if (log.containsKey(sum)) {
                int tlen = (i - log.get(sum));
                if (tlen > ans) {
                    ans = tlen;
                    b = log.get(sum);
                    e = i;
                }

            } else {
                log.put(sum, i);
            }
        }

        for (int i = b + 1; i <= e; i++) {
            System.out.print(in[i] + " ");
        }
        System.out.println();
        return ans;
    }
}
