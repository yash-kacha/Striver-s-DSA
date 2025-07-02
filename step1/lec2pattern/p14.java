package step1.lec2pattern;

public class p14 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
