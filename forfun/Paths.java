package forfun;

import java.util.LinkedList;
import java.util.Queue;

public class Paths {
    public static void main(String[] args) {
        Paths path = new Paths();
        System.out.println("total paths : " + path.countPath(4));
    }

    public int countPath(int n) {
        int ans = 0;
        Queue<cord> list = new LinkedList<>();

        list.add(new cord(1, 1));

        while (!list.isEmpty()) {
            int x = list.peek().getx();
            int y = list.peek().gety();
            list.poll();

            if (x == n && y == n) {
                ans++;
                continue;
            }

            if (x < 6) {
                list.add(new cord(x + 1, y));
            }
            if (y < 6) {
                list.add(new cord(x, y + 1));
            }

        }
        return ans;

    }

    public class cord {
        int x;
        int y;

        cord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getx() {
            return x;
        }

        public int gety() {
            return y;
        }

        public void setx(int x) {
            this.x = x;
        }

        public void sety(int y) {
            this.y = y;
        }
    }

}
