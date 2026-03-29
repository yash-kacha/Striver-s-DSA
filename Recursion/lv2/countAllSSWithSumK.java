package Recursion.lv2;

import java.util.*;

public class countAllSSWithSumK {

    public static void main(String[] args) {
        List<Integer> n1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        int k = 8;
        for (List<Integer> i : solve(n1, k)) {
            System.out.println(i.toString());
        }
    }

    private static List<List<Integer>> solve(List<Integer> n1, int k) {

        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getans(l1, n1, k, temp, 0, 0);
        return l1;
    }

    private static void getans(List<List<Integer>> l1, List<Integer> n1, int k, List<Integer> temp, int i, int sum) {
        if (sum == k) {
            l1.add(new ArrayList<>(temp));
            return;
        }
        if (i == n1.size() || sum > k) {
            return;
        }

        temp.add(n1.get(i));
        getans(l1, n1, k, temp, i + 1, sum + n1.get(i));
        temp.removeLast();
        getans(l1, n1, k, temp, i + 1, sum);

    }
}
