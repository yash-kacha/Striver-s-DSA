package step1.lec4basicmath;

public class palindromNum {
    public static void main(String[] args) {
        int n = 1234321;
        System.out.println("number is palindrom : " + (n == revNum(n)));
    }

    public static int revNum(int i) {
        int ans = 0, mul = 1;

        while (i > 0) {
            ans = (ans * 10) + (i % 10);
            i /= 10;
        }
        return ans;
    }
}
