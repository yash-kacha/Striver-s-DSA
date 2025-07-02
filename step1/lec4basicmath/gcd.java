package step1.lec4basicmath;

public class gcd {
    public static void main(String[] args) {
        System.out.println(gcd(15, 20));
        System.out.println(gcd2(205, 1995));
    }

    public static int gcd(int x, int y) {
        int ans = 1;
        for (int i = 2; i < Math.min(x, y); i++) {
            if (x % i == 0 && y % i == 0 && i > ans)
                ans = i;

        }
        return ans;
    }

    public static int gcd2(int x, int y) {
        while (x != 0 || y != 1) {
            System.out.println("x , y   :: " + x + "," + y);
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }

            y = y - x;

            if (x == 0)
                return y;
            if (x == 1)
                return 1;
        }

        return 1;
    }
}
