package step3.lec1easy;

public class maxConsicutive {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 1, 1, 9, 9, 9, 9, 9, 9, 0, 1, 1, 1, 0, 0, 1 };
        System.out.println(max2(in));
    }

    public static int max2(int[] x) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i] == x[i - 1]) {
                cnt++;
            } else {
                ans = ans > cnt ? ans : cnt;
                cnt = 1;
            }

        }
        ans = ans > cnt ? ans : cnt;

        return ans;
    }
}
