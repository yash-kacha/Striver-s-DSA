package Recursion.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pickCombination {

    public static void main(String[] args) {
        List<Integer> n1 = new ArrayList<>(Arrays.asList(2, 3, 6));

        int k = 9;
        for (List<Integer> i : solve(n1, k)) {
            System.out.println(i.toString());
        }
    }

    private static List<List<Integer>> solve(List<Integer> n1, int k) {

        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getans(l1, n1, k, temp, 0);
        return l1;
    }

    private static void getans(List<List<Integer>> l1, List<Integer> n1, int k, List<Integer> temp, int sum) {
        if (sum == k) {
            l1.add(new ArrayList<>(temp));
            return;
        }
        if (sum > k) {
            return;
        }

        for (int i : n1) {
            temp.add(i);
            getans(l1, n1, k, temp, sum + temp.getLast());
            temp.removeLast();
            // getans(l1, n1, k, temp, sum);
        }

    }
}
