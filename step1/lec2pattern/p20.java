package step1.lec2pattern;

public class p20 {
    public static void main(String[] args) {
        draw(10);
    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            if (i == n / 2)
                continue;
            for (int j = 0; j < n; j++) {
                // System.out.print("(" + (i) + "," + (j) + ") ");

                if (((i < n / 2) && (i >= j || j + i + 1 >= n)) || ((i >= n / 2) && (j >= i || j + i + 1 <= n))) {

                    System.out.print("*");
                } else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
