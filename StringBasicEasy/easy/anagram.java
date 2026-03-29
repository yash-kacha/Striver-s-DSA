package easy;

public class anagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(checkAna(s, t));
    }

    private static boolean checkAna(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }

        int[] s1 = count(s);
        int[] s2 = count(t);
        for (int i = 0; i < 256; i++) {

            if ((s1[i] ^ s2[i]) != 0) {
                return false;
            }
        }
        return true;

    }

    public static int[] count(String s) {
        int[] ans = new int[256];

        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i)]++;
        }
        return ans;
    }
}
