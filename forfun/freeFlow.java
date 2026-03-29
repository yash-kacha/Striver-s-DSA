package forfun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class freeFlow {

    public static void main(String[] args) {
        int[][] in
                = {
                    {3, 3, 0, 0},
                    {2, 0, 1, 0},
                    {0, 0, 2, 0},
                    {0, 0, 0, 1},};
        int n = 3;
        solveFlow(in, n);
        // for (int[] i : in) {
        //     System.out.println(Arrays.toString(i));
        // }

    }

    private static boolean solveFlow(int[][] in, int n) {
        List<List<Pair>> init = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            init.add(new LinkedList<>());
        }
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                int curr = in[i][j];
                if (curr == 0) {
                    continue;
                }
                init.get(curr - 1).add(new Pair(i, j));
            }
        }
        // for (List<Pair> ip : init) {
        //     System.out.println(ip.toString());
        // }

        init = init.stream().sorted((a, b) -> (getDist(a.get(0), a.get(1)) - getDist(b.get(0), b.get(1)))).toList();

        return solveNextColor(0, init, in);
    }

    public static boolean solveNextColor(
            int colorIndex,
            List<List<Pair>> colors,
            int[][] board
    ) {
        if (colorIndex == colors.size()) {
            return notZ(board);
        }

        int startI = colors.get(colorIndex).get(0).i;
        int startJ = colors.get(colorIndex).get(0).j;

        int endI = colors.get(colorIndex).get(1).i;
        int endJ = colors.get(colorIndex).get(1).j;

        if (connectPath(startI, startJ, endI, endJ, board[startI][startJ], board)) {
            solveNextColor(colorIndex + 1, colors, board);
        } else {

        }
    }

    public static boolean connectPath(
            int r,
            int c,
            int endR,
            int endC,
            int color,
            int[][] board
    ) {

        if (r == endR && c == endC) {
            return true;
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},};

        for (int[] dirr : dir) {
            if (isValidMove(r + dirr[0], c + dirr[1], endR, endC, color, board)) {
                board[r + dirr[0]][c + dirr[1]] = color;
                if (connectPath(r + dirr[0], c + dirr[1], endR, endC, color, board)) {
                    return true;
                }
                board[r + dirr[0]][c + dirr[1]] = 0;

            }
        }
        return false;

    }

    static boolean isValidMove(
            int nextR,
            int nextC,
            int endR,
            int endC,
            int color,
            int[][] board
    ) {
        if (!(isInsideBoard(endR, endC, board) && (board[nextR][nextC] == 0 || board[nextR][nextC] == color))) {
            return false;
        }
        return true;

    }

    static boolean createsDeadCell(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {

                    int[][] dir = {
                        {1, 0},
                        {-1, 0},
                        {0, 1},
                        {0, -1},};

                    boolean cnt = false;

                    for (int[] dirr : dir) {
                        if (isInsideBoard(i + dirr[0], j + dirr[1], board) && board[i + dirr[0]][j + dirr[1]] == 0) {
                            cnt = true;
                        }

                    }
                    if (!cnt) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean blocksOtherEndpoints(
            int[][] board,
            List<List<Pair>> colors,
            int currentColorIndex
    ) {
        for (int i = 0; i < colors.size(); i++) {
            if (i == currentColorIndex) {
                continue;
            }

            for (Pair p : colors.get(i)) {
                int[][] dir = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1},};

                boolean cnt = false;

                for (int[] dirr : dir) {
                    if (isInsideBoard(p.i + dirr[0], p.j + dirr[1], board) && board[p.i + dirr[0]][p.j + dirr[1]] == 0) {
                        cnt = true;
                    }

                }
                if (!cnt) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isInsideBoard(int r, int c, int[][] board) {
        return !(r < 0 || c < 0 || r >= board.length || c >= board.length);
    }

    public static boolean notZ(int[][] arr) {
        return !Arrays.stream(arr).flatMapToInt(Arrays::stream).anyMatch(a -> a == 0);
    }

    // public static boolean isValid(int[][] arr, int i, int j) {
    //     if (i >= arr.length || j >= arr.length  || i < 0 || j < 0) {
    //         return false;
    //     }
    //     return true;
    // }
    public static int getDist(Pair p1, Pair p2) {
        return Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j);
    }

}

class Pair {

    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "[ i=" + i + " , j=" + j + " ]";
    }

}
