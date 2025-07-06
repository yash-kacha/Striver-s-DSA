package string1.medium;

import java.util.ArrayList;
import java.util.List;

public class getAllPermOfString {
    public static void main(String[] args) {
        String in = "Yash";
        List<String> ans = new ArrayList<>();
        perm(in, ans, "");

        for (String s : ans) {
            System.out.println(s);
        }
    }

    public static void perm(String s, List<String> ans, String temp) {

        if (s.length() == 0) {
            ans.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            perm(s.substring(0, i) + s.substring(i + 1), ans, temp + s.charAt(i));
        }
    }
}
