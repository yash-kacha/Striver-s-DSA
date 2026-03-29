package Recursion.Hard;

public class findWord {

    public static void main(String[] args) {
        String s = "ABCCED";

        String[][] hard = {
            {"A", "B", "C", "E"},
            {"S", "F", "C", "S"},
            {"A", "D", "E", "E"}
        };
        System.out.println(isPossible(s, hard));
    }

    private static boolean isPossible(String s, String[][] board) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(s, board, visited, "", i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(String s, String[][] hard, boolean[][] list, String string, int i, int j) {

        if (string.equals(s)) {
            return true;
        }

        int n = list.length;
        int m = list[0].length;

        // boolean flag = false;
        if ((i < 0)
                || (i >= n)
                || (j < 0)
                || (j >= m)
                || (!hard[i][j].equals(s.charAt(string.length()) + ""))
                || list[i][j]) {
            return false;
        }

        string += hard[i][j];

        list[i][j] = true;

        boolean found = ((check(s, hard, list, string, i + 1, j))
                || (check(s, hard, list, string, i - 1, j))
                || (check(s, hard, list, string, i, j - 1))
                || (check(s, hard, list, string, i, j + 1)));

        list[i][j] = false;
        return found;

    }

}
