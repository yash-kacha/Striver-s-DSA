package step1.lec2pattern;

public class p11 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        int temp = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(temp++ % 2);
            }
            System.out.println();
        }
    }
}
