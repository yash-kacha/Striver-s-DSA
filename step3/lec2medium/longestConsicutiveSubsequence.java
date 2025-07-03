package step3.lec2medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsicutiveSubsequence {
    public static void main(String[] args) {
        int[] in = new int[] { 5, 100, 201, 202, 203, 204, 205, 206, 207, 208, 200, 1, 3, 2, 4 };
        System.out.println(longestOptimal(in));
    }

    public static int longest(int[] x) {
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        int temp = 1, ans = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i] == x[i - 1]) {
            }

            else if (x[i] - 1 == x[i - 1]) {
                temp++;
            } else {
                ans = Math.max(temp, ans);
                temp = 1;
            }
        }
        ans = Math.max(temp, ans);
        return ans;
    }

    public static int longestOptimal(int[] x) {
        Set<Integer> op = new HashSet<>();
        for (int i : x) {
            op.add(i);
        }
        int cnt, ans = 1;
        for (Integer i : op) {
            if (op.contains(i - 1))
                continue;
            else {
                cnt = 1;
                for (int j = 1;; j++) {
                    if (op.contains(i + j))
                        cnt++;
                    else
                        break;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
