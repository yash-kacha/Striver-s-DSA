package step3.lec1easy;

public class secondLargest {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 5, 2, 9, 9, 6, 7, 8, 99, 34, 15, 4, 5, 3, 3, 0, 999, 5 };
        System.out.println(max2(in));
    }

    public static int max2(int[] x) {
        int max = x[0], max2 = x[0];

        for (int i = 1; i < x.length; i++) {
            if (x[i] >= max) {
                max2 = max;
                max = x[i];
            } else if (x[i] < max && x[i] > max2)
                max2 = x[i];
        }
        return max2;
    }
}
