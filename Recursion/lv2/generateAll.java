package Recursion.lv2;

import java.util.*;

public class generateAll {

    public static void main(String[] args) {
        int n = 3;

        System.out.println(generate(3).toString());
    }

    public static List<String> generate(int n) {
        List<String> n1 = new ArrayList<>();

        recur(n, "", n1);

        return n1;
    }

    public static void recur(int n, String curr, List<String> s1) {
        if (n == 0) {
            s1.add(curr);
            return;
        }
        recur(n - 1, curr + "0", s1);
        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            recur(n - 1, curr + "1", s1);
        }

    }
}
