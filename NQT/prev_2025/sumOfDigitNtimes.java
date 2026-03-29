package NQT.prev_2025;

public class sumOfDigitNtimes {

    public static void main(String[] args) {
        int n = 989898998;
        int x = 8;

        System.out.println(solve(n, x));
    }

    private static int solve(int n, int x) {

        while (x > 0) {
            int temp = 0;
            if (n < 10) {
                return n;
            }
            while (n > 0) {
                temp += n % 10;
                n /= 10;
            }
            n = temp;
            System.out.println(n);
            x--;
        }
        return n;
    }
}
