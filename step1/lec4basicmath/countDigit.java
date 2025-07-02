package step1.lec4basicmath;

public class countDigit {
    public static void main(String[] args) {

        int n = 9999;
        System.out.println(count(n));

        System.out.println("second method : " + count2(n));
    }

    public static int count(int n) {
        System.out.println(n);
        return (int) (Math.log10(n) + 1);
    }

    public static int count2(int n) {
        int ans = 0;
        while (n > 0) {
            n /= 10;
            ans++;
        }
        return ans;
    }
}
