package medium;

public class longestPali {

    public static void main(String[] args) {
        String s = "cbbd";

        System.out.println(longPali(s));
    }

    private static String longPali(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = givelen(s, i, i);
            int even = givelen(s, i, i + 1);

            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int givelen(String s, int i, int i2) {
        while (i >= 0 && i2 < s.length() && s.charAt(i2) == s.charAt(i)) {
            i--;
            i2++;
        }
        return i2 - i - 1;
    }
}
