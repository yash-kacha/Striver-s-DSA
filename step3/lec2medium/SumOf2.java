package step3.lec2medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOf2 {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 1, 1, 0, 0, 1, 1, 2, 2, 3, 4, 5, 5, 8 };

        System.out.println(Arrays.toString(sum2(in, 13)));
    }

    public static int[] sum2(int[] y, int z) {
        Map<Integer, Integer> op = new HashMap<>();

        int[] ans = new int[] { -1, -1 };
        for (int i = 0; i < y.length; i++) {
            int rem = z - y[i];

            if (op.containsKey(rem)) {
                ans[0] = i;
                ans[1] = op.get(rem);
                return ans;
            }
            op.putIfAbsent(y[i], i);

            for (Map.Entry<Integer, Integer> en : op.entrySet()) {
                System.out.print(en.getKey() + " : ");
                System.out.print(en.getValue() + " ");

            }
            System.out.println();

        }
        return ans;
    }
}
