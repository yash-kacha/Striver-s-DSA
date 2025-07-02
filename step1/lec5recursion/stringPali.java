package step1.lec5recursion;

public class stringPali {
    public static void main(String[] args) {
        System.out.println(pali(")(()", 0));
    }

    public static boolean pali(String s, int i) {

        if (i >= s.length() / 2)
            return true;

        if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
            return pali(s, ++i);
        } else {
            return false;
        }
    }
}
