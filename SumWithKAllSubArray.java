
import java.util.*;

public class SumWithKAllSubArray {

    public static List<int[]> printSubarrays(int[] arr, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        List<int[]> ans = new ArrayList<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                for (int startIndex : map.get(prefixSum - k)) {
                    // System.out.println(startIndex);
                    ans.add(Arrays.copyOfRange(arr, startIndex + 1, i + 1));
                }
            }

            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int k = 3;
        for (int[] i : printSubarrays(arr, k)) {
            System.out.println(Arrays.toString(i));
        }
    }
}
