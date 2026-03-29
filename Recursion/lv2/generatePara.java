package Recursion.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class generatePara {

    public static void main(String[] args) {
        int n = 4;

        System.out.println(generate(n).toString());
    }

    public static List<String> generate(int n) {
        Set<String> n1 = new HashSet<>();

        recur(n, n, "", n1);

        List<String> result = new ArrayList<>(n1);
        Collections.sort(result);
        return result;
    }

    public static void recur(int n, int m, String curr, Set<String> s1) {
        if (n == 0 && m == 0) {
            s1.add(curr);
            return;
        }

        if (n >= 0) {
            recur(n - 1, m, curr + "(", s1);

        }

        if (m > n && m >= 0) {
            recur(n, m - 1, curr + ")", s1);
        }

        if (n == 0 && m > 0) {
            recur(n, m - 1, curr + ")", s1);
        }

    }

}
