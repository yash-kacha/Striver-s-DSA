package step1.lec4basicmath;

public class prime {
    public static void main(String[] args) {

        for (int n = 1; n < 99; n++) {
            if (prime(n))
                System.out.println("Number " + n + " is prime");
            else
                System.out.println("Number " + n + " is not prime");
        }
    }

    public static boolean prime(int n) {
        if (n <= 1)
            return false;
        boolean ans = true;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans = false;
                break;
            }
        }

        return ans;
    }
}
