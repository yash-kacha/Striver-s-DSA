package easy;

public class largestOddNumber {

    public static void main(String[] args) {

        String in = "0214638";
        System.out.println("largest is : " + largest(in));

    }

    private static String largest(String in) {
        int n = in.length() - 1;

        int b = 0, e = n;

        for (int i = n; i >= 0; i--) {
            char c = in.charAt(i);
            if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
                e = i;
                break;
            }
        }

        for (int i = 0; i <= e; i++) {
            char c = in.charAt(i);
            if (c != '0') {
                b = i;
                break;
            }
        }
        return in.substring(b, e + 1);
    }
}
