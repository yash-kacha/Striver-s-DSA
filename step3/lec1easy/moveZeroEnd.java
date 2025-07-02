package step3.lec1easy;

import java.util.Arrays;

public class moveZeroEnd {
    public static void main(String[] args) {
        int[] in = new int[] { 0, 1, 2, 3, 0, 4, 5, 6, 0, 0, 7 };
        zeroMove(in);
        System.out.println(Arrays.toString(in));
    }

    public static void zeroMove(int[] x) {

        int index = 0, cnt = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                if (cnt == 0) {
                    index = i;
                }
                cnt++;
                System.out.println("index i : " + index + "  " + Arrays.toString(x));
            }

            else {
                x[index] = x[i];
                x[i] = 0;
                if (cnt > 1) {
                    index++;
                } else
                    index = i;
            }

        }

    }
}
