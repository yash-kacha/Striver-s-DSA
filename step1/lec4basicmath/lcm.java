package step1.lec4basicmath;

public class lcm {
    public static void main(String[] args) {
        System.out.println(lcm(15, 20));
    }

    public static int lcm(int x, int y) {
        return (x * y) / (gcd2(x, y));
    }

    public static int gcd2(int x, int y) {
        while (x != 0 || y != 1) {
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
