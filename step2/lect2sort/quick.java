package step2.lect2sort;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 3 };
        quick(in, 0, in.length - 1);
        System.out.println(Arrays.toString(in));
        // test();
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
            quick(actual, 0, actual.length - 1); // Your Quick Sort

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

    public static void quick(int[] x, int low, int high) {
        if (low >= high)
            return;

        int partition = finder(x, low, high);
        System.out.println(Arrays.toString(x));
        quick(x, low, partition - 1);
        quick(x, partition + 1, high);

    }

    public static int finder(int[] x, int low, int high) {

        int pivot = x[low], left = low, right = high;

        while (left < right) {
            while (x[left] <= pivot && left < high) {
                left++;
            }

            while (x[right] > pivot && right > low) {
                right--;
            }
            if (left < right) {
                int temp = x[left];
                x[left] = x[right];
                x[right] = temp;
            }
        }
        int temp = x[low];
        x[low] = x[right];
        x[right] = temp;

        return right;
    }
}
