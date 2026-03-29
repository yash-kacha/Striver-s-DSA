package NQT.prev_2025;

import java.util.Arrays;

public class dutch {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 1, 0, 0, 1, 2, 2,};
        solve(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void solve(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0 ->
                    swap(arr, mid++, low++);
                case 1 ->
                    mid++;
                default ->
                    swap(arr, mid, high--);
            }
        }
    }

    private static void swap(int[] arr, int i, int p0) {
        arr[i] ^= arr[p0];
        arr[p0] ^= arr[i];
        arr[i] ^= arr[p0];
    }

}
