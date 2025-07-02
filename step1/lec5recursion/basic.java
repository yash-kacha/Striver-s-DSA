package step1.lec5recursion;

public class basic {
    public static void main(String[] args) {
        rec(10);
    }

    public static void rec(int i) {
        if (i < 0)
            return;

        System.out.println(i);
        rec(--i);
    }
}
