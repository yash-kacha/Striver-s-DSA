package step3.lec2medium;

public class setMatrixZeros {
    public static void main(String[] args) {
        int[][] in = {
                { 1, 1, 0, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };

        // brute(in);
        // optimal(in);

        best(in);
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }

    }

    // a= -a
    // 1 - > -1
    // 0 0

    public static void brute(int[][] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                if (in[i][j] == 0) {
                    for (int ii = 0; ii < in.length; ii++) {
                        if (in[ii][j] == -1)
                            ;
                        else
                            in[ii][j] = -1 * in[ii][j];
                    }
                    for (int jj = 0; jj < in[0].length; jj++) {
                        if (in[i][jj] == -1)
                            ;
                        else
                            in[i][jj] = -1 * in[i][jj];
                    }
                }
            }
        }

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                if (in[i][j] < 0) {
                    in[i][j] = 0;
                }
            }
        }
    }

    public static void best(int[][] x) {
        int col1 = 1;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {

                if (x[i][j] == 0) {
                    x[i][0] = 0;

                    if (j == 0)
                        col1 = 0;
                    else
                        x[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < x[0].length; j++) {

                if (x[i][0] == 0 || x[0][j] == 0) {
                    x[i][j] = 0;
                }
            }
        }

        if (x[0][0] == 0) {
            for (int j = 1; j < x[0].length; j++) {
                x[0][j] = 0;
            }
        }

        if (col1 == 0) {
            for (int j = 0; j < x.length; j++) {
                x[j][0] = 0;
            }
        }

    }

    public static void optimal(int[][] x) {
        boolean[] row = new boolean[x.length];
        boolean[] col = new boolean[x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {

                if (x[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {

                if (row[i] || col[j]) {
                    x[i][j] = 0;
                }
            }
        }

    }
}
