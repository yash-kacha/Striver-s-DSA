package step1.lec2pattern;

public class p6 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
