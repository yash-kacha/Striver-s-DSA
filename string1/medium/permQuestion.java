package string1.medium;

public class permQuestion {
    public static void main(String[] args) {
        String in = "56? + 80 = 6?0";

        System.out.println(comp(in));
    }

    public static String comp(String s) {
        char sign = '+';
        String str1 = "";
        String str2 = "";
        String str3 = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '=') {
                str1 = s.substring(0, i - 1);
                str3 = s.substring(i + 2, s.length());
                break;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                str2 = str1.substring(i + 2, str1.length());
                str1 = str1.substring(0, i - 1);
                sign = s.charAt(i);
                break;
            }
        }

        for (int i = 0; i <= 9; i++) {
            int lhs = opration(perm(str1, i), perm(str2, i), sign);
            for (int j = 0; j <= 9; j++) {
                int rhs = perm(str3, j);

                if (lhs == rhs)
                    return i + " " + j;
            }

        }
        return "Not possible";
    }

    public static int opration(int in1, int in2, char sign) {
        switch (sign) {
            case '+':
                return in1 + in2;
            case '-':
                return in1 - in2;
            case '*':
                return in1 * in2;
            case '/':
                return in1 / in2;
            default:
                return 0;
        }
    }

    public static int perm(String s, int num) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                return Integer.parseInt((s.substring(0, i) + num + s.substring(i + 1, s.length())));
            }
        }

        return Integer.parseInt(s);

    }

}
