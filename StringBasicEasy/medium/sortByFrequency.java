package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import easy.anagram;

public class sortByFrequency {

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(sbf(s));
    }

    private static String sbf(String s) {
        int[] s1 = count(s);
        String ans = "";
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] > 0) {
                m1.put(i, s1[i]);
            }
            // m1.put(i, s1[i]);
        }
        Map<Integer, Integer> descendingOrder
                = m1.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

        for (Map.Entry<Integer, Integer> en : descendingOrder.entrySet()) {
            Object key = en.getKey();
            Object val = en.getValue();

            for (int i = 0; i < (int) val; i++) {
                ans += ((char) (int) key) + "";
            }
        }
        return ans;
    }

    public static int[] count(String s) {
        int[] ans = new int[256];

        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i)]++;
        }
        return ans;
    }
}
