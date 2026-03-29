package step4binarysearch.lec3;

public class metrixMedian {

    public static void main(String[] args) {
        int[][] arr = {
            {-5, -3, -1},
            {0, 2, 4},
            {6, 8, 10}
        };

        System.out.println("Median is : " + median(arr));
    }

    private static int median(int[][] arr) {
        int low = findlh(arr)[0];
        int high = findlh(arr)[1];
        int want = arr.length * arr[0].length / 2;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            // System.out.println("mid : " + mid);
            if (blackbox(arr, mid) < want) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

    private static int blackbox(int[][] arr, int mid) {
        int ans = 0;
        for (int[] arr1 : arr) {
            // System.out.println("issue");

            ans += upperbound(arr1, mid);
        }
        // System.out.println("bb : " + ans);
        return ans;
    }

    private static int upperbound(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + ((high - low) / 2);

            if (arr[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        // System.out.println("upper " + Arrays.toString(arr) + " : " + k + " :  " + low);
        return low;
    }

    private static int[] findlh(int[][] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr[0].length - 1;
        for (int[] arr1 : arr) {
            if (arr1[0] < min) {
                min = arr1[0];
            }
            if (arr1[n] > max) {
                max = arr1[n];
            }
        }
        // System.out.println(min + " :: " + max);
        return new int[]{min, max};
    }

}
