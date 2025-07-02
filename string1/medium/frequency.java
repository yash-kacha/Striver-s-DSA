package string1.medium;

public class frequency {
    public static void main(String[] args) {
        hz("yash is a very good boy he loves zinal");
    }

    public static void hz(String s) {

        int[] hash = new int[256];

        for (int i = 0; i < s.length(); i++) {
            hash[(int) s.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (hash[i] > 0) {
                System.out.println(((char) i) + " : " + hash[i]);
            }
        }
    }

}
