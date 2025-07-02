package step1.lec2pattern;

public class p2 {

    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
