package step3.lec1easy;

import java.util.Arrays;

public class mergeSorted {
    public static void main(String[] args) {
        int[] in1 = new int[] { 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9 };
        int[] in2 = new int[] { 1, 1, 2, 6, 6, 7, 8, 15, 16, 57, 68, 86, 93 };

        System.out.println(Arrays.toString(mergeSort(in1, in2)));
    }

    public static int[] mergeSort(int[] in1, int[] in2) {
        int[] ans = new int[in1.length + in2.length];
        int ap = 0, xp = 0, yp = 0;

        while (xp < in1.length && yp < in2.length) {
            if (in1[xp] <= in2[yp]) {
                ans[ap++] = in1[xp++];
            } else {
                ans[ap++] = in1[yp++];
            }

        }

        while (xp < in1.length) {
            ans[ap++] = in1[xp++];
        }
        while (yp < in2.length) {
            ans[ap++] = in2[yp++];
        }

        return ans;
    }
}
