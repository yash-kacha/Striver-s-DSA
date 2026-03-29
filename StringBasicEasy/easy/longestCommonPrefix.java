package easy;

public class longestCommonPrefix {

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flower"};

        System.out.println(lcp(str));
    }

    private static String lcp(String[] str) {
        int n = str.length;

        int m = str[0].length();

        for (int i = 0; i <= m; i++) {
            if (i == m) {
                return str[0];
            }
            char cu = str[0].charAt(i);
            for (int j = 0; j < n; j++) {
                if (i >= str[j].length() || str[j].charAt(i) != cu) {
                    return str[0].substring(0, i);
                }
            }
        }
        return "p";

    }
}
