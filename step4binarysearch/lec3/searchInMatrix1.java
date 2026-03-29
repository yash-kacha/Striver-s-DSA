package step4binarysearch.lec3;

import java.util.Arrays;

// 1   4   7   11
// 2   5   8   12
// 3   6   9   16
// 10 13  14  17
public class searchInMatrix1 {

    public static void main(String[] args) {
        // int[][] in = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] in = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}, {10, 13, 14, 17}};
        int[][] in = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};
        // int[][] in = {{2, 4, 6, 8, 10}};
        int target = 5;

        System.out.println(Arrays.toString(find(in, target)));
    }

    private static int[] find(int[][] in, int target) {
        int row = in.length;
        int col = in[0].length;

        int i = 0, j = col - 1;

        while (i < row && col >= 0) {
            System.out.println(i + " :: " + j);
            if (in[i][j] < target) {
                i++;
            } else if (in[i][j] > target) {
                j--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}
