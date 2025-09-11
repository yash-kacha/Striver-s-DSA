package step4binarysearch.lec2;

import java.util.*;

public class smalledDivison {
    public static void main(String[] args) {

        int[] in = { 8, 4, 2, 3 };
        int limit = 10;

        System.out.println(minDivisor(in, limit));

    }

    public static int minDivisor(int[] in, int limit) {
        int low = 1, high = Arrays.stream(in).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findLimit(in, mid, limit)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public static boolean findLimit(int[] in, int div, int limit) {
        int ans = 0;
        for (int i : in) {
            ans += (i + div - 1) / div;
            if (ans > limit)
                return false;
        }
        return true;
    }
}
