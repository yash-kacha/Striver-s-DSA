package step1.lec2pattern;

public class p15 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
