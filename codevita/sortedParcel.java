package codevita;

import java.util.*;

public class sortedParcel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        target--;

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(giveOptimal(arr, target));
    }

    public static int giveOptimal(int[] arr, int target) {

        for (List<Integer> i : giveCycle(arr, targetArr(arr, target))) {
            System.out.println(i.toString());
        }

        return 0;
    }

    public static int[] targetArr(int[] arr, int target) {
        int n = arr.length;
        int[] ans = Arrays.copyOf(arr, n);

        Arrays.sort(ans);
        int temp = ans[n - 1];
        for (int i = n - 2; i >= target; i--) {
            ans[i + 1] = ans[i];
        }
        ans[target] = temp;
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static List<List<Integer>> giveCycle(int[] arr, int[] target) {
        int n = arr.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(target[i], i);
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> cycles = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!visited[i] && arr[i] != target[i]) {
                List<Integer> cycle = new ArrayList<>();
                int cur = i;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cycle.add(cur);
                    cur = pos.get(arr[cur]); // where arr[cur] should go
                }
                if (cycle.size() > 1) {
                    cycles.add(cycle);
                }
            }

        }

        for (int i = 0; i < cycles.size(); i++) {
            List<Integer> temp = cycles.get(i);
            for (int j = 0; j < temp.size(); j++) {

            }
        }
        return cycles;
    }

}
