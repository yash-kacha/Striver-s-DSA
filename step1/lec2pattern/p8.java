package step1.lec2pattern;

public class p8 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
