package step1.lec2pattern;

public class p18 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = n - 1; i >= 0; i--) {

            for (char j = (char) ('A' + i); j <= 'A' + n - 1; j++) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
