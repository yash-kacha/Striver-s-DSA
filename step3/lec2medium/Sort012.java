package step3.lec2medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 1, 1, 0, 0, 1, 1, 2, 2, 1, 0, 1, 2, 2, 0 };
        // int[] in = new int[] { 2, 2 };
        // int[] in = new int[] { 1, 0, 0, 2, 1, 0, 2, 2 };
        sort(in);

        System.out.println(Arrays.toString(in));

    }

    public static void sort(int[] x) {
        int low = 0, mid = 0, high = x.length - 1;

        // 0 -> low-1 == 0
        // low -> mid-1 == 1
        // mid -> high-1 == unsorted
        // high -> n-1 ==2

        while (mid <= high) {
            // System.out.println(Arrays.toString(x));
            // System.out.println("mid:" + mid + " high:" + high);
            // System.out.print(" ");
            // for (int i = 0; i < mid * 3; i++) {
            // System.out.print(" ");
            // }
            // System.out.println("^");

            if (x[mid] == 0) {
                swap(mid, low, x);
                low++;
                mid++;

            } else if (x[mid] == 1) {

                mid++;

            } else if (high >= 0 && x[mid] == 2) {

                swap(mid, high, x);
                high--;
            }
        }
    }

    public static void swap(int n1, int n2, int[] x) {
        int temp = x[n1];
        x[n1] = x[n2];
        x[n2] = temp;
    }
}
