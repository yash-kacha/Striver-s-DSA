package step1.lec2pattern;

public class p22 {
    public static void main(String[] args) {
        System.out.println("\n");
        draw(8);
        System.out.println("\n");
        draw2(8);
    }

    public static void draw(int n) {
        for (int i = 0; i < n * 2 - 1; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                // System.out.print("(" + (i) + "," + (j) + ") ");
                System.out.print(Math.max((Math.abs(i - (n - 1))), (Math.abs(j - (n - 1)))) + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void draw2(int n) {
        for (int i = 0; i < n * 2 - 1; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                // System.out.print("(" + (i) + "," + (j) + ") ");
                System.out
                        .print(Math.abs(Math.max((Math.abs(i - (n - 1))), (Math.abs(j - (n - 1)))) - n + 1) + " ");
            }
            System.out.println();
        }
    }
}
