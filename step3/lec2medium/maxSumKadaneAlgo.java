package step3.lec2medium;

import java.util.Arrays;

public class maxSumKadaneAlgo {
    public static void main(String[] args) {
        int[] in = new int[] { -2, 8, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kadane(in));
        System.out.println(Arrays.toString(kadane1(in)));
    }

    public static int kadane(int[] x) {
        int sum = 0, max = x[0];
        for (int i = 0; i < x.length; i++) {
            sum += x[i];

            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static int[] kadane1(int[] x) {
        int sum = 0, max = 0, b = 0, e = 0, temp = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];

            if (sum >= max) {
                max = sum;
                e = i;
                b = temp;
            }

            if (sum < 0) {
                sum = 0;
                temp = i + 1;
            }
        }

        int[] ans = new int[e - b + 1];
        for (int i = b; i <= e; i++) {
            ans[i - b] = x[i];
        }
        return ans;
    }
}
