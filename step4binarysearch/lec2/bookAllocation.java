package step4binarysearch.lec2;

import java.util.Arrays;

public class bookAllocation {

    public static void main(String[] args) {
        int m = 2;
        int[] arr = {12, 34, 67, 90};

        System.out.println(maxPage(arr, 2));
    }

    public static int maxPage(int[] arr, int m) {
        int n = arr.length;

        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).sum();
        System.out.println(min + " : " + max);
        int ans = -1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            System.out.println(mid + " : " + ableStu(arr, mid));
            if (ableStu(arr, mid) <= m) {
                ans = mid;        // valid answer
                max = mid - 1;    // try to minimize
            } else {
                min = mid + 1;    // increase pages
            }
        }
        return ans;

    }

    //  25, 46, 28, 49, 24
    private static int ableStu(int[] arr, int maxPages) {
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
