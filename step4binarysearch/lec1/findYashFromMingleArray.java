package step4binarysearch.lec1;

import java.util.Arrays;

public class findYashFromMingleArray {
    public static void main(String[] args) {
        int[] in = { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 6, 6, 5, 5, 9, 9, 13, 45, 45, 78, 78, 99, 99, 101, 101 };

        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
        System.out.println(in[findYash(in)]);
    }

    public static int findYash(int[] in) {
        int size = in.length;
        if (size == 1)
            return 0;
        if (size == 2)
            return -1;
        if (in[0] != in[1])
            return 0;
        if (in[size - 1] != in[size - 2])
            return size - 1;

        int low = 1, high = size - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (in[mid] != in[mid - 1] && in[mid] != in[mid + 1])
                return mid;

            if ((mid % 2 == 0 && in[mid] == in[mid + 1]) || (mid % 2 == 1 && in[mid] == in[mid - 1])) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }

        }
        return -1;
    }

}
