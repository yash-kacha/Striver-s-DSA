
import java.util.HashMap;
import java.util.Map;

public class SumWithK {

    public static void main(String[] args) {
        int[] in = {1, 2, 1, 3, 4, 5, 6, 7, 8, 9};
        int sum = 8;

        System.out.println(solveForK(in, sum));

    }

    private static int solveForK(int[] in, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        map.put(0, 1);

        for (int i = 0; i < in.length; i++) {
            prefixSum += in[i];

            int rm = prefixSum - sum;
            if (map.containsKey(rm)) {
                ans += map.get(rm);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }
}
