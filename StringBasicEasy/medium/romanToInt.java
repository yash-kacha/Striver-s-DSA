package medium;

public class romanToInt {

    public static void main(String[] args) {
        String s = "LVIII";

        System.out.println(rToI(s));
        System.out.println(iToR(999));
    }

    private static int rToI(String s) {
        int ans = 0;

        int temp = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = cToI(s.charAt(i));
            int next = cToI(s.charAt(i + 1));
            // System.out.printf("\ncurr : %d , next : %d", curr, next);
            if (curr > next) {
                ans += curr + temp;
                temp = 0;
            } else if (curr == next) {
                temp += curr;
            } else {
                ans -= (curr + temp);
                temp = 0;
            }
        }
        ans += cToI(s.charAt(s.length() - 1)) + temp;
        return ans;
    }

    public static int cToI(char ch) {
        return switch (ch) {
            case 'I' ->
                1;
            case 'V' ->
                5;
            case 'X' ->
                10;
            case 'L' ->
                50;
            case 'C' ->
                100;
            case 'D' ->
                500;
            case 'M' ->
                1000;
            default ->
                0;
        }; // for invalid characters
    }

    private static String iToR(int num) {
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

}
