package step3.lec1easy;

public class oneNumber {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 9, 1, 2, 2, 3, 19, 3, 9, 4, 4, 5, 5 };
        System.out.println(max2(in));
    }

    public static int max2(int[] x) {
        int max = x[0];

        for (int i = 1; i < x.length; i++) {
            max = max ^ x[i];
        }
        return max;
    }
}
