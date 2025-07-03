package step3.lec2medium;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] in = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                // { 13, 14, 15, 16 }
        };
        spiral(in);
    }

    public static void spiral(int[][] z) {
        int rb = z[0].length - 1, bb = z.length - 1, lb = 0, tb = 0, x = 0, y = 0;

        while (true) {
            // System.out.println("\n" + rb + " " + lb + " " + bb + " " + tb);
            while (y <= rb) {
                System.out.print(z[x][y] + " ");
                y++;
            }
            y--;
            x++;
            tb++;
            if (rb < lb || bb < tb)
                break;
            // System.out.println("\n" + rb + " " + lb + " " + bb + " " + tb);

            while (x <= bb) {
                System.out.print(z[x][y] + " ");
                x++;
            }
            x--;
            y--;
            rb--;
            if (rb < lb || bb < tb)
                break;
            // System.out.println("\n" + rb + " " + lb + " " + bb + " " + tb);

            while (y >= lb) {
                System.out.print(z[x][y] + " ");
                y--;
            }
            y++;
            x--;
            bb--;
            if (rb < lb || bb < tb)
                break;
            // System.out.println("\n" + rb + " " + lb + " " + bb + " " + tb);

            while (x >= tb) {
                System.out.print(z[x][y] + " ");
                x--;
            }
            x++;
            y++;
            lb++;
            if (rb < lb || bb < tb)
                break;
            // System.out.println("\n" + rb + " " + lb + " " + bb + " " + tb);

        }
    }
}
