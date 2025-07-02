package step3.lec1easy;

public class missingNumber {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 3, 4, 6, 7, 8, 9 };
        System.out.println(max2(in));
    }

    public static int max2(int[] x) {

        for (int i = 1; i < x.length; i++) {
            if (x[i] - 1 != x[i - 1])
                return x[i] - 1;
        }
        return -1;
    }
}
