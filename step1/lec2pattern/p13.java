package step1.lec2pattern;

public class p13 {
    public static void main(String[] args) {
        draw(5);
    }

    public static void draw(int n) {
        int temp = 1;
        for (int i = 0; i < n; i++) {
            for (char j = 0; j <= i; j++) {
                System.out.print(temp++ + " ");
            }
            System.out.println();
        }
    }
}
