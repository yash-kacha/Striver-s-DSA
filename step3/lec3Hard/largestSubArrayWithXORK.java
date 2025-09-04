package step3.lec3hard;

import java.util.*;

public class largestSubArrayWithXORK {
    public static void main(String[] args) {

        int[] in = new int[] { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println(brut(k, in));
    }

    public static int brut(int k, int[] in) {
        int ans = 0;
        for (int i = 0; i < in.length; i++) {
            int xor = in[i];
            for (int j = i + 1; j < in.length; j++) {
                if (xor == k)
                    ans++;
                xor ^= in[j];

            }
            if (xor == k)
                ans++;
        }
        return ans;
    }

    public static int optimal(int k, int[] in) {
        Map<Integer, Integer> freq = new HashMap<>();

        int xor = 0, ans = 0;
        freq.put(0, 1);

        for (int i = 0; i < in.length; i++) {
            xor ^= in[i];

            ans += freq.getOrDefault(xor ^ k, 0);
            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }
        return ans;

    }

}
