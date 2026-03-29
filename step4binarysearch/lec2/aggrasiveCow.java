package step4binarysearch.lec2;

import java.util.*;

import codevita.sortedParcel;
import java.lang.reflect.Array;

public class aggrasiveCow {

    public static void main(String[] args) {
        // int k = 4;
        // int[] arr = {0, 3, 4, 7, 10, 9};

        int k = 2;
        int[] arr = {4, 2, 1, 3, 6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("ANS is : " + minDist(arr, k));
        System.out.println("ANS opt is : " + optMinDist(arr, k));
    }

    public static int minDist(int[] arr, int k) {
        int ans = 0;
        int n = arr.length;
        int i = 1;
        for (; i < arr[n - 1] - arr[0]; i++) {
            if (canPlaceCow(arr, i, k)) {
                System.out.println("we can place cows : " + i);
            } else {
                return i - 1;
            }
        }
        return i;
    }

    public static int optMinDist(int[] arr, int k) {
        int n = arr.length;
        int min = 1, max = arr[n - 1] - arr[0];
        int mid = 0;

        while (min <= max) {
            mid = min + ((max - min) / 2);
            if (canPlaceCow(arr, mid, k)) {
                min = mid + 1;

            } else {
                max = mid;
            }

        }
        return mid;
    }

    public static boolean canPlaceCow(int[] arr, int n, int k) {
        // System.out.println("checeking : " + n);
        int p1 = 0, p2 = 0;
        k--;
        for (int i = 0; i < arr.length && k > 0 && p2 < arr.length && p1 < arr.length; i++) {
            if (arr[p2] - arr[p1] >= n) {
                p1 = p2;
                p2++;
                k--;
            } else {
                p2++;
            }
        }
        return k == 0;
    }

}
