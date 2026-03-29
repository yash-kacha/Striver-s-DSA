package NQT.prev_2025;

public class aquaOp {

    public static void main(String[] args) {
        String s = "abbbaabbbabaaa";
        int l = 5;

        System.out.println(solve(s, l));
    }

    private static int solve(String s, int l) {

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % l == 0) {
                cnt = 0;
            }
            if (s.charAt(i) == 'a') {
                cnt++;
            }

            if (cnt > ans) {
                ans = cnt;
            }
        }
        return ans;
    }
}
