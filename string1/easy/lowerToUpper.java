package string1.easy;

public class lowerToUpper {
    public static void main(String[] args) {
        String s = "ABCDE";

        System.out.println(upperLower(s));
        System.out.println(lowerUpper("abcde"));

    }

    public static String upperLower(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans += ((char) (s.charAt(i) + ('a' - 'A')));
        }
        return ans;
    }

    public static String lowerUpper(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans += ((char) (s.charAt(i) - ('a' - 'A')));
        }
        return ans;
    }
}
