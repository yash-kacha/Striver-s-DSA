package step2.lec1sort;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] in = new int[] { 4, 3, 7, 1, 9, 10, 11, 23, 2 };
        bubble(in);
        System.out.println(Arrays.toString(in));
    }

    public static void bubble(int[] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] > n[j]) {
                    int temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
    }

}
