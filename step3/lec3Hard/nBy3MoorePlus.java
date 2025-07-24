package step3.lec3Hard;

import java.util.ArrayList;
import java.util.List;

public class nBy3MoorePlus {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 4, 4, 4, 3, 3, 3, 2 };
        List<Integer> ans = greaterNby3(in);
        System.out.println(ans.toString());
    }

    public static List<Integer> greaterNby3(int[] x) {
        int cnt1 = 0, el1 = Integer.MIN_VALUE;
        int cnt2 = 0, el2 = Integer.MIN_VALUE;

        for (int i : x) {
            if (el1 == i) {
                cnt1++;
            } else if (el2 == i) {
                cnt2++;
            } else if (cnt1 == 0) {
                el1 = i;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = i;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();

        cnt1 = 0;
        cnt2 = 0;
        for (int num : x) {
            if (num == el1)
                cnt1++;
            else if (num == el2)
                cnt2++;
        }
        if (cnt1 > x.length / 3)
            ans.add(el1);
        if (cnt2 > x.length / 3)
            ans.add(el2);

        return ans;

    }
}
