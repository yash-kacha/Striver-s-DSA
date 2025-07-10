package step3.lec3Hard;

import java.util.*;

public class parcleTriengle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row : ");
        int n = sc.nextInt();
        draw(n);
    }

    public static void draw(int n) {
        List<Integer> op = new ArrayList<>();

        op.add(1);
        op.add(1);
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
            System.out.println(op.toString());
            temp1.clear();
        }

    }
}
