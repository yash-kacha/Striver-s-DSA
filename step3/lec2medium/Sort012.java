package step3.lec2medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 1, 1, 0, 0, 1, 1, 2, 2, 1, 0, 1, 2, 2, 0 };
        // int[] in = new int[] { 2, 2 };
        sort(in);

        System.out.println(Arrays.toString(in));

    }

    public static void sort(int[] x) {
        int low = 0, mid = 0, high = x.length - 1;

        // 0 -> low-1 == 0
        // low -> mid-1 == 1
        // mid -> high-1 == unsorted
        // high -> n-1 ==2

        while (mid <= high - 1) {
            System.out.println(Arrays.toString(x));
            System.out.println("mid:" + mid + " high:" + high);
            System.out.print(" ");
            for (int i = 0; i < mid * 3; i++) {
                System.out.print(" ");
            }
            System.out.println("^");

            long delay = 100; // 2 seconds
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start < delay) {
                // Do nothing (busy wait)
            }
            if (x[mid] == 0) {
                // int temp = x[mid];
                x[mid] = 1;
                x[low] = 0;

                low++;
                mid++;

            } else if (x[mid] == 1) {

                mid++;

            } else if (high > 0 && x[mid] == 2) {

                x[mid] = x[high];
                x[high] = 2;

                high--;
            }
        }
    }
}
