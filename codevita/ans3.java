package codevita;

import java.util.*;

public class ans3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] tokens = line.split("\\s+");
            for (int j = 0; j < m; j++) {
                grid[i][j] = tokens[j].charAt(0);
            }
        }

        sc.close();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] ogStarter = { i, j };
                int ogDir = 0;
                int dirStarted = 0;
                int[] cord = { i, j };
                int tempAns = 1;
                int direction = 0;
                int err = 0;

                while (cord[0] >= 0 && cord[0] < n && cord[1] >= 0 && cord[1] < m) {
                    if (grid[cord[0]][cord[1]] == '/') {
                        if (direction == 0 || direction == 2)
                            direction = 1;
                        else if (direction == 1)
                            direction = 0;
                        else if (direction == -1)
                            direction = -2;
                        else if (direction == -2)
                            direction = -1;
                        changeCord(cord, direction);
                        tempAns++;
                    } else if (grid[cord[0]][cord[1]] == '\\') {
                        if (direction == 0 || direction == -2)
                            direction = 1;
                        else if (direction == 1)
                            direction = -2;
                        else if (direction == 2)
                            direction = -1;
                        else if (direction == -1)
                            direction = 2;
                        changeCord(cord, direction);
                        tempAns++;
                    }

                    else if (grid[cord[0]][cord[1]] == '0' && direction == 0) {
                        break;
                    } else if (grid[cord[0]][cord[1]] == '0') {
                        changeCord(cord, direction);
                        tempAns++;
                    }

                    if (Arrays.equals(cord, ogStarter) && direction == dirStarted) {
                        ans = Math.max(ans, tempAns);
                        break;
                    }
                }
            }

        }
        System.out.println("ANS  " + (ans));
    }

    public static void changeCord(int[] cord, int direction) {
        if (direction == -1)
            cord[1]--;
        if (direction == 1)
            cord[1]++;
        if (direction == -2)
            cord[0]++;
        if (direction == 2)
            cord[0]--;

    }
}
