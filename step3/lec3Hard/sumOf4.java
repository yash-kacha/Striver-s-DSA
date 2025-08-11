package step3.lec3hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sumOf4 {
    public static void main(String[] args) {
        int[] in = new int[] { 2, -2, 0, 3, -3, 5 };

        // for (List<Integer> i : sum3Better(in)) {
        // System.out.println(i.toString());
        // }

        // for (int[] i : sum4Brute(in, 0)) {
        // System.out.println(Arrays.toString(i));
        // }

        // for (List<Integer> i : sum4Better(in, 2)) {
        // System.out.println(i.toString());
        // }
        for (List<Integer> i : sum4Optimal(in, 0)) {
            System.out.println(i.toString());
        }
    }

    public static List<int[]> sum4Brute(int[] x, int target) {
        List<int[]> ans = new ArrayList<>();
        int n = x.length;
        for (int i = 0; i < n - 3; i++) {
            for (int ii = i + 1; ii < n - 2; ii++) {
                for (int iii = ii + 1; iii < n - 1; iii++) {
                    for (int iiii = iii + 1; iiii < n; iiii++) {
                        if (x[i] + x[ii] + x[iii] + x[iiii] == target)
                            ans.add(new int[] { x[i], x[ii], x[iii], x[iiii] });
                    }

                }
            }
        }
        return ans;
    }

    public static Set<List<Integer>> sum4Better(int[] x, int target) {
        Arrays.sort(x);
        Set<List<Integer>> ans = new HashSet<>();
        int n = x.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                Set<Integer> check = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int want = target - x[i] - x[j] - x[k];

                    if (check.contains(want)) {
                        List<Integer> temp = Arrays.asList(x[i], x[j], x[k], want);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    check.add(x[k]);

                }
                // int want = -x[i] - x[j];
                // if (check.contains(want)) {
                // List<Integer> temp = Arrays.asList(x[i], x[j], want);
                // Collections.sort(temp);
                // ans.add(temp);
                // } else {
                // check.add(x[j]);
                // }
            }
        }
        return ans;
    }

    public static List<List<Integer>> sum4Optimal(int[] x, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(x);
        int n = x.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && x[i] == x[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && x[j] == x[j - 1])
                    continue;

                int k = j + 1, l = n - 1;

                while (k < l) {
                    int sum = x[i] + x[j] + x[k] + x[l];
                    if (sum == target) {

                        ans.add(Arrays.asList(x[i], x[j], x[k], x[l]));

                        while (k < l && x[k] == x[k + 1])
                            k++;
                        while (k < l && x[l] == x[l - 1])
                            l--;

                        k++;
                        l--;

                    }

                    else if (sum < target)
                        k++;
                    else
                        l--;

                }

            }

        }
        return ans;
    }
}