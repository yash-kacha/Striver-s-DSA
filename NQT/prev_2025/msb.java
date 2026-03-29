package NQT.prev_2025;

import java.util.Scanner;

public class msb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int msb = Integer.highestOneBit(n);
        int mask = (msb << 1) - 1;
        int result = n ^ mask;
        System.out.println(n);
    }
}
