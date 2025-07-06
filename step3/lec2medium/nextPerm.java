package step3.lec2medium;

import java.util.Arrays;

public class nextPerm {
    public static void main(String[] args) {
        int[] ans = { 3, 1, 2 };
        nextP(ans);
        System.out.println(Arrays.toString(ans));
    }

    public static void nextP(int[] z) {
        int n = z.length, index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (z[i] < z[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            rev(0, n - 1, z);
            return;
        }

        for (int i = n - 1; i > index; i--) {
            if (z[index] < z[i]) {
                swap(i, index, z);

                rev(index + 1, n - 1, z);
                return;
            }
        }
    }

    public static void swap(int i, int j, int[] z) {
        int temp = z[i];
        z[i] = z[j];
        z[j] = temp;
    }

    public static void rev(int b, int e, int[] z) {
        while (b < e) {
            swap(b++, e--, z);
        }
    }

}
