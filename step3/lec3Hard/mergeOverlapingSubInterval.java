package step3.lec3hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeOverlapingSubInterval {
    public static void main(String[] args) {

        // int[][] in = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] in = { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 1, 2 }, { 15, 18 } };
        for (int[] i : mergeOverlaping(in)) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static List<int[]> mergeOverlaping(int[][] in) {

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(in,
                Comparator.comparingInt((int[] arr) -> arr[0])
                        .thenComparingInt(arr -> arr[1]));

        int b = in[0][0], e = in[0][1];

        for (int i = 0; i < in.length - 1; i++) {

            if (in[i][1] < in[i + 1][0]) {
                ans.add(new int[] { b, e });

                b = in[i + 1][0];
                e = in[i + 1][1];
            } else {
                e = in[i + 1][1];
            }
        }
        ans.add(new int[] { b, e });
        return ans;
    }
}
