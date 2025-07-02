package step1.lec2pattern;

public class p19 {
    public static void main(String[] args) {
        draw(10);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if ((j - i < n / 2) && (i - j < n / 2) && (i + j >= n / 2) && (i + j < (n *
                        1.5) - 1))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println();
        }
    }
}
