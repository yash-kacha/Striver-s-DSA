package step3.lec2medium;

import java.util.Arrays;

public class bestSellShare {
    public static void main(String[] args) {
        int[] in = new int[] { 99, 7, 1, 5, 3, 6, 4, 99 };
        System.out.println(stock(in));
        System.out.println(Arrays.toString(stock1(in)));
    }

    public static int stock(int[] x) {

        int max = 0, min = x[0];
        for (int i = 0; i < x.length; i++) {
            min = Math.min(x[i], min);
            max = Math.max(max, x[i] - min);

        }
        return max;
    }

    public static int[] stock1(int[] x) {
        int[] ans = new int[2];
        int max = 0, min = x[0], temp = x[0];
        for (int i = 0; i < x.length; i++) {

            if (x[i] < min) {
                min = Math.min(x[i], min);

            }

            if (x[i] - min > max) {
                max = x[i] - min;
                ans[0] = min;
                ans[1] = x[i];
            }

        }
        return ans;

    }
}
