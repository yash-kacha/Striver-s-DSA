package easy;

public class reverrseWordOrder {

    public static void main(String[] args) {
        String in = "Hello world my name is op";
        System.out.println("rev is : " + revWord(in));
    }

    private static String revWord(String in) {
        int last = 0;
        int size = in.length();
        String p = "";
        for (int i = 0; i < size; i++) {
            if (in.charAt(i) == ' ') {
                System.out.println(in.substring(last, i));
                p += rev(in.substring(last, i)) + " ";
                last = i + 1;
            }
        }
        p += rev(in.substring(last, size));

        return rev(p);
    }

    private static String rev(String substring) {

        int size = substring.length();
        StringBuilder sb = new StringBuilder(substring);
        sb.reverse();

        return sb.toString();
    }

}
