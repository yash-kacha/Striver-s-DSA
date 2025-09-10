package step4binarysearch.lec1;

import java.util.*;

public class lowerUpper {

    public static void main(String[] args) {

        int[] in = getRandom(0, 10, 15);

        Arrays.sort(in);
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {

            System.out.print(i + ", ");
        }
        System.out.println(in.length - 1 + "]");

        System.out.println(Arrays.toString(in));
        System.out.println(lower(in, 35));
        System.out.println(upper(in, 35));

    }

    public static int[] getRandom(int b, int e, int size) {
        int[] ans = new int[size];
        Random rd = new Random(99);
        for (int i = 0; i < size; i++) {
            ans[i] = (rd.nextInt(b, e));
        }
        return ans;

    }

    public static int[] rotate(int[] in, int n) {
        int size = in.length;
        int[] ans = new int[size];
        int ogPointer = 0;
        for (int i = n; i < size; i++) {
            ans[i] = in[ogPointer++];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = in[ogPointer++];
        }
        return ans;
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
