package step4binarysearch.lec3;

import java.util.Arrays;

public class searchInMatrix {

    public static void main(String[] args) {
        int[][] in = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] in = {{2, 4, 6, 8, 10}};
        int target = 10;

        System.out.println(Arrays.toString(find(in, target)));
        System.out.println(Arrays.toString(findOpt(in, target)));
    }

    public static int[] findOpt(int[][] in, int target) {

        int low = 0;
        int n = in.length;
        int m = in[0].length;
        System.out.println("n , m: " + n + "," + m);
        int high = ((n) * (m)) - 1;
        System.out.println("high : " + high);
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int nn = mid / m;
            int mm = mid % m;
            System.out.println("nn " + nn + " mm : " + mm + "  mid : " + mid);
            if (in[nn][mm] < target) {
                low = mid + 1;
            } else if (in[nn][mm] > target) {
                high = mid - 1;
            } else {
                return new int[]{nn, mm};
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] find(int[][] in, int target) {

        int low = 0;
        int high = in.length - 1;
        int i, j;
        i = j = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (target < in[mid][0]) {
                high = mid - 1;
            } else if (target > in[mid][in[mid].length - 1]) {
                low = mid + 1;
            } else {
                i = mid;
                break;
            }
        }

        if (i == -1) {
            System.out.println("form here");
            return new int[]{-1, -1};
        }

        low = 0;
        high = in[i].length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (target < in[i][mid]) {
                high = mid - 1;
            } else if (target > in[i][mid]) {
                low = mid + 1;
            } else {
                j = mid;
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}
