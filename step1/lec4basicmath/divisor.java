package step1.lec4basicmath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class divisor {
    public static void main(String[] args) {
        for (Integer i : div(36)) {
            System.out.println(i);
        }
    }

    public static List<Integer> div(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans.add(i);
                ans.add(n / i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
