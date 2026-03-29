package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueen {

    public static void main(String[] args) {
        int n = 5;
        List<char[][]> ans = new ArrayList<>();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '.');
        }
        solveQueen(n, ans, arr, 0);

        for (char[][] ch : ans) {
            for (char[] c : ch) {
                System.out.println(Arrays.toString(c));
            }
            System.out.println("\n\n");
        }
    }

    private static void solveQueen(int n, List<char[][]> ans, char[][] arr, int j) {
        System.out.println("issue");
        if (j == n && isValid(arr)) {
            char[][] copy = new char[n][n];
            for (int i = 0; i < n; i++) {
                copy[i] = Arrays.copyOf(arr[i], n);
            }
            ans.add(copy);
            return;
        }
        if (j == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[i][j] = 'Q';
            if (isValid(arr)) {
                solveQueen(n, ans, arr, j + 1);
            }
            arr[i][j] = '.';
        }

    }

    private static boolean isValid(char[][] arr) {

        int n = arr.length;
        int[] countH = new int[n];
        int[] countV = new int[n];
        int[] count45 = new int[2 * n - 1];
        int[] count135 = new int[2 * n - 1];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[i][j] == 'Q') {
                    countH[i]++;
                    countV[j]++;
                    count45[i + j]++;
                    count135[i - j - 1 + n]++;

                    if (countH[i] == 2 || countV[j] == 2 || count45[i + j] == 2 || count135[i - j - 1 + n] == 2) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
