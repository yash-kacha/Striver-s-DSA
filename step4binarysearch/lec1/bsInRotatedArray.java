package step4binarysearch.lec1;

import java.util.Arrays;
import static step4binarysearch.lec1.lowerUpper.getRandom;
import static step4binarysearch.lec1.lowerUpper.rotate;

public class bsInRotatedArray {
    public static void main(String[] args) {
        int[] in = getRandom(0, 10, 15);

        Arrays.sort(in);
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {

            System.out.print(i + ", ");
        }
        System.out.println(in.length - 1 + "]");

        // in = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 3, 4, 4, 4, 4 };

        in = rotate(in, 4);
        // in = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(in));

        int n = 2;
        System.out.println("index of " + n + " : " + findRotated2(in, n));

    }

    public static int findRotated(int[] in, int n) {

        int low = 0, high = in.length - 1;

        while (low <= high) {
            // 7 8 9 1 2 3 4 5 6 9

            int mid = low + (high - low) / 2;

            if (in[mid] == n)
                return mid;

            // left sorted
            if (in[low] < in[mid]) {

                if (in[low] <= n && n < in[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

            else {

                if (in[mid] < n && n <= in[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }

    public static int findRotated2(int[] in, int n) {

        int low = 0, high = in.length - 1;

        while (low <= high) {
            // 7 8 9 1 2 3 4 5 6 9

            int mid = low + (high - low) / 2;

            if (in[mid] == n)
                return mid;

            if (in[low] == in[mid] && in[mid] == in[high]) {
                low++;
                high--;
                continue;
            }
            // left sorted
            if (in[low] <= in[mid]) {

                if (in[low] <= n && n < in[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

            else {

                if (in[mid] < n && n <= in[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }
}
