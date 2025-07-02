package step3.lec1easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestSumPN {
    public static void main(String[] args) {
        // int[] in = new int[] { 1, 1, 1, 0, 0, -1, -1, 1, 1, 0, 0, 2, 2, 3, 4, 5, 5, 8
        // };
        int[] in = new int[] { 10, -10, 10, -10, 10 };
        /*
         * 1 1 2 2 3 4 5 5 8
         * 0 1 2 4 6 9 13 18 23 31
         */
        System.out.println(Arrays.toString(longer1(in, 0)));
        System.out.println(longer(in, 0));
        // System.out.println(longest(in, 5));
        // test();

    }

    public static void test() {
        int passed = 0;

        Object[][] testCases = new Object[][] {
                { new int[] { 1, 2, 3, 4, 5 }, 9, 3 }, // [2,3,4]
                { new int[] { 1, -1, 5, -2, 3 }, 3, 4 }, // [1,-1,5,-2]
                { new int[] { -2, -1, 2, 1 }, 1, 2 }, // [2,-1]
                { new int[] { 1, 2, 3 }, 6, 3 }, // full array
                { new int[] { 1, 1, 1, 1, 1 }, 2, 2 }, // multiple small windows
                { new int[] { 5, 1, -1, 5 }, 10, 4 }, // entire array
                { new int[] { -1, -1, -1, -1 }, -2, 2 }, // all negative
                { new int[] { 0, 0, 0, 0 }, 0, 4 }, // all zero
                { new int[] { 3, -1, 4, -2, 2 }, 6, 5 }, // entire array
                { new int[] { 1, 2, 1, 2, 1 }, 3, 2 }, // multiple valid subarrays
                { new int[] { 1, 2, 3, -3, 2 }, 5, 5 }, // entire array
                { new int[] { 2, -1, 2, -1, 2, -1, 2 }, 2, 4 }, // partial
                { new int[] { 100, -50, 50, 0 }, 100, 4 }, // full array
                { new int[] { 1 }, 1, 1 }, // single element match
                { new int[] { 1 }, 0, 0 }, // single element no match
                { new int[] { 2, 2, -1, 1, 3 }, 5, 4 }, // [2, -1, 1, 3]
                { new int[] { 1, -1, 1, -1, 1 }, 0, 4 }, // [1, -1, 1, -1]
                { new int[] { -5, 5, -5, 5 }, 0, 4 }, // alternating
                { new int[] { 10, -10, 10, -10, 10 }, 0, 4 }, // [10, -10, 10, -10]
                { new int[] { 1, 2, 3, 4, 5 }, 15, 5 }, // full sum
                { new int[] { 3, 3, 3, 3 }, 6, 2 }, // repeated values
                { new int[] { 3, 1, 4, 1, 5 }, 9, 4 }, // [1,4,1,3]
                { new int[] { 0, 1, 2, 3, 0, 4, 0 }, 6, 5 }, // includes 0s
                { new int[] { 1, -2, 3, 4, -5, 6 }, 6, 5 }, // [3,4,-5,6]
                { new int[] { 7, -5, 2, -1, 2 }, 5, 5 } // full array
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = (int[]) testCases[i][0];
            int k = (int) testCases[i][1];
            int expected = (int) testCases[i][2];

            int result = longer(arr, k);

            if (result == expected) {
                System.out.println("Test case " + (i + 1) + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test case " + (i + 1) + " failed.");
                System.out.println("  Input: " + Arrays.toString(arr) + ", k=" + k);
                System.out.println("  Expected: " + expected + ", Got: " + result);
            }
        }
    }

    public static int longer(int[] y, int k) {
        Map<Integer, Integer> op = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < y.length; i++) {
            sum += y[i];
            if (sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k;

            if (op.containsKey(rem)) {
                int len = i - op.get(rem);
                maxLen = Math.max(len, maxLen);
            }
            op.putIfAbsent(sum, i);
            // if (!op.containsKey(sum)) {
            // op.put(sum, i);
            // }
        }
        return maxLen;
    }

    public static int[] longer1(int[] y, int k) {
        Map<Integer, Integer> op = new HashMap<>();
        int sum = 0, b = 0, e = 0;
        int maxLen = 0;
        for (int i = 0; i < y.length; i++) {
            sum += y[i];
            if (sum == k) {
                maxLen = i + 1;
                b = 0;
                e = i;
            }

            int rem = sum - k;

            if (op.containsKey(rem)) {
                int len = i - op.get(rem);
                if (len > maxLen) {
                    maxLen = len;
                    b = op.get(rem) + 1;
                    e = i;
                }
                maxLen = Math.max(len, maxLen);

            }
            op.putIfAbsent(sum, i);
            // if (!op.containsKey(sum)) {
            // op.put(sum, i);
            // }
        }
        int[] ans = new int[e - b + 1];

        System.out.println("maxlen : " + maxLen);
        for (int ii = b; ii <= e; ii++) {
            ans[ii - b] = y[ii];
        }
        return ans;
    }

    // public static int longest(int[] x, int k) {
    // int sum = x[0];
    // int left = 0, right = 0;
    // int maxLen = 0;
    // int n = x.length;

    // while (left < n && right < n) {
    // while (sum > k) {
    // sum -= x[left++];
    // }
    // if (sum == k) {
    // maxLen = Math.max(right - left + 1, maxLen);
    // }

    // right++;
    // if (right < n) {
    // sum += x[right];
    // }
    // }
    // return maxLen;
    // }
}
