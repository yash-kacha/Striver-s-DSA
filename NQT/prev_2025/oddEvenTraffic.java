package NQT.prev_2025;

import java.util.Arrays;

public class oddEvenTraffic {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1, 2, 5, 8, 9};
        int fine = 1000;
        int date = 16;

        System.out.println(solve(arr, fine, date));
    }

    private static int solve(int[] arr, int fine, int date) {
        boolean D = date % 2 == 0;

        int countOdd = (int) Arrays.stream(arr).filter(a -> a % 2 == 1).count();

        return D ? countOdd * fine : (arr.length - countOdd) * fine;
    }
}
