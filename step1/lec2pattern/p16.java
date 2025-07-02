package step1.lec2pattern;

public class p16 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        for (char i = 'A'; i <= 'A' + n; i++) {
            for (int j = 'A'; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
