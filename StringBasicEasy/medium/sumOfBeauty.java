package medium;

import java.util.HashMap;
import java.util.Map;

public class sumOfBeauty {

    public static void main(String[] args) {
        String s = "aabcbaa";

        System.out.println(beauty(s));
    }

    private static int beauty(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> m1 = new HashMap<>();

            for (int j = i; j < n; j++) {
                char curr = s.charAt(j);
                m1.put(curr, m1.getOrDefault(curr, 0) + 1);

                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int val : m1.values()) {
                    if (val < min) {
                        min = val;
                    }
                    if (val > max) {
                        max = val;
                    }
                }
                ans += max - min;
            }

        }
        return ans;
    }
}
