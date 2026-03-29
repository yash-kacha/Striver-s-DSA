package Recursion.lv2;

import java.util.ArrayList;
import java.util.List;

public class phoneNumber {

    public static void main(String[] args) {
        String digits = "7";

        List<String> result = new ArrayList<>();
        solve(digits, result, "", 0);
        System.out.println(result.toString());
    }

    private static void solve(String digits, List<String> result, String temp, int inx) {

        if (temp.length() == digits.length()) {
            result.add(temp);
            return;
        }
        char curr = digits.charAt(inx);

        String str = getString(curr - '0');

        for (char ch : str.toCharArray()) {
            solve(digits, result, temp + ch, inx + 1);
        }
    }

    public static String getString(int n) {
        return switch (n) {
            case 2 ->
                "abc";
            case 3 ->
                "def";
            case 4 ->
                "ghi";
            case 5 ->
                "jkl";
            case 6 ->
                "mno";
            case 7 ->
                "pqrs";
            case 8 ->
                "tuv";
            case 9 ->
                "wxyz";
            default ->
                "";
        };
    }
}
