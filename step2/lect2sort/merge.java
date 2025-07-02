package step2.lect2sort;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {

        int[] in = new int[] { 3, 2, 1 };
        merge(in, 0, in.length - 1);
        System.out.println(Arrays.toString(in));

        test();
    }

    public static void test() {
        int passed = 0;

        int[][] testCases = {
                { 3, 2, 1 },
                { 1 },
                {},
                { 5, 5, 5, 5 },
                { 1, 2, 3, 4, 5 },
                { 5, 4, 3, 2, 1 },
                { 10, -1, 0, 2, 8, 6 },
                { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 },
                { 1, -1, 1, -1, 1, -1 },
                { 100, 99, 98, 97, 96, 95, 94, 93, 92, 91 },
                { -5, -10, 0, 5, 10 },
                { 8, 3, 7, 4, 9, 2, 6, 5, 1 },
                { 0, 0, 0, 0, 0, 0 },
                { -2, -1, -3, -4, -5 },
                { 99, 1, 34, 67, 88, 21, 3 },
                { 5, -2, 4, -1, 3, 0, 2, 1 },
                { 1000, -1000, 500, -500, 0 },
                { 1, 2, 1, 2, 1, 2, 1, 2 },
                { 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                { 0 },
                { -1, 0, 1 },
                { 2, 2, 1, 1, 3, 3 },
                { 10, 20, 30, 40, 50 },
                { 50, 40, 30, 20, 10 },
                { 2, -2, 4, -4, 6, -6 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] test = testCases[i];
            int[] expected = test.clone();
            Arrays.sort(expected); // Java's built-in sort

            int[] actual = test.clone();
            merge(actual, 0, actual.length - 1); // Your Quick Sort

            if (Arrays.equals(actual, expected)) {
                System.out.println("Test case " + (i + 1) + " passed.");
                passed++;
            } else {
                System.out.println("Test case " + (i + 1) + " failed.");
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("Got : " + Arrays.toString(actual));
            }
        }

        System.out.println("Total passed: " + passed + " out of " +
                testCases.length);

    }

    public static void merge(int[] arr, int low, int high) {

        if (low >= high)
            return;
        // return new int[] { arr[low] };

        int mid = (low + high) / 2;
        merge(arr, low, mid);

        merge(arr, mid + 1, high);

        merger(arr, low, mid, high);

    }

    public static void merger(int[] arr, int low, int mid, int high) {

        int[] ans = new int[high - low + 1];
        int xp = low, yp = mid + 1, ap = 0;

        while (xp <= mid && yp <= high) {
            if (arr[xp] <= arr[yp]) {
                ans[ap++] = arr[xp++];
            }

            else {
                ans[ap++] = arr[yp++];
            }
        }

        while (xp <= mid) {
            ans[ap++] = arr[xp++];
        }
        while (yp <= high) {
            ans[ap++] = arr[yp++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = ans[i - low];
        }

    }
}
