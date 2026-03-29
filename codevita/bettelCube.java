package codevita;

import java.util.Arrays;

public class bettelCube {
    public static void main(String[] args) {

        int[] point = { 1, 1, 10, 2, 1, 10, 0, 5, 9 };
        /*
         * 1 1 10 x y
         * 2 1 10 x y
         * 0 1 9 y z
         */
        int n = 3;

        System.out.println(distance(point, n));
    }

    public static double distance(int[] point, int n) {
        int[][] points = new int[n][3];

        int pointer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = point[pointer++];
            }

        }
        double ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += findDistance(points[i], points[i + 1]);
        }
        return ans;
    }

    public static double findDistance(int[] point1, int[] point2) {
        if ((point1[0] == point2[0] && (point1[0] == 0 || point1[0] == 10))
                || (point1[1] == point2[1] && (point1[1] == 0 || point1[1] == 10))
                || (point1[2] == point2[2] && (point1[2] == 0 || point1[2] == 10))) {
            double temp = disSamePlane(point1, point2);
            System.out.println("for points : " + Arrays.toString(point1) + " and : " + Arrays.toString(point2)
                    + " that are on same plane distance is : " + temp);
            return temp;
        } else {
            double temp = disDiffPlane(point1, point2);
            System.out.println("for points : " + Arrays.toString(point1) + " and : " + Arrays.toString(point2)
                    + " that are on diffrant plane distance is : " + temp);

            return temp;
        }
    }

    public static double disSamePlane(int[] point1, int[] point2) {
        double xd = point1[0] - point2[0];
        double yd = point1[1] - point2[1];
        double zd = point1[2] - point2[2];

        xd *= xd;
        yd *= yd;
        zd *= zd;

        double temp = ((Math.PI / 3) * (Math.sqrt(xd + yd + zd)));
        // return temp;
        return Math.round(temp * 100.0) / 100.0;
    }

    public static double findDistand2d(int x1, int y1, int x2, int y2) {
        double xd = x2 - x1;
        double yd = y2 - y1;

        xd *= xd;
        yd *= yd;

        return (Math.sqrt(xd + yd));
    }

    public static double disDiffPlane(int[] point1, int[] point2) {

        int x1 = point1[0], y1 = point1[1], z1 = point1[2];
        int x2 = point2[0], y2 = point2[1], z2 = point2[2];

        if (z1 == 10 || z2 == 10) {
            // xy plane
            if (z2 == 10) {
                int[] temp = point1;
                point1 = point2;
                point2 = temp;

                x1 = point1[0];
                y1 = point1[1];
                z1 = point1[2];
                x2 = point2[0];
                y2 = point2[1];
                z2 = point2[2];
            }

            // yz plane x=0
            if (x2 == 0) {
                System.out.println("getting called ++++++++++++");
                return findDistand2d(x1, y1, (z2 - 10), y2);
                // 2 1 -1 1
            }
            // yz plane x=10
            else if (x2 == 10) {
                return findDistand2d(x1, y1, (20 - z2), y2);
            }
            // xz plane y=0
            else if (y2 == 0) {
                return findDistand2d(x1, y1, x2, (z2 - 10));
            }

            // xz plane y=10
            else if (y2 == 10) {
                return findDistand2d(x1, y1, x2, (20 - z2));
            }

        }

        else if (y1 == 0 || y2 == 0) {

            // xz y==0
            if (y2 == 0) {
                int[] temp = point1;
                point1 = point2;
                point2 = temp;

                x1 = point1[0];
                y1 = point1[1];
                z1 = point1[2];
                x2 = point2[0];
                y2 = point2[1];
                z2 = point2[2];
            }

            // yz x==0
            if (x2 == 0) {
                return findDistand2d(x1, z1, (-y2), z2);
            } else if (x2 == 10) {
                return findDistand2d(x1, z1, (10 + y2), z2);
            }

        }

        else if (y1 == 10 || y2 == 10) {
            // xz y==0
            if (y2 == 10) {
                int[] temp = point1;
                point1 = point2;
                point2 = temp;

                x1 = point1[0];
                y1 = point1[1];
                z1 = point1[2];
                x2 = point2[0];
                y2 = point2[1];
                z2 = point2[2];
            }

            // yz x==0
            if (x2 == 0) {
                return findDistand2d(x1, z1, (y2 - 10), z2);
            } else if (x2 == 10) {
                return findDistand2d(x1, z1, (20 - y2), z2);
            }

        }

        else if (x1 == 0 || x2 == 0) {

            // yz x==0
            if (x2 == 0) {
                int[] temp = point1;
                point1 = point2;
                point2 = temp;

                x1 = point1[0];
                y1 = point1[1];
                z1 = point1[2];
                x2 = point2[0];
                y2 = point2[1];
                z2 = point2[2];
            }

            // yz x==0
            if (y2 == 0) {
                return findDistand2d(x2, z2, (-y1), z1);

            } else if (y2 == 10) {
                return findDistand2d(x2, z2, (y1 - 10), z1);
            }

        }

        else if (x1 == 10 || x2 == 10) {
            // yz x==10
            if (x2 == 10) {
                int[] temp = point1;
                point1 = point2;
                point2 = temp;

                x1 = point1[0];
                y1 = point1[1];
                z1 = point1[2];
                x2 = point2[0];
                y2 = point2[1];
                z2 = point2[2];
            }

            // yz x==0
            if (y2 == 0) {
                return findDistand2d(x2, z2, (10 + y1), z1);
            } else if (y2 == 10) {
                return findDistand2d(x2, z2, (20 - y1), z1);
            }

        }
        return 0;
    }

}
