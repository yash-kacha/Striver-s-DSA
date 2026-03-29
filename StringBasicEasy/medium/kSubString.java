package medium;

import java.util.HashSet;
import java.util.Set;

public class kSubString {

    public static void main(String[] args) {
        String s = "abcbaa";
        int k = 2;

        System.out.println("k : " + sub(s, k));
    }

    private static int sub(String s, int k) {
        int lp = 0;
        int rp = lp + k;
        int ans = 0;
        while (rp <= s.length() && lp < rp) {
            System.out.println("issue");
            System.out.println(lp + " :: " + rp);
            if (getfq(s.substring(lp, rp)) > k) {
                lp++;
            } else if (getfq(s.substring(lp, rp)) < k) {
                rp++;
            } else {
                rp++;
                ans += 1;
            }

        }
        return ans;
    }

    private static int getfq(String substring) {
        Set<Character> st = new HashSet<>();

        for (char ch : substring.toCharArray()) {
            st.add(ch);
        }
        return st.size();

    }

}
