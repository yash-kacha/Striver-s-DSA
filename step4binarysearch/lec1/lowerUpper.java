package step4binarysearch.lec1;

import java.util.Arrays;

public class lowerUpper {

    public static void main(String[] args) {
        int[] in = { 7, 3, 8, 5, 10, 4, 1, 6, 0, 1, 9, 2, 17, 20, 99, 34, 56, 18 };

        Arrays.sort(in);
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {

            System.out.print(i + ", ");
        }
        System.out.println(in[in.length - 1] + "]");

        System.out.println(Arrays.toString(in));
        System.out.println(lower(in, 35));
        System.out.println(upper(in, 11));

    }

    public static int lower(int[] in, int n) {
        int low = 0, high = in.length - 1, ans = high + 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (in[mid] >= n) {
                ans = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upper(int[] in, int n) {
        int low = 0, high = in.length - 1, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (in[mid] > n) {
                ans = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return ans;
    }

}
