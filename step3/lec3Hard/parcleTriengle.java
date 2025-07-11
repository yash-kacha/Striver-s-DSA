package step3.lec3Hard;

import java.util.*;

public class parcleTriengle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of row : ");
        int n = sc.nextInt();
        // drawBrut(n);

        // for (int i = 1; i <= n; i++) {
        // for (int j = i; j <= n; j++) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= i; j++) {
        // System.out.printf("%8d", drawCord(i - 1, j - 1));

        // }
        // System.out.println();
        // }

        // drawOpti(n);
        for (List<Integer> i : getPascle(n)) {
            System.out.println(i.toString());
        }
    }

    public static void drawBrut(int n) {
        List<Integer> op = new ArrayList<>();

        op.add(1);
        for (int ii = 0; ii <= n; ii++) {
            System.out.print(" ");
        }
        for (int ii : op) {
            System.out.printf("%3d", ii);
        }
        --n;
        System.out.println();

        op.add(1);
        for (int ii = 0; ii <= n; ii++) {
            System.out.print(" ");
        }
        for (int ii : op) {
            System.out.printf("%3d", ii);
        }
        System.out.println();
        List<Integer> temp1 = new ArrayList<>();

        while (n >= 0) {
            temp1.add(1);
            for (int j = 1; j < op.size(); j++) {
                int temp = op.get(j) + op.get(j - 1);
                temp1.add(j, temp);
            }
            temp1.add(1);
            n--;

            op.clear();
            for (int jj : temp1) {
                op.add(jj);
            }
            for (int ii = 0; ii <= n; ii++) {
                System.out.print(" ");
            }
            for (int ii : op) {
                System.out.printf("%3d", ii);
            }
            System.out.println();

            temp1.clear();
        }

    }

    public static int[] fact = new int[1];

    // r >= c ? r : c
    public static int drawCord1(int r, int c) {
        fact[0] = 1;
        int newLen = r >= c ? r : c;
        int oldLen = fact.length;
        if (oldLen <= newLen) {
            int[] fact1 = new int[newLen];
            fact1[0] = 1;
            for (int i = 0; i < oldLen; i++) {
                fact1[i] = fact[i];
            }
            for (int i = oldLen; i < newLen; i++) {
                fact1[i] = fact1[i - 1] * i;
            }
            fact = fact1;
        }

        r--;
        c--;
        return (fact[r] / (fact[c] * fact[r - c]));

    }

    public static long drawCord(int r, int c) {
        long ans = 1;
        for (long i = 0; i < c; i++) {
            ans *= (r - i);
            ans /= (i + 1);
        }

        return ans;

    }

    public static List<Integer> drawOpti(int n) {
        // for (int i = 1; i < n; i++) {
        List<Integer> op = new ArrayList<>();
        op.add(1);

        int temp = 1;
        for (int j = 1; j < n; j++) {
            temp *= n - j;
            temp /= j;
            op.add(temp);
        }
        // op.add(1);

        // System.out.println("1");
        return op;
        // }
    }

    public static List<List<Integer>> getPascle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(drawOpti(i));
        }
        return ans;
    }

}
