package NQT.prev_2025;

import java.util.Scanner;

public class sunday {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("ENter plz : ");
        String sd = sc.nextLine();

        int day = sc.nextInt();
        int sdd
                = sd == "mon" ? 1
                        : sd == "tue" ? 2
                                : sd == "wed" ? 3
                                        : sd == "thu" ? 4
                                                : sd == "fri" ? 5
                                                        : sd == "sat" ? 6
                                                                : 0;

        int ans = 0;
        while (day-- >= 0) {
            if (sdd++ % 7 == 0) {
                ans++;
            }

        }
        System.out.println(ans);

    }
}
