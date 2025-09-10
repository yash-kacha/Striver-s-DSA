package step4binarysearch.lec1;

import java.util.Arrays;
import static step4binarysearch.lec1.lowerUpper.getRandom;

public class firstAndLastOccurance {
    public static void main(String[] args) {

        int[] in = getRandom(0, 10, 15);

        Arrays.sort(in);
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {

            System.out.print(i + ", ");
        }
        System.out.println(in.length - 1 + "]");

        System.out.println(Arrays.toString(in));
        int n = 9;
        System.out.println("first occurance of " + n + " at : " + first(in, n));
        System.out.println("last occurance of " + n + " at : " + last(in, n));
        System.out.println("number of occurance of " + n + " : " + (last(in, n) - first(in, n) + 1));

        // System.out.println(last(in, 35));
    }

    public static int first(int[] in, int n) {
        int low = 0;
        int high = in.length - 1, mid;

        while (low <= high) {
            mid = (low + (high - low) / 2);

            if (in[mid] >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        if (low == in.length)
            return -1;
        return in[low] == n ? low : -1;
    }

    public static int last(int[] in, int n) {
        int low = 0;
        int high = in.length - 1, mid;

        while (low <= high) {
            mid = (low + (high - low) / 2);

            if (in[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        if (high == in.length)
            return -1;
        return in[high] == n ? high : -1;
    }
}
