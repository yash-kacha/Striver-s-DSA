package forfun;

import java.util.Arrays;

class maxSumSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int max = 0;
        int preSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            preSum = preSum < 0 ? curr : preSum + curr;
            max = Math.max(max, preSum);

        }
        return max;
    }

    private static int[] solve1(int[] arr) {
        int max = 0;
        int preSum = 0;
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (preSum < 0) {
                preSum = curr;
                x = i;
            } else {
                preSum += curr;
            }
            if (preSum > max) {
                y = i;
                max = preSum;
            }

        }
        return Arrays.copyOfRange(arr, x, y + 1);
    }
}
