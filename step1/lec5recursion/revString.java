package step1.lec5recursion;

public class revString {
    public static void main(String[] args) {
        String in = "yash is op";
        System.out.println("rev string is : " + rev(in, in.length() - 1));
    }

    public static String rev(String s, int i) {
        if (i < 0)
            return "";
        return s.charAt(i) + rev(s, --i);
    }
}
