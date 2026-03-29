package NQT.prev_2025;

public class countMaxTillNow {

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 4, 6, 2, 66, 62, 423, 25, 999, 9999};

        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int ans = 1;
        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
                ans++;
            }
        }
        return ans;
    }
}
