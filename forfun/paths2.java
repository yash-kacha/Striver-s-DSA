package forfun;

import java.util.*;

import step1.lec4basicmath.gcd;

public class paths2 {
    public static void main(String[] args) {

        System.out.println("total nums : " + pathNCR(3, 7));

    }

    public static long path2(int n, int m) {

        long[][] map = new long[n][m];

        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[n - 1][m - 1];
    }

    // 1 1 1 1 1
    // 1 2 3 4 5
    // 1 3 6 10 15
    // 1 4 10 20 35
    // 1 5 15 35 70

    public static long pathNCR(int n, int m) {
        return ncr(n + m - 2, Math.min(m - 1, n - 1));
    }

    public static long ncr(int n, int m) {
        long ans = 1;

        for (long i = n, cnt = m; cnt >= 1; i--, cnt--) {
            ans *= i;
            ans /= cnt;
        }
        return ans;

    }
}
