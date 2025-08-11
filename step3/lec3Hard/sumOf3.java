package step3.lec3hard;

import java.util.*;

public class sumOf3 {
    public static void main(String[] args) {
        int[] in = new int[] { 2, -2, 0, 3, -3, 5 };

        // for (List<Integer> i : sum3Better(in)) {
        // System.out.println(i.toString());
        // }

        for (List<Integer> i : sum3Optimal(in)) {
            System.out.println(i.toString());
        }
    }

    public static List<int[]> sum3Brute(int[] x) {
        List<int[]> ans = new ArrayList<>();
        int n = x.length;
        for (int i = 0; i < n - 2; i++) {
            for (int ii = i + 1; ii < n - 1; ii++) {
                for (int iii = ii + 1; iii < n; iii++) {
                    if (x[i] + x[ii] + x[iii] == 0)
                        ans.add(new int[] { x[i], x[ii], x[iii] });
                }
            }
        }
        return ans;
    }

    public static Set<List<Integer>> sum3Better(int[] x) {
        Arrays.sort(x);
        Set<List<Integer>> ans = new HashSet<>();
        int n = x.length;

        for (int i = 0; i < n - 2; i++) {
            Set<Integer> check = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int want = -x[i] - x[j];
                if (check.contains(want)) {
                    List<Integer> temp = Arrays.asList(x[i], x[j], want);
                    Collections.sort(temp);
                    ans.add(temp);
                } else {
                    check.add(x[j]);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> sum3Optimal(int[] x) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(x);
        int n = x.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && x[i] == x[i - 1])
                continue; // skip duplicate i

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = x[i] + x[j] + x[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(x[i], x[j], x[k]));

                    // Skip duplicates for j and k
                    while (j < k && x[j] == x[j + 1])
                        j++;
                    while (j < k && x[k] == x[k - 1])
                        k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }

}
