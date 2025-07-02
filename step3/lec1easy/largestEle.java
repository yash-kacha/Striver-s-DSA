package step3.lec1easy;

public class largestEle {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 5, 2, 9, 4, 5, 3, 3, 0, 5 };
        System.out.println(max(in));
    }

    public static int max(int[] x) {
        int ans = x[0];

        for (int i = 1; i < x.length; i++) {
            ans = x[i] > ans ? x[i] : ans;
        }
        return ans;
    }

}
