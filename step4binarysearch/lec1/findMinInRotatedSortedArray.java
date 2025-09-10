package step4binarysearch.lec1;

import java.util.Arrays;
import static step4binarysearch.lec1.lowerUpper.getRandom;
import static step4binarysearch.lec1.lowerUpper.rotate;

public class findMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] in = getRandom(1, 10, 15);

        Arrays.sort(in);
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {

            System.out.print(i + ", ");
        }
        System.out.println(in.length - 1 + "]");

        in = rotate(in, 6);
        System.out.println(Arrays.toString(in));

        System.out.println("minimum is : " + in[minimum2(in)]);
        System.out.println("array is rotated" + minimum2(in) + " times");
    }

    public static int minimum(int[] in) {
        int low = 0, high = in.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {

            if (in[low] < in[high])
                return in[low];
            int mid = low + (high - low) / 2;

            // left sorted
            if (in[low] <= in[mid]) {
                if (in[low] <= ans)
                    ans = in[low];
                low = mid + 1;
            }

            else {
                if (in[mid] <= ans)
                    ans = in[mid];
                high = mid - 1;

            }
        }
        return ans;
    }

    public static int minimum2(int[] in) {
        int low = 0, high = in.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // left sorted
            if (in[mid] > in[high]) {
                low = mid + 1;
            } else if (in[mid] < in[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return low;
    }

}
