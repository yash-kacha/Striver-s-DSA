package step1.lec5recursion;

public class Ntimes {
    public static void main(String[] args) {

        rec(10, "yash");
    }

    public static void rec(int i, String s) {
        if (i < 0)
            return;

        System.out.println(i + "  " + s);
        rec(--i, s);
    }

}
