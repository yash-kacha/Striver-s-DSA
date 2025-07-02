package step1.lec5recursion;

public class fibonaci {
    public static void main(String[] args) {
        fibo(10, 0, 1);
    }

    public static void fibo(int n, int x, int y) {
        if (n == 0)
            return;

        System.out.println(x + y);
        fibo(--n, y, x + y);
    }
}
