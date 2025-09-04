package step4binarysearch.lec1;

import java.util.*;

public class basic {
    public static void main(String[] args) {
        int[] in = { 7, 3, 8, 5, 10, 4, 1, 6, 0, 1, 9, 2, 17, 20, 99, 34, 56, 18 };

        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
        System.out.println(find(in, 56));
        System.out.println(findRecure(in, 0, in.length - 1, 99));

    }

    public static int find(int[] in, int n) {

        int low = 0, high = in.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("high : " + high + " low : " + low);
            if (in[mid] == n)
                return mid;

            if (in[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    public static int findRecure(int[] in, int low, int high, int n) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (in[mid] == n)
            return mid;

        if (in[mid] > n) {
            return findRecure(in, low, mid - 1, n);
        } else {
            return findRecure(in, mid + 1, high, n);
        }

    }

}
