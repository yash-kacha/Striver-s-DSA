package step2.lec1sort;

import java.util.Arrays;

public class selection {
    public static void main(String[] args) {
        int[] in = new int[] { 4, 3, 7, 1, 9, 10, 11, 23, 2 };
        selection(in);
        System.out.println(Arrays.toString(in));
    }

    public static void selection(int[] n) {
        for (int i = 0; i < n.length; i++) {
            int min = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[min] > n[j])
                    min = j;
            }

            int temp = n[i];
            n[i] = n[min];
            n[min] = temp;
        }
    }
}
