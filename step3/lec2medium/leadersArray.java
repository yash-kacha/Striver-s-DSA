package step3.lec2medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leadersArray {
    public static void main(String[] args) {
        int[] in = new int[] {};
        System.out.println(Arrays.toString(leader(in)));
    }

    public static int[] leader(int[] x) {
        List<Integer> ans = new ArrayList<>();

        int max = x[x.length - 1] - 1;

        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] > max) {
                ans.add(x[i]);
                max = x[i];
            }
        }

        ans = ans.reversed();
        int[] intArray = ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return intArray;
    }

}
