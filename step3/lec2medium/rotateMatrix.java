package step3.lec2medium;

public class rotateMatrix {
    public static void main(String[] args) {
        int[][] in = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        // brute(in);
        // optimal(in);
        transpose(in);
        rev(in);

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void transpose(int[][] x) {
        int temp;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = x[j][i];
                x[j][i] = x[i][j];
                x[i][j] = temp;
            }
        }
    }

    public static void rev(int[][] x) {
        int temp;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length / 2; j++) {
                temp = x[i][x.length - j - 1];
                x[i][x.length - j - 1] = x[i][j];
                x[i][j] = temp;
            }
        }
    }

}
