package step1.lec6hash;

import java.util.HashMap;
import java.util.Map;

public class countINArr {
    public static void main(String[] args) {
        hz(new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 6, 6, 6, 6, 7, 8, 9, 0 });
    }

    public static Map<Integer, Integer> hz(int[] n) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int i = 0; i < n.length; i++) {
            if (ans.containsKey(n[i])) {
                ans.put(n[i], ans.get(n[i]) + 1);
            } else {
                ans.put(n[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return ans;
    }
}
