package step3.lec3hard;

import java.util.Arrays;

public class mergeTwoSorted {
    public static void main(String[] args) {
        int[] in1 = { 1, 4, 8, 10 };
        int[] in2 = { 2, 3, 9 };

        /*
         * { 1, 4, 8, 10 }
         * { 2, 3, 9 }
         * 
         * { 1, 2, 8, 10 }
         * { 4, 3, 9 }
         * 
         * { 1, 2, 4, 10 }
         * { 8, 3, 9 }
         * 
         * 
         */

        mergeSorted(in1, in2);
        System.out.println(Arrays.toString(in1));
        System.out.println(Arrays.toString(in2));
    }

    public static void mergeSorted(int[] in1, int[] in2) {
        int p1 = 0, p2 = 0;

        while (p1 < in1.length) {

            if (in1[p1] <= in2[p2]) {
                p1++;
            }

            else {
                // swap
                int temp = in2[p2];
                in2[p2] = in1[p1];
                in1[p1] = temp;

                p1++;
            }
            Arrays.sort(in1);
            Arrays.sort(in2);
        }
    }

}
