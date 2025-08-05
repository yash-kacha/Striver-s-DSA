package codevita;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        int srcR = sc.nextInt(), srcC = sc.nextInt();
        int destR = sc.nextInt(), destC = sc.nextInt();
        int dx = sc.nextInt(), dy = sc.nextInt();

        int result = bfs(grid, M, N, srcR, srcC, destR, destC, dx, dy);
        System.out.println(result);
    }

    public static int bfs(int[][] grid, int M, int N, int sr, int sc, int dr, int dc, int dx, int dy) {

        int[][] directions = {
                { dx, dy },
                { dy, -dx },
                { -dy, dx },
                { -dx, -dy }
        };

        boolean[][] visited = new boolean[M][N];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { sr, sc, 0 });
        visited[sr][sc] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0], c = curr[1], steps = curr[2];
            if (r == dr && c == dc)
                return steps;

            for (int[] op : directions) {
                int nr = r + op[0];
                int nc = c + op[1];

                if (nr < M && nc < N && nr >= 0 && nc >= 0 && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc, steps + 1 });
                }

            }

        }

        return -1;
    }
}
