package string1.easy;

import java.util.Scanner;

public class palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String in = sc.nextLine();

        if (checkpali2(in))
            System.out.println("String is palindrom");
        else
            System.out.println("String is not palindrom");
    }

    public static boolean checkPeli(String s) {
        s = s.toLowerCase();
        String refine = "";
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ((curr <= 'z' && curr >= 'a') || (curr <= '9' && curr >= '0')) {
                refine += curr;
            }
        }

        for (int i = 0; i < refine.length() / 2; i++) {
            if (refine.charAt(i) != refine.charAt(refine.length() - i - 1))
                return false;
        }
        return true;
    }

    public static boolean checkpali2(String s) {
        s = s.toLowerCase();
        int lp = 0, rp = s.length() - 1;
        char lc, rc;
        while (lp < rp) {
            lc = s.charAt(lp);
            rc = s.charAt(rp);

            while (!((lc <= 'z' && lc >= 'a') || (lc >= '9') && lc <= '0') && lp < s.length() - 1) {
                lp++;
                lc = s.charAt(lp);
            }
            while (!((rc <= 'z' && rc >= 'a') || (rc >= '9') && rc <= '0') && rp >= 1) {
                rp--;
                rc = s.charAt(rp);
            }

            if (((rc > 'z' || rc < 'a') || (rc > '9') && rc < '0')
                    && ((lc > 'z' || lc < 'a') || (lc > '9') && lc < '0'))
                return true;
            System.out.println("lc :" + lc + "   rc : " + rc);

            if (lc != rc)
                return false;
            lp++;
            rp--;
        }
        return true;
    }
}
