package step1.lec4basicmath;

public class reverseNum {
    public static void main(String[] args) {
        System.out.println(revNum(1234));
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
