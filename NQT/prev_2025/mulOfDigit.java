package NQT.prev_2025;

public class mulOfDigit {

    public static void main(String[] args) {
        int n = 5442;

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int ans = 1;

        while (n > 0) {
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }
}
