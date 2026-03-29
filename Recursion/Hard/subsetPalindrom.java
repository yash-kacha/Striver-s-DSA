package Recursion.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class subsetPalindrom {

    public static void main(String[] args) {

        String s = "aabb";
        List<String> ans = new ArrayList<>();

        solvePali(s, ans, 0);
        Collections.sort(ans);
        System.out.println(ans.toString());
    }

    private static void solvePali(String s, List<String> ans, int inx) {

        if (inx >= s.length()) {
            return;
        }

        for (int i = inx; i < s.length(); i++) {
            String sub = s.substring(inx, i + 1);
            if (checkPali(sub)) {
                ans.add(sub);
            }

        }
        solvePali(s, ans, inx + 1);

    }

    private static boolean checkPali(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
