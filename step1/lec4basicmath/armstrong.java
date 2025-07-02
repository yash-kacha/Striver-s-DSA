package step1.lec4basicmath;

public class armstrong {
    public static void main(String[] args) {
        int n = 1634;
        System.out.println("armstrong : " + arm(n));
    }

    public static boolean arm(int n) {
        int length = (int) (Math.log10(n) + 1);
        int ans = 0;
        int temp = n;

        while (temp > 0) {
            ans += Math.pow(temp % 10, length);

            temp /= 10;
        }

        return ans == n;
    }
}
