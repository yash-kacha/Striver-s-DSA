package step3.lec2medium;

import java.util.*;;

public class generateAllPerm {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] in = { 1, 2, 3 };
        generate(in, ans, 0);
        for (List<Integer> y : ans) {
            for (Integer z : y) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }

    public static void generate(int[] z, List<List<Integer>> ans, int num) {
        if (num == z.length) {
            List<Integer> op = new ArrayList<>();
            for (int zz : z) {
                op.add(zz);
            }
            ans.add(op);
            return;
        }

        for (int i = num; i < z.length; i++) {
            swap(i, num, z);
            generate(z, ans, num + 1);
            swap(i, num, z);
        }

    }

    public static void swap(int i, int j, int[] z) {
        int temp = z[i];
        z[i] = z[j];
        z[j] = temp;
    }

}
