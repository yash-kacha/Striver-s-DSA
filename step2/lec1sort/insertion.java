package step2.lec1sort;

import java.util.Arrays;

public class insertion {
    public static void main(String[] args) {
        int[] in = new int[] { 4, 3, 7, 1, 9, 10, 11, 23, 2 };
        insertion(in);
        System.out.println(Arrays.toString(in));
    }

    public static void insertion(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int temp = i;
            while (temp >= 1 && n[temp] < n[temp - 1]) {
                n[temp] += n[temp - 1];
                n[temp - 1] = n[temp] - n[temp - 1];
                n[temp] -= n[temp - 1];
                temp--;
            }
        }
    }
}
