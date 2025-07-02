package step1.lec2pattern;

public class p10 {
    public static void main(String[] args) {
        draw(5);
        draw2(5);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void draw2(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
