package Recursion.lv2;

import java.util.*;

public class allSubString {

    public static void main(String[] args) {
        String str = "abc";

        System.out.println(generate(str).toString());
    }

    public static List<String> generate(String str) {
        List<String> n1 = new ArrayList<>();

        recur(str, "", n1);

        Set s1 = new HashSet<>(n1);
        n1 = new ArrayList<>(s1);
        Collections.sort(n1);
        return n1;
    }

    public static void recur(String str, String curr, List<String> s1) {
        if (str.length() == 0) {

            return;
        }
        String next = curr + str.charAt(0);
        s1.add(next);               // ⭐ THE missing line

        recur(str.substring(1), next, s1);
        recur(str.substring(1), "", s1);

        // recur(str.substring(1), curr + str.charAt(0), s1);
        // recur(str.substring(1), curr, s1);
    }
}
