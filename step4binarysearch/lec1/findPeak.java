package step4binarysearch.lec1;

import java.util.Arrays;

public class findPeak {
    public static void main(String[] args) {
        int[] in = { 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1 };

        System.out.println(Arrays.toString(in));
        System.out.println(in[onePeak(in)]);
    }

    public static int onePeak(int[] in) {
        int size = in.length;
        if (size == 1)
            return 0;

        if (in[0] > in[1])
            return 0;
        if (in[size - 1] > in[size - 2])
            return size - 1;
        int low = 1, high = size - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (in[mid] > in[mid - 1] && in[mid] > in[mid + 1])
                return mid;

            if (in[mid] > in[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
