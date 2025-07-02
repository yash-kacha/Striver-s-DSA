package step3.lec2medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class alternatingPN {
    public static void main(String[] args) {
        int[] in = new int[] { -2, 8, -5, 7, -3, -6, -88, 8, 9, 1, -3, 4, -1, 2, -5 };

        System.out.println(Arrays.toString(alter1(in)));
    }

    public static int[] alter(int[] z) {
        int[] ans = new int[z.length];
        int p = 0, n = 1;
        for (int i : z) {
            if (i >= 0) {
                ans[p] = i;
                p += 2;
            } else {
                ans[n] = i;
                n += 2;
            }
        }
        return ans;
    }

    public static int[] alter1(int[] z) {

        int[] ans = new int[z.length];

        List<Integer> po = new ArrayList<>();
        List<Integer> ne = new ArrayList<>();

        for (int i : z) {
            if (i >= 0) {
                po.add(i);
            } else {
                ne.add(i);
            }
        }

        // 3 5
        // 0 1 2 3 4 5 6 7 8 9
        int i = 0;
        if (po.size() <= ne.size()) {
            for (; i < po.size(); i++) {
                ans[i * 2] = po.get(i);
                ans[(i * 2) + 1] = ne.get(i);
            }
            for (int temp = (i * 2); i < ne.size(); i++, temp++) {
                ans[temp] = ne.get(i);
            }
        } else {
            for (; i < ne.size(); i++) {
                ans[i * 2] = po.get(i);
                ans[(i * 2) + 1] = ne.get(i);
            }
            System.out.println("op");

            for (int temp = (i * 2); i < po.size(); i++, temp++) {
                ans[temp] = po.get(i);
            }
        }

        // int p = 0, n = 1;
        // for (int i : z) {
        // if (i >= 0) {
        // ans[p] = i;
        // p += 2;
        // } else {
        // ans[n] = i;
        // n += 2;
        // }
        // }
        return ans;
    }

}
