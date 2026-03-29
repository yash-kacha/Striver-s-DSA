package step4binarysearch.lec2;

import java.util.Arrays;

public class arrayPartition {

    public static void main(String[] args) {
        int m = 3;
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(maxSum(arr, m));
    }

    public static int maxSum(int[] arr, int m) {

        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).sum();
        System.out.println(min + " ::: " + (min + (max - min) / 2) + " ::: " + max);
        int ans = -1;

        while (min <= max) {
            int mid = (min + (max - min) / 2);

            System.out.print(min + " ::: " + (min + (max - min) / 2) + " ::: " + max + " === ");
            System.out.println(parti(arr, mid));
            if (parti(arr, mid) > m) {

                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1;
            }

        }
        return ans;
    }

    private static int parti(int[] arr, int maxPages) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] <= maxPages) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
            }
        }
        return students;
    }

}
