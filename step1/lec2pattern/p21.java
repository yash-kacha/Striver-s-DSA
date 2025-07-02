package step1.lec2pattern;

public class p21 {
    public static void main(String[] args) {
        draw(10);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == n - 1 || i == 0 || j == 0 || j == n - 1)) {

                    System.out.print("*");
                } else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
