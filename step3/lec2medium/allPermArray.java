package step3.lec2medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allPermArray {
    public static void main(String[] args) {
        int[] in = { 1, 2, 3 };

        for (int[] i : perm(in)) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static List<int[]> perm(int[] y) {
        List<int[]> ans = new ArrayList<>();
        permute(y, 0, ans);
        return ans;
    }

    public static void permute(int[] y, int index, List<int[]> z) {

        if (index == y.length) {
            z.add(Arrays.copyOf(y, y.length));
            return;
        }

        for (int i = index; i < y.length; i++) {
            swap(i, index, y);
            permute(y, index + 1, z);
            swap(i, index, y);
        }
    }

    public static void swap(int n1, int n2, int[] x) {
        int temp = x[n1];
        x[n1] = x[n2];
        x[n2] = temp;
    }
}
